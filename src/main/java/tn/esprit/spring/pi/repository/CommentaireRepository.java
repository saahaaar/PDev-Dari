package tn.esprit.spring.pi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.pi.entity.Commentaire;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Long> {
}
