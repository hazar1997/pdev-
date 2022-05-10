package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dto.ProductWithRatingDto;
import tn.esprit.spring.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long>{

	//for statistique
	@Query(value = "SELECT YEAR(date_reception), MONTH(date_reception), SUM(total_cost) " + 
	 		   "FROM commande " + 
	 		   " GROUP BY MONTH(date_reception), YEAR(date_reception) ", nativeQuery = true)
	    public List<Object[]> sellersByDate();
	    

	@Query(value = "SELECT produit.id, `description`, `imageurl`, `name`, `price`, `categorie`, COUNT(*) as nbrRating, SUM(rating.rating)/COUNT(*) as x "
	    	+ " FROM produit "
	    	+ "LEFT JOIN rating ON produit.id = rating.prod_id "
	    	+ "GROUP BY produit.id", nativeQuery = true)
	    public List<Object[]> listOfAllProductWithRating();
	    

	    
	@Query(value = "SELECT produit.id, description, imageurl, name, price, categorie, COUNT(*) as nbrRating, SUM(rating.rating)/COUNT(*) as x " +
	    "FROM `produit`, rating " +
	    "WHERE produit.id = rating.prod_id "+
	    "AND produit.id = :prod_id", nativeQuery = true)
	public List<Object[]> produitByIdWithRating(@Param("prod_id") long numPr);
	
	@Query(value = "SELECT produit.id, `description`, `imageurl`, `name`, `price`, `categorie`, COUNT(*) as nbrRating, SUM(rating.rating)/COUNT(*) as x \r\n"
			+ "FROM `produit`\r\n"
			+ "LEFT JOIN rating ON produit.id = rating.prod_id\r\n"
			+ "GROUP BY produit.id\r\n"
			+ "ORDER BY  x DESC, nbrRating DESC\r\n"
			+ "LIMIT 8", nativeQuery = true)
	public List<Object[]> mostLikedProduct();
	
	@Query(value = "SELECT produit.id, `description`, `imageurl`, `name`, `price`, `categorie`, COUNT(*) as nbrRating, SUM(rating.rating)/COUNT(*) as x \r\n"
			+ "FROM `produit`\r\n"
			+ "LEFT JOIN rating ON produit.id = rating.prod_id\r\n"
			+ "WHERE categorie= :categ\r\n"
			+ "GROUP BY produit.id\r\n"
			+ "ORDER BY  x DESC, nbrRating DESC\r\n"
			+ "LIMIT 8", nativeQuery = true)
	public List<Object[]> filterProductByCategorieLimit(@Param("categ") String categ);
	
	@Query(value = "SELECT produit.id, `description`, `imageurl`, `name`, `price`, `categorie`, COUNT(*) as nbrRating, SUM(rating.rating)/COUNT(*) as x \r\n"
			+ "FROM `produit`\r\n"
			+ "LEFT JOIN rating ON produit.id = rating.prod_id\r\n"
			+ "GROUP BY produit.id\r\n"
			+ "ORDER BY  price ASC, x DESC, nbrRating DESC", nativeQuery = true)
	public List<Object[]> triProductsByPrice();
	
	@Query(value = "SELECT produit.id, `description`, `imageurl`, `name`, `price`, `categorie`, COUNT(*) as nbrRating, SUM(rating.rating)/COUNT(*) as x \r\n"
			+ "FROM `produit`\r\n"
			+ "LEFT JOIN rating ON produit.id = rating.prod_id\r\n"
			+ "WHERE categorie= :categ "
			+ "GROUP BY produit.id\r\n"
			+ "ORDER BY  x DESC, nbrRating DESC\r\n", nativeQuery = true)
	public List<Object[]> filterProductByCategorie(@Param("categ") String categ);
	
	@Modifying
	@Transactional
	@Query(value = "SELECT produit.id, `description`, `imageurl`, `name`, `price`, `categorie`,COUNT(*) as nbrRating, SUM(rating.rating)/COUNT(*) as x"
			+ " FROM produit "+ "LEFT JOIN rating ON produit.id = rating.prod_id\r\n"
			+ "WHERE description LIKE CONCAT('%',?1,'%') or name LIKE CONCAT('%',?1,'%')", nativeQuery = true)
	public List<Object[]> rechercheProducts(String x);
	    
}




