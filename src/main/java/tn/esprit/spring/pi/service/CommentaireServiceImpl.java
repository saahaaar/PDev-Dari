package tn.esprit.spring.pi.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.pi.entity.Commentaire;
import tn.esprit.spring.pi.entity.Etat;
import tn.esprit.spring.pi.entity.Vente;
import tn.esprit.spring.pi.repository.CommentaireRepository;
import tn.esprit.spring.pi.repository.VenteRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	CommentaireRepository RatingRepository;
	@Autowired
	VenteRepository VenteRepository;

	private static final Logger l = LogManager.getLogger(CommentaireServiceImpl.class);

	@Override
	public List<Commentaire> retrieveAllRating() {
		return (List<Commentaire>) RatingRepository.findAll();
	}

	@Override
	public void BloqueVente() {

		List<Commentaire> com = (List<Commentaire>) RatingRepository.findAll();
		List<Vente> zz = (List<Vente>) VenteRepository.findAll();

		for (Commentaire aa : com) {
			for (Vente ee : zz) {
				if (aa.getNbDislikes() >= 2) {
					ee.setEtat(Etat.values()[2]);
					VenteRepository.save(ee);

				}
			}

		}

	}

}
