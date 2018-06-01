package com.m2i.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.m2i.dao.IVolDao;
import com.m2i.entity.Localite;
import com.m2i.entity.Vol;

public class VolDaoImpl implements IVolDao {

	private EntityManager entityManager;
	
	@Override
	public Vol findVolById(Long id) {
		return entityManager.find(Vol.class, id);
	}
	
	@Override
	public List<Vol> findVolsByDeparture(Localite ville, Date date){
		return entityManager.createNamedQuery("Vol.findVolsByDepartureAndDate",Vol.class)
				.setParameter("ptown", ville)
				.setParameter("pdate", date)
				.getResultList();
	}
	
	@Override
	public List<Vol> findVolsBetween(Localite depart, Localite arrivee){
		return entityManager.createNamedQuery("Vol.find ",Vol.class)
				.setParameter("pdepart", depart)
				.setParameter("parrivee", arrivee)
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

	

}
