package com.m2i.dao;

import java.util.List;

import com.m2i.entity.Reservation;

public interface IReservationDao {
	
	public Reservation findResaByNum(Long numResa);
	
	public List<Reservation> findAllReservation();
	
	public List<Reservation> findResaByClient(Integer numClient);
	
	public void insertResa(Reservation resa);
	
	public void updateResa(Reservation resa);
	
	public void deleteResa(Long numResa);

}
