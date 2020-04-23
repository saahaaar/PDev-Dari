package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonIgnoreProperties("inspection")
@Entity
@DiscriminatorValue("VillaLocation")
public class VillaLocation extends Location{
	 private static final long serialVersionUID = 1L;
	 @Column(name="nbre_etage")
	   private long nbre_etage; 
	 @Column(name="garage")
	   private long garage; 
	 @Column(name="jardin")
	   private long jardin;
	 @Column(name="vue")
	   private String vue;
	 @Column(name="piscine")
	   private long piscine;
	public VillaLocation() {
		super();
	}
	public long getNbre_etage() {
		return nbre_etage;
	}
	public void setNbre_etage(long nbre_etage) {
		this.nbre_etage = nbre_etage;
	}
	public long getGarage() {
		return garage;
	}
	public void setGarage(long garage) {
		this.garage = garage;
	}
	public long getJardin() {
		return jardin;
	}
	public void setJardin(long jardin) {
		this.jardin = jardin;
	}
	public String getVue() {
		return vue;
	}
	public void setVue(String vue) {
		this.vue = vue;
	}
	public long getPiscine() {
		return piscine;
	}
	public void setPiscine(long piscine) {
		this.piscine = piscine;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}