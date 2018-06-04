package com.m2i.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.m2i.dao.IReservationDao;
import com.m2i.entity.Reservation;

@Transactional
@Component
public class ReservationDaoImpl implements IReservationDao {

	@PersistenceContext(unitName="myPersistenceUnitName")
	private EntityManager entityManager;
	
	@Override
	public Reservation findResaByNum(Long numResa) {
		return entityManager.find(Reservation.class, numResa);
	}

	@Override
	public List<Reservation> findAllReservation() {
		return entityManager.createQuery("SELECT r FROM Reservation r", Reservation.class)
				.getResultList();
	}

	@Override
	public List<Reservation> findResaByClient(Integer numClient) {
		return entityManager.createNamedQuery("Resa.findResaByClient", Reservation.class)
				.setParameter("idClient",numClient)
				.getResultList();
	}

	@Override
	public void insertResa(Reservation resa) {
		entityManager.persist(resa);
	}

	@Override
	public void updateResa(Reservation resa) {
		entityManager.merge(resa);
	}

	@Override
	public void deleteResa(Long numResa) {
		Reservation resa = entityManager.find(Reservation.class, numResa);
		entityManager.remove(resa);
		
		
	}

}
