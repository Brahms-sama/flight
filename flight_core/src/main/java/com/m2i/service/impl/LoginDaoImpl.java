package com.m2i.service.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.m2i.dao.ILoginDao;
import com.m2i.entity.Login;

@Transactional
@Component
public class LoginDaoImpl implements ILoginDao {

	private EntityManager entityManager;
	
	@Override
	public Login findLoginByid(Integer id) {
		return entityManager.find(Login.class, id);
	}

	@Override
	public void updateLogin(Login login) {
		entityManager.merge(login);

	}

	@Override
	public void insertLogin(Login login) {
		entityManager.persist(login);
	}

	@Override
	public void deleteLogin(Integer id) {
		Login login = entityManager.find(Login.class, id);
		entityManager.remove(login);
	}

}
