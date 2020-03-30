package tn.esprit.spring.pi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "")
	private String description;
	@Column(name = "")
	private int nbVues;
	@Column(name = "")
	private int nbLikes;
	@Column(name = "")
	private int nbDislikes;

	@ManyToOne
	private Vente vente;

	
	public Commentaire() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Commentaire(String description, int nbVues, int nbLikes, int nbDislikes, Vente vente) {
		super();
		this.description = description;
		this.nbVues = nbVues;
		this.nbLikes = nbLikes;
		this.nbDislikes = nbDislikes;
		this.vente = vente;
	}

	public Commentaire(Long id, String description, int nbVues, int nbLikes, int nbDislikes, Vente vente) {
		super();
		this.id = id;
		this.description = description;
		this.nbVues = nbVues;
		this.nbLikes = nbLikes;
		this.nbDislikes = nbDislikes;
		this.vente = vente;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbVues() {
		return nbVues;
	}

	public void setNbVues(int nbVues) {
		this.nbVues = nbVues;
	}

	public int getNbLikes() {
		return nbLikes;
	}

	public void setNbLikes(int nbLikes) {
		this.nbLikes = nbLikes;
	}

	public int getNbDislikes() {
		return nbDislikes;
	}

	public void setNbDislikes(int nbDislikes) {
		this.nbDislikes = nbDislikes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

}
