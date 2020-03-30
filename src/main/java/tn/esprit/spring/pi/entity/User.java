package tn.esprit.spring.pi.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "")
@Component
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "")
	private String nom;
	@Column(name = "")
	private String prenom;
	@Column(name = "")
	private String email;
	@Column(name = "")
	private String adresse;
	@Column(name = "")
	private Long telephone;
	@Column(name = "")
	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Historique> historique;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Vente> Vente;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Favoris> favoris;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public User(Long id, String nom, String prenom, String email, String adresse, Long telephone, String password,
			Set<Historique> historique, Set<Favoris> favoris) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
		this.password = password;
		this.historique = historique;
		this.favoris = favoris;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Historique> getHistorique() {
		return historique;
	}

	public void setHistorique(Set<Historique> historique) {
		this.historique = historique;
	}

	public Set<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(Set<Favoris> favoris) {
		this.favoris = favoris;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
