package tn.esprit.spring.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.pi.entity.Etat;
import tn.esprit.spring.pi.entity.Commentaire;
import tn.esprit.spring.pi.entity.TypeBien;
import tn.esprit.spring.pi.entity.Vente;
import tn.esprit.spring.pi.service.CommentaireService;
import tn.esprit.spring.pi.service.VenteService;

@RestController
public class VenteController {

	@Autowired
	VenteService us;
	@Autowired
	CommentaireService rs;

	// afficher tous les ventes
	// http://localhost:8081/SpringMVC/Servlet/retrieve-all-vente
	@GetMapping("/retrieve-all-vente")
	@ResponseBody
	public List<Vente> retrieveAllVente() {
		List<Vente> list = us.retrieveAllVente();
		return list;
	}

	// afficher tous les rating
	// http://localhost:8081/SpringMVC/Servlet/retrieve-all-rating
	@GetMapping("/retrieve-all-rating")
	@ResponseBody
	public List<Commentaire> retrieveAllRating() {
		List<Commentaire> list = rs.retrieveAllRating();
		return list;
	}

	// afficher les ventes vendus
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/vendu
	@GetMapping("/retrieve-vente/vendu")
	@ResponseBody
	public List<Vente> retrieveAllMaisonVendu() {
		List<Vente> list = us.retrieveAllVenteVendu(Etat.values()[0]);
		return list;
	}

	// afficher les ventes encore disponibles
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/dispo
	@GetMapping("/retrieve-vente/dispo")
	@ResponseBody
	public List<Vente> retrieveAllMaisonDispo() {
		List<Vente> list = us.retrieveAllVenteDispo(Etat.values()[1]);
		return list;
	}

	// afficher les Villas
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/villa
	@GetMapping("/retrieve-vente/villa")
	@ResponseBody
	public List<Vente> retrieveAllVilla() {
		List<Vente> list = us.retrieveAllVilla(TypeBien.values()[0]);
		return list;
	}

	// afficher les Appartements
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/appartement
	@GetMapping("/retrieve-vente/appartement")
	@ResponseBody
	public List<Vente> retrieveAllAppartement() {
		List<Vente> list = us.retrieveAllAppartement(TypeBien.values()[1]);
		return list;
	}

	// afficher les Maisons
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/maison
	@GetMapping("/retrieve-vente/maison")
	@ResponseBody
	public List<Vente> retrieveAllMaison() {
		List<Vente> list = us.retrieveAllMaison(TypeBien.values()[2]);
		return list;
	}

	// afficher les Terrains
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/terrain
	@GetMapping("/retrieve-vente/terrain")
	@ResponseBody
	public List<Vente> retrieveAllTerrain() {
		List<Vente> list = us.retrieveAllTerrain(TypeBien.values()[3]);
		return list;
	}

	// // afficher tous les Maisons
	// // http://localhost:8081/SpringMVC/Servlet/retrieve-all-vente/type/{type}
	// @GetMapping("/retrieve-all-vente/type/{type}")
	// @ResponseBody
	// public List<Vente> retrieveAllVenteMaison(@PathVariable("type") String
	// typeBien) {
	// List<Vente> list = us.retrieveAllVenteMaison(TypeBien.valueOf(typeBien));
	// return list;
	// }

	// afficher une seule vente avec l'id
	// http://localhost:8081/SpringMVC/Servlet/retrieve-vente/{vente-id}
	@GetMapping("/retrieve-vente/{vente-id}")
	@ResponseBody
	public Vente retrieveVente(@PathVariable("vente-id") String id) {
		return us.retrieveVente(id);
	}

	// ajouter une vente
	// http://localhost:8081/SpringMVC/Servlet/add-vente
	@PostMapping("/add-vente")
	@ResponseBody
	public Vente AddVente(@RequestBody Vente u) {
		Vente Vente = us.addVente(u);
		return Vente;
	}

	// modifier une vente
	// http://localhost:8081/SpringMVC/Servlet/modify-vente
	@PutMapping("/modify-vente")
	@ResponseBody
	public Vente modifyVente(@RequestBody Vente Vente) {
		return us.updateVente(Vente);
	}

	// supprimer une vente
	// http://localhost:8081/SpringMVC/Servlet/remove-vente/{id}
	@DeleteMapping("/remove-vente/{id}")
	@ResponseBody
	public void removeVente(@PathVariable("id") String id) {
		us.deleteVente(id);
	}

	// afficher les nombres des ventes
	// http://localhost:8081/SpringMVC/Servlet/count-vente
	@GetMapping("/count-vente")
	@ResponseBody
	public int countVente() {
		return us.countVente();
	}

	// afficher les nombres des ventes
	// http://localhost:8081/SpringMVC/Servlet/count-vente
	@PutMapping("/bloque-vente")
	@ResponseBody
	public void BloqueVente() {
		rs.BloqueVente();
	}

}
