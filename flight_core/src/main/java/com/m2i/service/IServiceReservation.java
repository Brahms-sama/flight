package com.m2i.service;

import java.util.List;

import com.m2i.entity.Personne;
import com.m2i.entity.Reservation;

public interface IServiceReservation {
	
	public void nouvelleResa(Integer numClient, Long numVol, List<Personne> passagers);
	
	public Reservation recherherResa(Long numResa);
	
	public List<Reservation> rechercherResaSelonClient(Integer numClient);
	
	public void modifierResa(Reservation resa);
	
	public void annulerResa(Reservation resa);

}
