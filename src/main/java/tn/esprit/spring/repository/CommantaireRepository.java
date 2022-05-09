package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Commantaire;
import tn.esprit.spring.entity.Sujet;

@Repository
public interface CommantaireRepository extends JpaRepository<Commantaire, Long> {
	
	

}
