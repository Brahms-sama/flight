package com.m2i.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@DiscriminatorValue("Client")
@NamedQueries({
@NamedQuery(name="Client.findClientById",
 query="SELECT cli FROM Client cli WHERE id = :id") ,
@NamedQuery(name="Client.findAuthClient",
 query="SELECT cli FROM Client cli WHERE username =:username AND password =:password")
})
public class Client extends Personne {
	
//	private Login login;
	private String login;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

//	public Login getLogin() {
//		return login;
//	}
//
//	public void setLogin(Login login) {
//		this.login = login;
//	}
	
	

	@Override
	public String toString() {
		return "Client [toString()=" + super.toString() + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getTelephone()=" + getTelephone()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	

}
