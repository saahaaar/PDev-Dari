package tn.esprit.spring.entity;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonIgnoreProperties("inspection")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_location")
public class Location implements Serializable {
	 private static final long serialVersionUID = 1L;
	  @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_loc")
   private Long id_loc; 
	  @Column(name="region")
	   private String region; 
	  @Column(name="adresse")
	   private String adresse; 
	  @Column(name="date_loc")
	   private Date date_loc; 
	  @Column(name="prix")
	   private long prix; 
	  @Column(name="description")
	   private String description; 
	  @Column(name="photo")
	   private String photo;
	  @Column(name="nbre_chambre")
	   private Long nbre_chambre; 
	 @Column(name="nbre_piece")
	   private Long nbre_piece; 
	 @Column(name="meuble")
	   private long meuble; 
	  @ManyToOne(fetch=FetchType.EAGER)
	  @JsonBackReference(value="user")
	  private User user;
	  @ManyToOne(fetch=FetchType.EAGER)
	  @JsonBackReference(value="abonnement")
	  private Abonnement abonnement;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Location(Long id_loc, String region, String adresse, Date date_loc, long prix, String description,
			String photo, Long nbre_chambre, Long nbre_piece, long meuble, User user, Abonnement abonnement) {
		super();
		this.id_loc = id_loc;
		this.region = region;
		this.adresse = adresse;
		this.date_loc = date_loc;
		this.prix = prix;
		this.description = description;
		this.photo = photo;
		this.nbre_chambre = nbre_chambre;
		this.nbre_piece = nbre_piece;
		this.meuble = meuble;
		this.user = user;
		this.abonnement = abonnement;
	}


	public Long getId_loc() {
		return id_loc;
	}

	public void setId_loc(Long id_loc) {
		this.id_loc = id_loc;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDate_loc() {
		return date_loc;
	}

	public void setDate_loc(Date date_loc) {
		this.date_loc = date_loc;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getNbre_chambre() {
		return nbre_chambre;
	}

	public void setNbre_chambre(Long nbre_chambre) {
		this.nbre_chambre = nbre_chambre;
	}

	public Long getNbre_piece() {
		return nbre_piece;
	}

	public void setNbre_piece(Long nbre_piece) {
		this.nbre_piece = nbre_piece;
	}

	public long getMeuble() {
		return meuble;
	}

	public void setMeuble(long meuble) {
		this.meuble = meuble;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Abonnement getAbonnement() {
		return abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}