package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonIgnoreProperties("inspection")
@Entity
@DiscriminatorValue("MaisonLocation")
public class MaisonLocation extends Location {
	 private static final long serialVersionUID = 1L;
	 @Column(name="terrasse")
	   private long terrasses; 
	 @Column(name="espaceVoiture")
	   private long espaceVoiture;
	
	public MaisonLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MaisonLocation(Long id_loc, String region, String adresse, Date date_loc, long prix, String description,
			String photo, Long nbre_chambre, Long nbre_piece, long meuble, User user, Abonnement abonnement,
			long terrasses, long espaceVoiture) {
		super(id_loc, region, adresse, date_loc, prix, description, photo, nbre_chambre, nbre_piece, meuble, user,
				abonnement);
		this.terrasses = terrasses;
		this.espaceVoiture = espaceVoiture;
	}




	public long getTerrasses() {
		return terrasses;
	}

	public void setTerrasse(long terrasses) {
		this.terrasses = terrasses;
	}

	public long getEspaceVoiture() {
		return espaceVoiture;
	}

	public void setEspaceVoiture(long espaceVoiture) {
		this.espaceVoiture = espaceVoiture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}