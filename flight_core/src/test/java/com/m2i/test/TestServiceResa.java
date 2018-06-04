package com.m2i.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.entity.Personne;
import com.m2i.entity.Reservation;
import com.m2i.service.IServiceClient;
import com.m2i.service.IServiceReservation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class TestServiceResa {
	
	@Autowired
	private IServiceReservation serviceResa;
	@Autowired
	private IServiceClient serviceClient;
	
	

	private static Logger logger = LoggerFactory.getLogger(TestServiceResa.class);
	
//public void nouvelleResa(Integer numClient, Long numVol, List<Personne> passagers);
	@Test
	public void testNouvelleResa() {
		List<Personne> passagers = new ArrayList<>();
		passagers.add(serviceClient.rechercherClientParId(1));
		passagers.add(serviceClient.rechercherClientParId(2));
		serviceResa.nouvelleResa(1, 1L, passagers);
	}
	
//	public Reservation recherherResa(Long numResa);
	@Test
	public void testRechercheResa() {
		Reservation resa = serviceResa.recherherResa(2L);
		logger.info(resa.toString());
		Assert.assertEquals(resa.getComment(), "RESA2");
	}
	
//	public List<Reservation> rechercherResaSelonClient(Integer numClient);
	@Test
	public void testRechercheResaSelonClient() {
		List<Reservation> resas = serviceResa.rechercherResaSelonClient(1);
		for(Reservation resa : resas) {
			logger.info(resa.toString());
		}
		Assert.assertTrue(resas.size()==2);
		
	}
	
//	public void modifierResa(Reservation resa);
	@Test
	public void testModifierResa() {
		Reservation resa = serviceResa.recherherResa(1L);
		resa.setComment("RESERVATION1");
		serviceResa.modifierResa(resa);
		Reservation nresa = serviceResa.recherherResa(1L);
		logger.info(nresa.getComment());
		Assert.assertEquals("RESERVATION1",nresa.getComment());
	}
	
//	public void annulerResa(Reservation resa);
	@Test
	public void testAnnulerResa() {
		Reservation resa = serviceResa.recherherResa(3L);
		serviceResa.annulerResa(resa);
		Reservation nresa = serviceResa.recherherResa(3L);
		Assert.assertTrue(nresa == null);
		
	}
}
