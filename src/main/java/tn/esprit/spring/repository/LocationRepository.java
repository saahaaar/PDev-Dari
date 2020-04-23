package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Location;
@Repository
public interface LocationRepository extends CrudRepository<Location,Long>  {

	@Query("SELECT l FROM Location l WHERE l.date_loc< :date_loc")
	public List<Location> locinfdate(@Param("date_loc") Date date_loc);
	@Query("SELECT l FROM Location l WHERE l.date_loc> :date_loc")
	public List<Location> locsupdate(@Param("date_loc") Date date_loc);
	@Query("SELECT l FROM Location l WHERE l.date_loc>= :date_locinf AND l.date_loc<= :date_locsup")
	public List<Location> locentredate(@Param("date_locinf") Date date_locinf ,@Param("date_locsup") Date date_locsup);
	@Query("SELECT l FROM Location l WHERE l.prix<= :prix")
	public List<Location> locinfprix(@Param("prix") Long prix);
	@Query("SELECT l FROM Location l WHERE l.prix>= :prix")
	public List<Location> locsupprix(@Param("prix") Long prix);
	@Query("SELECT l FROM Location l WHERE l.prix>= :prixinf AND l.prix<= :prixsup")
	public List<Location> locentreprix(@Param("prixinf") Long prixinf,@Param("prixsup") Long prixsup);
}
