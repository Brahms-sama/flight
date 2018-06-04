package com.m2i.service;

import java.util.Date;
import java.util.List;

import com.m2i.entity.Localite;
import com.m2i.entity.Vol;


public interface IServiceVol {

	public List<Vol> rechercherTousLesVols();
	public List<Vol> rechercherVolsAuDepart(Localite villeDepart, Date dateDepart);
	public List<Vol> rechercherVolsEntre(Localite villeDepart, Localite villeArrivee);
	public Vol rechercherVolParNumero(Long num);
	public List<Localite> rechercherListeLocalites();
	public void ajouterVol(Vol vol);
	public void modifierVol(Vol vol);
	public void supprimerVol(Long numeroVol);

}
