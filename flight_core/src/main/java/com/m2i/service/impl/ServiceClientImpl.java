package com.m2i.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.dao.IClientDao;
import com.m2i.dao.ILoginDao;
import com.m2i.entity.Client;
import com.m2i.entity.Login;
import com.m2i.service.IServiceClient;

@Service
@Transactional
public class ServiceClientImpl implements IServiceClient {

	@Autowired
	IClientDao daoClient;

	@Override
	public Client rechercherClientParId(Integer id) {
		return daoClient.findClientByNumero(id);
	}

	@Override
	public void enregistrerNouveauClient(Client client, Login login) {
		daoClient.insertClient(client);
		login.setClient(client);
		client.setLogin(login);
	}

	@Override
	public Client authentifierClient(String username, String password) {
		return daoClient.findAuthClient(username, password);
	}

	@Override
	public void modifierCoordClient(Client client) {
		daoClient.updateClient(client);
	}

	@Override
	public void supprimerInfosClient(Client client) {
		daoClient.deleteClient(client.getId());
	}

	@Override
	public List<Client> listeClients() {
		return daoClient.findAllClient();
	}

}
