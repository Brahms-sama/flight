package com.m2i.test;

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
@ContextConfiguration(locations = "/beans.xml")
public class TestServiceVol {

	@Autowired
	private IServiceVol service;
	private static Logger logger = LoggerFactory.getLogger(TestServiceVol.class);


	// public Vol rechercherVolParNumero(Long num);
	@Test
	public void testVol() {
		Vol v = service.rechercherVolParNumero(1L);
		logger.info(v.toString());
		Assert.assertEquals("Paris", v.getDepart().getLocalite().getVille());
	}

	// public List<Vol> rechercherVolsAuDepart(Localite villeDepart, Date dateDepart);
	@Test
	public void testVolsAuDepart() {
		Localite l = new Localite("Paris", "CDG");
		Phase p = new Phase(l, DateUtil.dateFromString("2018-01-01"));
		List<Vol> vols = service.rechercherVolsAuDepart(p.getLocalite(), p.getDateTime());
		for (Vol v : vols) {
			logger.info(v.toString());
		}
		Assert.assertTrue(vols != null);
	}

	// public List<Vol> rechercherVolsEntre(Localite villeDepart, Localite villeArrivee);
	@Test
	public void testVolEntre() {
		Localite l1 = new Localite();
		l1.setVille("Paris");
		l1.setAeroport("CDG");

		Localite l2 = new Localite();
		l2.setVille("Dakar");
		l2.setAeroport("DKR");

		List<Vol> vols = service.rechercherVolsEntre(l1, l2);
		for (Vol v : vols) {
			logger.info(v.toString());
		}

		Assert.assertTrue(vols != null);
	}

	// public List<Localite> rechercherListeLocalites();
	@Test
	public void testLocalites() {
		List<Localite> locs = service.rechercherListeLocalites();
		for (Localite l : locs) {
			logger.info(l.toString());
		}
		Assert.assertTrue(locs != null);
	}

	// public void ajouterVol(Vol vol);
	@Test
	public void testAjouterVol() {
		Localite depart = new Localite("Oakland", "GSW");
		Phase pdepart = new Phase(depart, DateUtil.dateFromString("2018-06-01"));
		Localite arrivee = new Localite("Oakland", "GSW");
		Phase parrivee = new Phase(arrivee, DateUtil.dateFromString("2018-06-02"));
		Vol v = new Vol(5L, 300.0, pdepart, parrivee);
		service.ajouterVol(v);
		Vol newVol = service.rechercherVolParNumero(5L);
		logger.info(newVol.toString());
		Assert.assertTrue(newVol.getPrix() == 300.0);
	}

	// public void modifierVol(Vol vol);
	@Test
	public void testModifierVol() {
		Vol vol = service.rechercherVolParNumero(1L);
		vol.setPrix(150.0);
		service.modifierVol(vol);
		logger.info(vol.getPrix().toString());
	}

	// public void supprimerVol(Long numeroVol);
	@Test
	public void testSupprimerVol() {
		Vol vol = service.rechercherVolParNumero(6L);
		logger.info(vol.toString());
		service.supprimerVol(6L);
		Vol newVol =  service.rechercherVolParNumero(6L);
		Assert.assertTrue(newVol == null);
	}

}
