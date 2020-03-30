package tn.esprit.spring.pi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Location")
// @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name="")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "")
	private Region region;
	@Column(name = "")
	private String adresseL;
	@Column(name = "")
	private TypeBien typeBien;
	@Column(name = "")
	private TypeLocation typeLocation;
	@Temporal(TemporalType.DATE)
	private Date dateL;
	@Column(name = "")
	private String descriptionL;
	@Column(name = "")
	private String photoL;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Favoris> favoris;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Historique> historique;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(Long id, Region region, String adresseL, TypeBien typeBien, TypeLocation typeLocation, Date dateL,
			String descriptionL, String photoL, Set<Favoris> favoris, Set<Historique> historique) {
		super();
		this.id = id;
		this.region = region;
		this.adresseL = adresseL;
		this.typeBien = typeBien;
		this.typeLocation = typeLocation;
		this.dateL = dateL;
		this.descriptionL = descriptionL;
		this.photoL = photoL;
		this.favoris = favoris;
		this.historique = historique;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getAdresseL() {
		return adresseL;
	}

	public void setAdresseL(String adresseL) {
		this.adresseL = adresseL;
	}

	public TypeBien getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}

	public TypeLocation getTypeLocation() {
		return typeLocation;
	}

	public void setTypeLocation(TypeLocation typeLocation) {
		this.typeLocation = typeLocation;
	}

	public Date getDateL() {
		return dateL;
	}

	public void setDateL(Date dateL) {
		this.dateL = dateL;
	}

	public String getDescriptionL() {
		return descriptionL;
	}

	public void setDescriptionL(String descriptionL) {
		this.descriptionL = descriptionL;
	}

	public String getPhotoL() {
		return photoL;
	}

	public void setPhotoL(String photoL) {
		this.photoL = photoL;
	}

	public Set<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(Set<Favoris> favoris) {
		this.favoris = favoris;
	}

	public Set<Historique> getHistorique() {
		return historique;
	}

	public void setHistorique(Set<Historique> historique) {
		this.historique = historique;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
