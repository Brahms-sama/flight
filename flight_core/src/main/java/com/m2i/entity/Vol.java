package com.m2i.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Vol")
@NamedQueries({
  @NamedQuery(name="Vol.findVolsByDeparture", 
		  query="SELECT v FROM Vol v WHERE v.depart.localite.ville = :ptown"),
  @NamedQuery(name="Vol.findVolsByDateDepart", 
          query="SELECT v FROM Vol v WHERE STR_TO_DATE(v.depart.dateTime, '%Y-%m-%d')  = :pdate")
})
public class Vol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long num;
	
	private Double prix;
	
	@Embedded
	@AssociationOverrides({
	 @AssociationOverride(name="localite",joinColumns={@JoinColumn(name="refLocDepart")})
	})
	@AttributeOverrides({
	  @AttributeOverride(name="dateTime",column=@Column(name="dateTimeDepart")),
	})
	private Phase depart;
	
	@Embedded
	@AssociationOverrides({
	 @AssociationOverride(name="localite",joinColumns={@JoinColumn(name="refLocArrivee")})
	})
	@AttributeOverrides({
	  @AttributeOverride(name="dateTime",column=@Column(name="dateTimeArrivee")),
	})
	private Phase arrivee;
	
	
	public Vol() {
		super();
	}
	public Vol(Long num, Double prix, Phase depart, Phase arrivee) {
		super();
		this.num = num;
		this.prix = prix;
		this.depart = depart;
		this.arrivee = arrivee;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Phase getDepart() {
		return depart;
	}
	public void setDepart(Phase depart) {
		this.depart = depart;
	}
	public Phase getArrivee() {
		return arrivee;
	}
	public void setArrivee(Phase arrivee) {
		this.arrivee = arrivee;
	}
	@Override
	public String toString() {
		return "Vol [num=" + num + ", prix=" + prix + ", depart=" + depart + ", arrivee=" + arrivee + "]";
	}
	
	

}