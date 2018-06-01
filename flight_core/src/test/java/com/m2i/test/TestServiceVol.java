package com.m2i.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.entity.Localite;
import com.m2i.entity.Phase;
import com.m2i.entity.Vol;
import com.m2i.service.IServiceVol;
import com.m2i.utils.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class TestServiceVol {
	
	@Autowired
	private IServiceVol service;
	private static Logger logger = LoggerFactory.getLogger(TestServiceClient.class);
	
//	public List<Vol> rechercherVolsAuDepart(Localite villeDepart, Date dateDepart);
//	public List<Vol> rechercherVolsEntre(Localite villeDepart, Localite villeArrivee);
//	public Vol rechercherVolParNumero(Long num);
//	public List<Localite> rechercherListeLocalites();
//	public void ajouterVol(Vol vol);
//	public void modifierVol(Vol vol);
//	public void supprimerVol(Long numeroVol);
	
	@Test
	public void testVol() {
		Vol v = service.rechercherVolParNumero(1L);
		logger.info(v.toString());
		Assert.assertEquals("", v.getDepart().getLocalite().getVille());
	}
	
	@Test
	public void testVolsAuDepart() {
		Localite l = new Localite("Paris", "CDG");
		Phase p = new Phase(l, DateUtil.dateFromString("2018-01-01"));
		List<Vol> vols = service.rechercherVolsAuDepart(p.getLocalite(), p.getDateTime());
		for(Vol v : vols) {
			logger.info(v.toString());
		}
		Assert.assertTrue(vols != null);
	}
	
	@Test
	public void testVolEntre() {
		Localite l1 = new Localite();
		l1.setVille("Paris");
		l1.setAeroport("CDG");
		
		Localite l2 = new Localite();
		l2.setVille("Dakar");
		l2.setAeroport("DKR");
		
		List<Vol> vols = service.rechercherVolsEntre(l1, l2);
		for(Vol v : vols) {
			logger.info(v.toString());
		}
		
		Assert.assertTrue(vols != null);
	}
	
	@Test
	public void testLocalites() {
		List<Localite> locs = service.rechercherListeLocalites();
		for (Localite l : locs ) {
			logger.info(l.toString());
		}
		Assert.assertTrue(locs != null);
	}
	
	@Test
	public void testAjouterVol() {
		Localite depart = new Localite("Oakland", "GSW");
		Phase p = new Phase(depart, DateUtil.dateFromString("2018-06-01"));
//		Vol v = new Vol(0, 300.0, depart, arrivee)
		
	}
	
	@Test
	public void testModifierVol() {
		
	}
	
	@Test
	public void testSupprimerVol() {
		
	}

}
