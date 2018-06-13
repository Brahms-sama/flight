package com.m2i.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Client")
@NamedQueries({ @NamedQuery(name = "Client.findClientById", query = "SELECT cli FROM Client cli WHERE cli.id = :id"),
		@NamedQuery(name = "Client.findAuthClient", query = "SELECT cli FROM Client cli WHERE cli.login.username =:username AND cli.login.password =:password") })
public class Client extends Personne {
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="login")
	private Login login;

	public Client() {
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
