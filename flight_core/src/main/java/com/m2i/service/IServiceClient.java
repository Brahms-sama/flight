package com.m2i.service;

import java.util.List;

import com.m2i.entity.Client;
import com.m2i.entity.Login;

public interface IServiceClient {
	
	public Client rechercherClientParId(Integer id);
	public void enregistrerNouveauClient(Client client, Login login);
	public Client authentifierClient(String username, String password);
	public void modifierCoordClient(Client client);
	public void supprimerInfosClient(Client client);
	public List<Client> listeClients();

}
