package com.m2i.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.m2i.dao.IVolDao;
import com.m2i.entity.Localite;
import com.m2i.entity.Vol;

@Transactional
@Component
public class VolDaoImpl implements IVolDao {

	@PersistenceContext(unitName="myPersistenceUnitName")
	private EntityManager entityManager;
	
	@Override
	public Vol findVolById(Long id) {
		return entityManager.find(Vol.class, id);
	}
	
	@Override
	public List<Vol> findVolsByDeparture(Localite localite, Date date){
		return entityManager.createNamedQuery("Vol.findVolsByDepartureAndDate",Vol.class)
				.setParameter("ptown", localite.getVille())
				.setParameter("pdate", date)
				.getResultList();
	}
	
	@Override
	public List<Vol> findVolsBetween(Localite depart, Localite arrivee){
		return entityManager.createNamedQuery("Vol.findVolsBetween",Vol.class)
				.setParameter("pdepart", depart.getVille())
				.setParameter("parrivee", arrivee.getVille())
				.getResultList();
	}
	
	@Override
	public void updateVol(Vol vol) {
		entityManager.persist(vol);
	}

	@Override
	public void insertVol(Vol vol) {
		entityManager.merge(vol);
	}

	@Override
	public void deleteVol(Long id) {
		Vol vol = entityManager.find(Vol.class, id);
		entityManager.remove(vol);
	}

	@Override
	public List<Localite> findAllLocalites(){
		return entityManager.createQuery("SELECT l FROM Localite l", Localite.class)
				.getResultList();
	}

	@Override
	public List<Vol> findAllVols() {
		return entityManager.createQuery("SELECT v FROM Vol v",Vol.class).getResultList();
	}

	

}
