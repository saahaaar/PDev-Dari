package tn.esprit.spring.pi.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "")
public class Favoris implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany(mappedBy = "favoris", cascade = CascadeType.ALL)
	private Set<Vente> vente;
	@ManyToMany(mappedBy = "favoris", cascade = CascadeType.ALL)
	private Set<Location> location;
	@ManyToOne
	User user;

	public Favoris() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favoris(Long id, Set<Vente> vente, Set<Location> location, User user) {
		super();
		this.id = id;
		this.vente = vente;
		this.location = location;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Vente> getVente() {
		return vente;
	}

	public void setVente(Set<Vente> vente) {
		this.vente = vente;
	}

	public Set<Location> getLocation() {
		return location;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
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

}
