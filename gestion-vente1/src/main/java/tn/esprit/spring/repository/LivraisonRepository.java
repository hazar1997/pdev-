package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.LivraisonDTO;

@Repository

public interface LivraisonRepository extends CrudRepository<LivraisonDTO,Long>{
	
	@Query(value = "SELECT * FROM LivraisonDTO WHERE user_id= :user_id", nativeQuery = true)
	public LivraisonDTO getByUserId(@Param("user_id") long numCl);

}
