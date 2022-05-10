package tn.esprit.spring.service;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.ProductWithRatingDto;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.ProduitRepository;

@Service
public class ProduitServiceImpl {
	
	 @Autowired
	 ProduitRepository produitRepository;


	public Produit findById(long produitId) {
        Produit p = produitRepository.getById(produitId);
        return p;
    }
	
	public List<ProductWithRatingDto> listOfAllProductWithRating() {
		List<Object[]> list_p = produitRepository.listOfAllProductWithRating();
		List<ProductWithRatingDto> list_pr = new ArrayList<>();
		
		for (Object[] p : list_p) {
			
			ProductWithRatingDto pr = new ProductWithRatingDto();
			pr.setProd_id((BigInteger) p[0]);
			pr.setDescription((String) p[1]);
			pr.setImageUrl((String) p[2]);
			pr.setName((String) p[3]);
			pr.setPrice((double) p[4]);
			pr.setCategorie((String) p[5]);
			pr.setNbrRating((BigInteger) p[6]);
			pr.setRating((BigDecimal) p[7]);
			
			list_pr.add(pr);
		}
		return list_pr;
	}
	
	public ProductWithRatingDto produitByIdWithRating(long prod_id) {
		
		List<Object[]> pro = produitRepository.produitByIdWithRating(prod_id);
		ProductWithRatingDto pr = new ProductWithRatingDto();
		
		for (Object[] p : pro) {
			pr.setProd_id((BigInteger) p[0]);
			pr.setDescription((String) p[1]);
			pr.setImageUrl((String) p[2]);
			pr.setName((String) p[3]);
			pr.setPrice((double) p[4]);
			pr.setCategorie((String) p[5]);
			pr.setNbrRating((BigInteger) p[6]);
			pr.setRating((BigDecimal) p[7]);
			break;
		}
		return pr;	
	}

	public List<ProductWithRatingDto> mostLikedProduct(){
		
		List<Object[]> list_p = produitRepository.mostLikedProduct();
		List<ProductWithRatingDto> list_pr = new ArrayList<>();
		
		for (Object[] p : list_p) {
			
			ProductWithRatingDto pr = new ProductWithRatingDto();
			pr.setProd_id((BigInteger) p[0]);
			pr.setDescription((String) p[1]);
			pr.setImageUrl((String) p[2]);
			pr.setName((String) p[3]);
			pr.setPrice((double) p[4]);
			pr.setCategorie((String) p[5]);
			pr.setNbrRating((BigInteger) p[6]);
			pr.setRating((BigDecimal) p[7]);
			
			list_pr.add(pr);
		}
		return list_pr;
	}
	
	public List<ProductWithRatingDto> filterProductByCategorie(String categ){
		List<Object[]> list_p = produitRepository.filterProductByCategorie(categ);
		List<ProductWithRatingDto> list_pr = new ArrayList<>();
		
		for (Object[] p : list_p) {
			
			ProductWithRatingDto pr = new ProductWithRatingDto();
			pr.setProd_id((BigInteger) p[0]);
			pr.setDescription((String) p[1]);
			pr.setImageUrl((String) p[2]);
			pr.setName((String) p[3]);
			pr.setPrice((double) p[4]);
			pr.setCategorie((String) p[5]);
			pr.setNbrRating((BigInteger) p[6]);
			pr.setRating((BigDecimal) p[7]);
			
			list_pr.add(pr);
		}
		return list_pr;
	}
	
	public List<ProductWithRatingDto> filterProductByCategorieLimit(String categ){
		List<Object[]> list_p = produitRepository.filterProductByCategorie(categ);
		List<ProductWithRatingDto> list_pr = new ArrayList<>();
		
		for (Object[] p : list_p) {
			
			ProductWithRatingDto pr = new ProductWithRatingDto();
			pr.setProd_id((BigInteger) p[0]);
			pr.setDescription((String) p[1]);
			pr.setImageUrl((String) p[2]);
			pr.setName((String) p[3]);
			pr.setPrice((double) p[4]);
			pr.setCategorie((String) p[5]);
			pr.setNbrRating((BigInteger) p[6]);
			pr.setRating((BigDecimal) p[7]);
			
			list_pr.add(pr);
		}
		return list_pr;
	}
	public List<ProductWithRatingDto> triProductsByPrice(){
		List<Object[]> list_p = produitRepository.triProductsByPrice();
		List<ProductWithRatingDto> list_pr = new ArrayList<>();
		
		for (Object[] p : list_p) {
			
			ProductWithRatingDto pr = new ProductWithRatingDto();
			pr.setProd_id((BigInteger) p[0]);
			pr.setDescription((String) p[1]);
			pr.setImageUrl((String) p[2]);
			pr.setName((String) p[3]);
			pr.setPrice((double) p[4]);
			pr.setCategorie((String) p[5]);
			pr.setNbrRating((BigInteger) p[6]);
			pr.setRating((BigDecimal) p[7]);
			
			list_pr.add(pr);
		}
		return list_pr;
	}
	public List<ProductWithRatingDto> rechercheProducts(String x){
		List<Object[]> list_p = produitRepository.rechercheProducts(x);
		List<ProductWithRatingDto> list_pr = new ArrayList<>();
		
		for (Object[] p : list_p) {
			
			ProductWithRatingDto pr = new ProductWithRatingDto();
			pr.setProd_id((BigInteger) p[0]);
			pr.setDescription((String) p[1]);
			pr.setImageUrl((String) p[2]);
			pr.setName((String) p[3]);
			pr.setPrice((double) p[4]);
			pr.setCategorie((String) p[5]);
			pr.setNbrRating((BigInteger) p[6]);
			pr.setRating((BigDecimal) p[7]);
			
			list_pr.add(pr);
		}
		return list_pr;
	}
}

