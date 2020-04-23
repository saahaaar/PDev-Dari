package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
	 private static final long serialVersionUID = 1L;
	    @Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private Long id; 
	    @Column(name="nom")
		private String nom; 
	    @Column(name="prenom")
		private String prenom; 
	    @Column(name="email")
		private String email; 
	    @Column(name="adresse")
		private String adresse;
	    @Column(name="numtel")
		private Long num_tel; 
	    @Column(name="password")
		private String password;
	    @OneToMany(mappedBy="user",cascade = CascadeType.REMOVE)
	    @JsonManagedReference(value="user")
	    private Set<Location> locations;
		public User() {
			super();
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
		public Long getNum_tel() {
			return num_tel;
		}
		public void setNum_tel(Long num_tel) {
			this.num_tel = num_tel;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Set<Location> getLocations() {
			return locations;
		}
		public void setLocations(Set<Location> locations) {
			this.locations = locations;
		}
		
}