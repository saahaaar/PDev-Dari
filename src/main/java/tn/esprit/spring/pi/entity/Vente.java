package tn.esprit.spring.pi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Vente")
public class Vente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "")
	private Region region;
	@Column(name = "")
	private String adresse;
	@Column()
	private TypeBien typeBien;
	@Column()
	private Etat etat;
	@Column(name = "")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "")
	private float prix;
	@Column(name = "")
	private String photoV;
	@Column(name = "")
	private Long surface;
	@Column(name = "")
	private Long nbPiece;
	@Column(name = "")
	private Long nbChambre;

	@ManyToOne
	User user;

	@ManyToOne
	Bonus bonus;

	@OneToOne(mappedBy = "vente")
	private Commentaire commentaire;

	// @OneToMany
	// (cascade = CascadeType.ALL, mappedBy = "vente")
	// private List<Rating> rating = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Favoris> favoris;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Historique> historique;

	public Vente(Region region, String adresse, TypeBien typeBien, Etat etat, Date date, float prix, String photoV,
			Long surface, Long nbPiece, Long nbChambre, User user, Bonus bonus, Commentaire commentaire,
			Set<Favoris> favoris, Set<Historique> historique) {
		super();
		this.region = region;
		this.adresse = adresse;
		this.typeBien = typeBien;
		this.etat = etat;
		this.date = date;
		this.prix = prix;
		this.photoV = photoV;
		this.surface = surface;
		this.nbPiece = nbPiece;
		this.nbChambre = nbChambre;
		this.user = user;
		this.bonus = bonus;
		this.commentaire = commentaire;
		// this.rating = rating;
		this.favoris = favoris;
		this.historique = historique;
	}

	public Vente(Long id, Region region, String adresse, TypeBien typeBien, Etat etat, Date date, float prix,
			String photoV, Long surface, Long nbPiece, Long nbChambre, User user, Bonus bonus, Commentaire commentaire,
			 Set<Favoris> favoris, Set<Historique> historique) {
		super();
		this.id = id;
		this.region = region;
		this.adresse = adresse;
		this.typeBien = typeBien;
		this.etat = etat;
		this.date = date;
		this.prix = prix;
		this.photoV = photoV;
		this.surface = surface;
		this.nbPiece = nbPiece;
		this.nbChambre = nbChambre;
		this.user = user;
		this.bonus = bonus;
		this.commentaire = commentaire;
		//this.rating = rating;
		this.favoris = favoris;
		this.historique = historique;
	}

	public Vente() {
		super();
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public TypeBien getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getPhotoV() {
		return photoV;
	}

	public void setPhotoV(String photoV) {
		this.photoV = photoV;
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

	public Long getSurface() {
		return surface;
	}

	public void setSurface(Long surface) {
		this.surface = surface;
	}

	public Long getNbPiece() {
		return nbPiece;
	}

	public void setNbPiece(Long nbPiece) {
		this.nbPiece = nbPiece;
	}

	public Long getNbChambre() {
		return nbChambre;
	}

	public void setNbChambre(Long nbChambre) {
		this.nbChambre = nbChambre;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

//	public List<Rating> getRating() {
//		return rating;
//	}
//
//	public void setRating(List<Rating> rating) {
//		this.rating = rating;
//	}

}
