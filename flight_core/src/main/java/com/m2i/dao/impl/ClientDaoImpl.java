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
		return entityManager.createNamedQuery(
				"Client.findByNumWithComptes" , Client.class)
				.setParameter("id", id)
	            .getSingleResult();
	}

	@Override
	public List<Client> findAllClient() {
		return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
	}

	@Override
	public void insertClient(Client client) {
		entityManager.persist(client);
	}

	@Override
	public void updateClient(Client client) {
		entityManager.merge(client);
	}

	@Override
	public void deleteClient(Integer id) {
		Client client = entityManager.find(Client.class, id);
		entityManager.remove(client);
	}

}
