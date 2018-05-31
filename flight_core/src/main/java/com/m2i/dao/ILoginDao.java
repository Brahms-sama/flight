package com.m2i.dao;

import com.m2i.entity.Login;

public interface ILoginDao {
	
	public Login findLoginByid(Integer id);
	public void updateLogin(Login login);
	public void insertLogin(Login login);
	public void deleteLogin(Integer id);

}
