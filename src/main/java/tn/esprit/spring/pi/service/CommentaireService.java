package tn.esprit.spring.pi.service;

import java.util.List;

import tn.esprit.spring.pi.entity.Commentaire;

public interface CommentaireService {

	public List<Commentaire> retrieveAllRating();

	// public Rating addRating(Rating r);
	//
	// public void deleteRating(String id);
	//
	// public Rating updateRating(Rating r);

	public void BloqueVente();

}
