package com.m2i.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.m2i.dao.IClientDao;
import com.m2i.entity.Client;

@Transactional
@Component
public class ClientDaoImpl implements IClientDao {
	
	@PersistenceContext(unitName="myPersistenceUnitName")
	private EntityManager entityManager;

	@Override
	public Client findClientByNumero(Integer id) {
		return null;
	}

	@Override
	public List<Client> findAllClient() {
		return null;
	}

	@Override
	public void insertClient(Client client) {

	}

	@Override
	public void updateClient(Client client) {

	}

	@Override
	public void deleteClient(Integer id) {

	}

}
