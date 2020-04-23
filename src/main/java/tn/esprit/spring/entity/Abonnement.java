package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="abonnement")
public class Abonnement implements Serializable{
	 private static final long serialVersionUID = 1L;
	  @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
  private Long id; 
	  @Column(name="type_ab")
	  private String type_ab; 
	  @Column(name="date_ab")
	  private Date date_ab; 
	  @Column(name="date_ab_des")
	  private Date date_ab_des;
	  @OneToMany(mappedBy="abonnement",cascade = CascadeType.REMOVE)
	  @JsonManagedReference(value="abonnement")
	  private Set<Location> locations;
	public Abonnement() {
		super();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType_ab() {
		return type_ab;
	}
	public void setType_ab(String type_ab) {
		this.type_ab = type_ab;
	}
	public Date getDate_ab() {
		return date_ab;
	}
	public void setDate_ab(Date date_ab) {
		this.date_ab = date_ab;
	}
	public Date getDate_ab_des() {
		return date_ab_des;
	}
	public void setDate_ab_des(Date date_ab_des) {
		this.date_ab_des = date_ab_des;
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
