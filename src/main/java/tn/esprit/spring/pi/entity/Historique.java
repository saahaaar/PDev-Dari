package tn.esprit.spring.pi.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Historique implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany(mappedBy = "historique", cascade = CascadeType.ALL)
	private Set<Vente> vente;
	@ManyToMany(mappedBy = "historique", cascade = CascadeType.ALL)
	private Set<Location> location;
	@ManyToOne
	User user;

	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Historique(Long id, Set<Vente> vente, Set<Location> location, User user) {
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
