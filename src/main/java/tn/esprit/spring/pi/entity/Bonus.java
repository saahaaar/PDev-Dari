package tn.esprit.spring.pi.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Bonus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "")
	private Boolean meuble;
	@Column(name = "")
	private Boolean balcon;
	@Column(name = "")
	private Boolean jardin;
	@Column(name = "")
	private Boolean piscine;
	@Column(name = "")
	private Boolean sousSol;
	@Column(name = "")
	private Boolean parking;
	@Column(name = "")
	private Boolean etage;
	@Column(name = "")
	private Boolean ascenseur;
	@Column()
	private Standing standing;

	//@OneToMany(mappedBy = "bonus", cascade = CascadeType.ALL)
//	private Set<Vente> Ventes;

	public Bonus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bonus(Long id, Boolean meuble, Boolean balcon, Boolean jardin, Boolean piscine, Boolean sousSol,
			Boolean parking, Boolean etage, Boolean ascenseur, Standing standing,
			Set<tn.esprit.spring.pi.entity.Vente> Vente) {
		super();
		this.id = id;
		this.meuble = meuble;
		this.balcon = balcon;
		this.jardin = jardin;
		this.piscine = piscine;
		this.sousSol = sousSol;
		this.parking = parking;
		this.etage = etage;
		this.ascenseur = ascenseur;
		this.standing = standing;
		
	}

	public Boolean getPiscine() {
		return piscine;
	}

	public void setPiscine(Boolean piscine) {
		this.piscine = piscine;
	}

	public Boolean getSousSol() {
		return sousSol;
	}

	public void setSousSol(Boolean sousSol) {
		this.sousSol = sousSol;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean getEtage() {
		return etage;
	}

	public void setEtage(Boolean etage) {
		this.etage = etage;
	}

	public Boolean getAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(Boolean ascenseur) {
		this.ascenseur = ascenseur;
	}

	public Standing getStanding() {
		return standing;
	}

	public void setStanding(Standing standing) {
		this.standing = standing;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getMeuble() {
		return meuble;
	}

	public void setMeuble(Boolean meuble) {
		this.meuble = meuble;
	}

	public Boolean getBalcon() {
		return balcon;
	}

	public void setBalcon(Boolean balcon) {
		this.balcon = balcon;
	}

	public Boolean getJardin() {
		return jardin;
	}

	public void setJardin(Boolean jardin) {
		this.jardin = jardin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
