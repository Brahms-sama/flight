package com.m2i.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.entity.Adresse;
import com.m2i.entity.Client;
import com.m2i.entity.Login;
import com.m2i.service.IServiceClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class TestServiceClient {
	
	@Autowired
	private IServiceClient service; 
	

	private static Logger logger = LoggerFactory.getLogger(TestServiceClient.class);
	
	@Test
	public void testClients() {
		Client client = service.rechercherClientParId(1);
		Assert.assertEquals("Ibrahim",client.getPrenom());
		logger.info("\t->" + client);
		
	}
	
	@Test
	public void testModifierClient() {
		Client client = service.rechercherClientParId(1);
		logger.info("\tClient :" + client);
		client.setTelephone("0143302504");
		service.modifierCoordClient(client);
		Client newClient = service.rechercherClientParId(1);
		Assert.assertEquals(newClient.getTelephone(),client.getTelephone());
		logger.info("\tNouveau Client :" + client);
		
	}

	@Test
	public void testAdresse() {
		Client client = service.rechercherClientParId(1);
		logger.info(client.getAdresse().toString());
		Assert.assertEquals("Picasso", client.getAdresse().getNom());
	}
	
	@Test
	public void testLogin() {
		Client client = service.rechercherClientParId(1);
		logger.info(client.toString());
		logger.info(client.getLogin().toString());
		Assert.assertEquals("Picasso", client.getAdresse().getNom());
	}
	
	@Test
	public void testSupprimerClient() {
		Client client = service.rechercherClientParId(3);
		service.supprimerInfosClient(client);
		Assert.assertEquals(service.listeClients().size(),2);
	}
	
	@Test
	public void testEnregistrementClient() {
		Client client = new Client();
		client.setNom("Terrieur");
		client.setPrenom("Alain");
		client.setEmail("alinterieur@mail.com");
		client.setTelephone("0654878956");
		
		Adresse adresse = new Adresse();
		adresse.setNumero(21);
		adresse.setNom("Place de l Ellipse");
		adresse.setCodePostal("92100");
		adresse.setVille("Nanterre");
		adresse.setPays("France");
		adresse.setPersonne(client);
		
		client.setAdresse(adresse);
		
		Login login = new Login();
		login.setUsername("inside");
		login.setPassword("pwd");
		
		
		service.enregistrerNouveauClient(client, login);
		Client newClient = service.rechercherClientParId(4);
		logger.info(newClient.toString());
	}
	
	@Test
	public void testAuthClient() {
		Client client = service.authentifierClient("brahms", "toto");
		Assert.assertTrue(client != null);
		Assert.assertEquals(client.getPrenom(), "Ibrahim");
	}
	
}
