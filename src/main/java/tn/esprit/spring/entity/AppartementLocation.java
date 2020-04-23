package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonIgnoreProperties("inspection")
@Entity
@DiscriminatorValue("AppartementLocation")
public class AppartementLocation extends Location {
	 private static final long serialVersionUID = 1L;
	 @Column(name="etage")
	   private long etage; 
	 @Column(name="parking")
	   private long parking; 
	 @Column(name="surface_enfant")
	   private long surface_enfant;

	public AppartementLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getEtage() {
		return etage;
	}

	public void setEtage(long etage) {
		this.etage = etage;
	}

	public long getParking() {
		return parking;
	}

	public void setParking(long parking) {
		this.parking = parking;
	}

	public long getSurface_enfant() {
		return surface_enfant;
	}

	public void setSurface_enfant(long surface_enfant) {
		this.surface_enfant = surface_enfant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}