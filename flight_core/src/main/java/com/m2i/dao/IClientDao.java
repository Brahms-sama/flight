package com.m2i.dao;

import java.util.List;

import com.m2i.entity.Client;

/**
 * @author Administrateur
 *	Interface ClientDAO
 */
public interface IClientDao {
	/**Recherche de client par id
	 * @param id
	 * @return Client
	 */
	public Client findClientByNumero(Integer id);
    /**
     * @return liste de tous les clients
     */
    public List<Client> findAllClient();
    /**
     * @param client
     */
    public void insertClient(Client client);
    /**
     * @param client
     */
    public void updateClient(Client client);
    /**
     * @param id
     */
    public void deleteClient(Integer id);
    
    public Client findAuthClient(String username, String password);
}
