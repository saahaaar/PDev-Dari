package tn.esprit.spring.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.pi.entity.TypeBien;
import tn.esprit.spring.pi.entity.Vente;

@Repository
public interface VenteRepository extends CrudRepository<Vente, Long> {

	// @Query("SELECT
	// v.adresse,v.typeBien,v.date,v.nbPiece,v.nbChambre,v.prix,v.region,b.balcon,b.jardin,b.parking
	// FROM Vente v JOIN Bonus b WHERE 'typeBien'='villa' ")
	// public List<Vente> retrieveAllVenteMaisonn();

	@Query(nativeQuery = true, value = "select"
			+ " v.id,v.bonus_id,v.adresse,v.type_Bien,v.date,v.user_id,v.etat,v.photov,v.surface,v.nb_piece,v.nb_chambre,v.prix,v.region,b.balcon,b.jardin,b.parking FROM Vente v "
			+ "JOIN Bonus b " + "where v.type_Bien=:typeBien")
	public List<Vente> retrieveAllVenteMaisonn(@Param("typeBien") TypeBien typeBien);

	@Query(nativeQuery = true, value = "select" + " * FROM Vente v " + "where v.etat=0")
	public List<Vente> retrieveAllVenteVendu();

	@Query(nativeQuery = true, value = "select" + " * FROM Vente v " + "where v.etat=1")
	public List<Vente> retrieveAllVenteDispo();

	@Query(nativeQuery = true, value = "select" + " * FROM Vente v " + "where v.type_Bien=0")
	public List<Vente> retrieveAllVilla();

	@Query(nativeQuery = true, value = "select" + " * FROM Vente v " + "where v.type_Bien=1")
	public List<Vente> retrieveAllAppartement();

	@Query(nativeQuery = true, value = "select" + " * FROM Vente v " + "where v.type_Bien=2")
	public List<Vente> retrieveAllMaison();

	@Query(nativeQuery = true, value = "select" + " * FROM Vente v " + "where v.type_Bien=3")
	public List<Vente> retrieveAllTerrain();

}
