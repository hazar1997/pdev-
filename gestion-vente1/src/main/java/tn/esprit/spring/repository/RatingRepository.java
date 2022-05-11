package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {
	
	@Query(value = "SELECT count(*) FROM rating " + 
		   	   "WHERE user_id= :user_id AND prod_id= :produit_id", nativeQuery = true)
	public int verifRating(@Param("user_id") long numCl, @Param("produit_id") long numPr);
	
	//@Query(value = "UPDATE rating SET rating="
		//    UPDATE rating SET rating=5
		 //   WHERE prod_id=1 AND user_id= 1
		    
		 //   INSERT INTO `rating`(`id`, `rating`, `prod_id`, `user_id`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]')
 
			
			@Query(value = "DELETE FROM rating " + 
				   	   "WHERE user_id= :user_id AND produit_id= :produit_id", nativeQuery = true)
			public void delete(@Param("user_id") long numCl, @Param("produit_id") long numPr);
			
			@Query(value = "SELECT * FROM rating " + 
				   	   "WHERE user_id= :user_id AND prod_id= :produit_id", nativeQuery = true)
			public Rating getByUPid(@Param("user_id") long numCl, @Param("produit_id") long numPr);
			
			
			@Query(value = "SELECT rating FROM rating " + 
				   	   "WHERE user_id= :user_id AND prod_id= :produit_id", nativeQuery = true)
			public int getRating(@Param("user_id") long numCl, @Param("produit_id") long numPr);
			
}
