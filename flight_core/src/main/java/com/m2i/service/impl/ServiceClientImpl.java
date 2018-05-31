package com.m2i.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.dao.IClientDao;
import com.m2i.entity.Client;
import com.m2i.entity.Login;
import com.m2i.service.IServiceClient;

@Service
@Transactional
public class ServiceClientImpl implements IServiceClient {
	
	@Autowired
	IClientDao dao;

	@Override
	public Client rechercherClientParId(Integer id) {
		return dao.findClientByNumero(id);
	}

	@Override
	public void enregistrerNouveauClient(Client client, Login login) {
		dao.insertClient(client);

	}

	@Override
	public Client authentifierClient(String username, String password) {
		return dao.findAuthClient(username, password);
	}

	@Override
	public void modifierCoordClient(Client client) {
		dao.updateClient(client);
	}

	@Override
	public void supprimerInfosClient(Client client) {
		dao.deleteClient(client.getId());
	}

}
