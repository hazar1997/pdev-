package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dto.ListProductDto;
import tn.esprit.spring.dto.ProductByIdDto;
import tn.esprit.spring.dto.ProductWithRatingDto;
import tn.esprit.spring.service.ProduitServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	ProduitServiceImpl produitService;
	
	@GetMapping("get") 
	@ResponseBody
	public ResponseEntity<ListProductDto> listOfAllProductWithRating(){
		ListProductDto lp = new ListProductDto();
		lp.setAllpro(produitService.listOfAllProductWithRating());
		lp.setMostLikedProduct(produitService.mostLikedProduct());
		lp.setElecCateg(produitService.filterProductByCategorieLimit("electronique"));
		lp.setTabTelCatg(produitService.filterProductByCategorie("telephone&tablette"));
		
		return new ResponseEntity<>(lp, HttpStatus.OK);
	}
	
	@GetMapping("get/{prod_Id}")
	@ResponseBody
	public ResponseEntity<ProductByIdDto> produitByIdWithRating(@PathVariable("prod_Id") long prod_id) {
		ProductByIdDto prById = new ProductByIdDto();
		prById.setProdById(produitService.produitByIdWithRating(prod_id));
		prById.setMostLiked(produitService.mostLikedProduct());
		
		return new ResponseEntity<>(prById, HttpStatus.OK);
	}
	
	@GetMapping("filter_product")
	@ResponseBody
	public ResponseEntity<ListProductDto> filterProductByCategorie(@RequestParam("categ") String categ){
		String x=categ;
		ListProductDto lp = new ListProductDto();
		lp.setAllpro(produitService.filterProductByCategorie(x));
		return new ResponseEntity<>(lp, HttpStatus.OK);
	}
	
	@GetMapping("recherche_product")
	@ResponseBody
	public ResponseEntity<List<ProductWithRatingDto>> rechercheProducts(@RequestParam("x") String x){
		List<ProductWithRatingDto> lp = produitService.rechercheProducts(x);
		return new ResponseEntity<>(lp, HttpStatus.OK);
	}


}
