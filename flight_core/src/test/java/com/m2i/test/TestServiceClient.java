package com.m2i.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.entity.Client;
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
		logger.info("\t->" + client);
		Assert.assertEquals("Ibrahim",client.getPrenom());
		
	}
	
	
}
