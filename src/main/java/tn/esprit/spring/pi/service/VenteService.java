package tn.esprit.spring.pi.service;

import java.util.List;

import tn.esprit.spring.pi.entity.Etat;
import tn.esprit.spring.pi.entity.TypeBien;
import tn.esprit.spring.pi.entity.Vente;

public interface VenteService {

	public List<Vente> retrieveAllVente();

	public Vente addVente(Vente u);

	public void deleteVente(String id);

	public Vente updateVente(Vente u);

	public Vente retrieveVente(String id);

	public int countVente();

	public List<Vente> retrieveAllVenteMaison(TypeBien bien);

	public List<Vente> retrieveAllVenteVendu(Etat etat);

	public List<Vente> retrieveAllVenteDispo(Etat etat);

	public List<Vente> retrieveAllVilla(TypeBien typeBien);

	public List<Vente> retrieveAllAppartement(TypeBien typeBien);

	public List<Vente> retrieveAllMaison(TypeBien typeBien);

	public List<Vente> retrieveAllTerrain(TypeBien typeBien);

}
