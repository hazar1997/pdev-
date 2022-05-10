package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Ligne_Commande;

@Repository
public interface LigneCommandeRepository extends JpaRepository<Ligne_Commande, Long> {
	
	@Query(value = "SELECT SUM(quantite), p.categorie " + 
			 		   "FROM ligne_commande lc, produit p " + 
			 		   "WHERE lc.id = p.id GROUP BY p.categorie  ", nativeQuery = true)
	public List<Object[]> sellersByCategorie();

}
