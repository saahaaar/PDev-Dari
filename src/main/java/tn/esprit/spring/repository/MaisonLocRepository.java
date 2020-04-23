package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.MaisonLocation;
@Repository
public interface MaisonLocRepository extends CrudRepository<MaisonLocation,Long> {

}
