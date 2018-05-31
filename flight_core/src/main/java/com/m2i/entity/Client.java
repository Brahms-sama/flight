package com.m2i.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Client")
@NamedQueries({ @NamedQuery(name = "Client.findClientById", query = "SELECT cli FROM Client cli WHERE cli.id = :id"),
		@NamedQuery(name = "Client.findAuthClient", query = "SELECT cli FROM Client cli WHERE cli.id =:username AND cli.id =:password") })
public class Client extends Personne {
	
	@OneToOne(mappedBy="client")
	private Login login;

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
