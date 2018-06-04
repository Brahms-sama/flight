package com.m2i.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.dao.IVolDao;
import com.m2i.entity.Localite;
import com.m2i.entity.Vol;
import com.m2i.service.IServiceVol;

@Service
@Transactional
public class ServiceVolImpl implements IServiceVol {
	
	@Autowired
	IVolDao dao;

	@Override
	public List<Vol> rechercherVolsAuDepart(Localite villeDepart, Date dateDepart) {
		return dao.findVolsByDeparture(villeDepart,dateDepart);
	}

	@Override
	public List<Vol> rechercherVolsEntre(Localite villeDepart, Localite villeArrivee) {
		return dao.findVolsBetween(villeDepart, villeArrivee);
	}

	@Override
	public Vol rechercherVolParNumero(Long num) {
		return dao.findVolById(num);
	}

	@Override
	public List<Localite> rechercherListeLocalites() {
		return dao.findAllLocalites();
	}

	@Override
	public void ajouterVol(Vol vol) {
		dao.insertVol(vol);
	}

	@Override
	public void modifierVol(Vol vol) {
		dao.updateVol(vol);
	}

	@Override
	public void supprimerVol(Long numeroVol) {
		dao.deleteVol(numeroVol);
	}

	@Override
	public List<Vol> rechercherTousLesVols() {
		return dao.findAllVols();
	}

}
