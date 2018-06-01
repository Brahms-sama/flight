package com.m2i.dao;

import java.util.Date;
import java.util.List;

import com.m2i.entity.Localite;
import com.m2i.entity.Vol;

public interface IVolDao {
	
	public Vol findVolById(Long id);
	public void updateVol(Vol vol);
	public void insertVol(Vol vol);
	public void deleteVol(Long id);
	List<Vol> findVolsBetween(Localite depart, Localite arrivee);
	List<Localite> findAllLocalites();
	List<Vol> findVolsByDeparture(Localite ville, Date date);

}
