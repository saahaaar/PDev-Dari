package tn.esprit.spring.pi.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.pi.entity.Etat;
import tn.esprit.spring.pi.entity.TypeBien;
import tn.esprit.spring.pi.entity.Vente;
import tn.esprit.spring.pi.repository.CommentaireRepository;
import tn.esprit.spring.pi.repository.VenteRepository;

@Service
public class VenteServiceImpl implements VenteService {

	@Autowired
	VenteRepository VenteRepository;
	CommentaireRepository RatingRepository;

	private static final Logger l = LogManager.getLogger(VenteServiceImpl.class);

	@Override
	public List<Vente> retrieveAllVente() {
		return (List<Vente>) VenteRepository.findAll();
	}

	@Override
	public List<Vente> retrieveAllVenteDispo(Etat etat) {
		return VenteRepository.retrieveAllVenteDispo();
	}

	@Override
	public List<Vente> retrieveAllVenteVendu(Etat etat) {
		return VenteRepository.retrieveAllVenteVendu();
	}

	@Override
	public List<Vente> retrieveAllVenteMaison(TypeBien bien) {
		return VenteRepository.retrieveAllVenteMaisonn(bien);
	}

	@Override
	public List<Vente> retrieveAllVilla(TypeBien typeBien) {
		return VenteRepository.retrieveAllVilla();
	}

	@Override
	public List<Vente> retrieveAllAppartement(TypeBien typeBien) {
		return VenteRepository.retrieveAllAppartement();
	}

	@Override
	public List<Vente> retrieveAllMaison(TypeBien typeBien) {
		return VenteRepository.retrieveAllMaison();
	}

	@Override
	public List<Vente> retrieveAllTerrain(TypeBien typeBien) {
		return VenteRepository.retrieveAllTerrain();
	}

	@Override
	public Vente addVente(Vente v) {
		return VenteRepository.save(v);
	}

	@Override
	public void deleteVente(String id) {
		VenteRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Vente updateVente(Vente v) {
		return VenteRepository.save(v);
	}

	@Override
	public Vente retrieveVente(String id) {
		return VenteRepository.findById(Long.parseLong(id)).orElse(null);
	}

	@Override
	public int countVente() {
		int max = 0;
		List<Vente> app = (List<Vente>) VenteRepository.findAll();
		for (Vente vente : app) {
			max++;

		}
		l.info(" you have " + max + "appointments");

		return max;

	}

	// public void BloqueVente() {
	//
	// List<Vente> ratManagedEntity = (List<Vente>) VenteRepository.findAll();
	//
	// int vent = ratManagedEntity.size();
	// for (int index = 0; index < vent; index++) {
	// Rating rat = ratManagedEntity.get(index).getRating();
	// if (rat.getNbDislikes() >= 2) {
	//
	// ratManagedEntity.get(index).setEtat(Etat.values()[2]);
	//
	// } else {
	// ratManagedEntity.get(index).setEtat(Etat.values()[1]);
	//
	// }
	//
	// }
	//
	// VenteRepository.saveAll(ratManagedEntity);
	// for (Rating aa : com) {
	// for (Vente ee : zz) {
	// if (aa.getNbDislikes() >= 2) {
	//
	// ee.setEtat(Etat.values()[2]);
	// VenteRepository.save(ee);
	//
	// } else {
	// ee.setEtat(Etat.values()[1]);
	// }
	// System.out.println("oooooooooooooooooooooooooooooooo");
	// }
	// }
	// }

}
