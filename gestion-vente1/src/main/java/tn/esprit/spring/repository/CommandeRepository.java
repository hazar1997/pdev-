package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{
	
	@Query(value = "SELECT YEAR(date_reception), MONTH(date_reception), SUM(total_cost) " + 
	 		   "FROM commande " + 
	 		   " GROUP BY MONTH(date_reception), YEAR(date_reception) ORDER BY MONTH(date_reception) ", nativeQuery = true)
	public List<Object[]> sellersByDate();

	    
	@Query(value = "SELECT u.country, SUM(c.total_cost) FROM commande c, user u WHERE c.ref_client = u.id " +
	                "GROUP BY u.country " +
	    		    "ORDER BY c.total_cost " +
	    		    "LIMIT 10", nativeQuery = true)
	public List<Object[]> sellersByCountry();
}

