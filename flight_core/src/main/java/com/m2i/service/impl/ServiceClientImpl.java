package com.m2i.service.impl;

import com.m2i.dao.IClientDao;
import com.m2i.entity.Client;
import com.m2i.entity.Login;
import com.m2i.service.IServiceClient;

public class ServiceClientImpl implements IServiceClient {
	
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
		return null;

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
