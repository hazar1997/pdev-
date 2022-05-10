package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier,Long> {

		
	@Query(value = "SELECT count(*) FROM Panier WHERE user_id= :user_id", nativeQuery = true)
    public int nbr_Element(@Param("user_id") long numCl);

	@Query(value = "SELECT pa.id, pa.quantite, pa.user_id, pa.produit_id " + 
 		   "FROM Panier pa, Produit pr " + 
 		   "WHERE pa.produit_id = pr.id " +
 		   "AND pa.user_id= :user_id", nativeQuery = true)
    public List<Panier> get_Elment_List(@Param("user_id") long numCl);

	@Modifying(clearAutomatically = true)
	@Transactional()
	@Query(value = "DELETE FROM Panier " + 
	 		   	   "WHERE user_id= :user_id AND produit_id= :produit_id", nativeQuery = true)
	public void delete_Element(@Param("user_id") long numCl, @Param("produit_id") long numPr);
	
	@Modifying
	@Transactional()
	@Query(value = "DELETE FROM Panier " + 
		   	   "WHERE user_id= :user_id", nativeQuery = true)
	public void delete_All_Element_from_panier(@Param("user_id") long num_client);

	@Query(value = "SELECT count(*) FROM Panier " + 
		   	   "WHERE user_id= :user_id AND produit_id= :produit_id", nativeQuery = true)
	public int verif_Produit(@Param("user_id") long numCl, @Param("produit_id") long numPr);
	
	@Modifying
	@Transactional()
	@Query(value="UPDATE panier SET quantite=quantite+1 WHERE user_id= :user_id AND produit_id= :produit_id", nativeQuery = true)
	public void ubdateQtePlus(@Param("user_id") long numCl, @Param("produit_id") long numPr);
	
	@Modifying
	@Transactional()
	@Query(value="UPDATE panier SET quantite=quantite-1 WHERE user_id= :user_id AND produit_id= :produit_id", nativeQuery = true)
	public void ubdateQteMinus(@Param("user_id") long numCl, @Param("produit_id") long numPr);
	
	
	@Query(value = "SELECT count(*) FROM Panier " + 
		   	   "WHERE user_id= :user_id ", nativeQuery = true)
	public int countProductByUser(@Param("user_id") long numCl);
	
	
}
