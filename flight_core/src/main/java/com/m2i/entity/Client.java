package com.m2i.entity;

public class Client extends Personne {
	
	Login login;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Client [toString()=" + super.toString() + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getTelephone()=" + getTelephone()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	

}
