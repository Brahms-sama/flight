package com.m2i.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.dao.IReservationDao;
import com.m2i.entity.Client;
import com.m2i.entity.Personne;
import com.m2i.entity.Reservation;
import com.m2i.entity.Vol;
import com.m2i.service.IServiceClient;
import com.m2i.service.IServiceReservation;
import com.m2i.service.IServiceVol;

@Service
@Transactional
public class ServiceReservationImpl implements IServiceReservation {

	@Autowired
	IReservationDao dao;
	@Autowired
	IServiceClient serviceClient;
	@Autowired
	IServiceVol serviceVol;
	
	@Override
	public void nouvelleResa(Integer numClient, Long numVol, List<Personne> passagers) {
		Reservation resa = new Reservation();
		Client client = serviceClient.rechercherClientParId(numClient);
		Vol vol = serviceVol.rechercherVolParNumero(numVol);
		Date date = new Date();
		resa.setClient(client);
		resa.setVol(vol);
		resa.setDateResa(date);
		resa.setListePassagers(passagers);
		resa.setComment("Reservation Client n°"+numClient
				+"\nVol n°"+numVol
				+"\npour "+passagers.size()+" personne(s)");
		dao.insertResa(resa);
	}

	@Override
	public Reservation recherherResa(Long numResa) {
		return dao.findResaByNum(numResa);
	}

	@Override
	public List<Reservation> rechercherResaSelonClient(Integer numClient) {
		return dao.findResaByClient(numClient);
	}

	@Override
	public void modifierResa(Reservation resa) {
		dao.updateResa(resa);
	}

	@Override
	public void annulerResa(Reservation resa) {
		dao.deleteResa(resa.getIdResa());
	}

}
