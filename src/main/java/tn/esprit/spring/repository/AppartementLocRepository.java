package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.AppartementLocation;
@Repository
public interface AppartementLocRepository extends CrudRepository<AppartementLocation,Long>  {

}
