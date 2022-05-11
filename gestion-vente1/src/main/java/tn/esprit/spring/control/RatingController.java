package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.config.ApiResponse;
import tn.esprit.spring.dto.CheckoutItemDto;
import tn.esprit.spring.dto.RatingDto;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.LivraisonDTO;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Rating;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RatingRepository;
import tn.esprit.spring.service.LivraisonService;
import tn.esprit.spring.service.UserServiceImpl;

@RestController
@RequestMapping("/rating")
public class RatingController{
	
	@Autowired
	RatingRepository  ratingRepo;

    @Autowired
    UserServiceImpl userService;

	 @Autowired
	 ProduitRepository produitRepository; 

	
	@CrossOrigin(origins= "http://localhost:4200")
	@PostMapping(value="/post",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ApiResponse> add(@RequestParam("user_id") long id, @RequestBody RatingDto rating) {
		User user = userService.getUserById(id);
		Produit p = produitRepository.getById(rating.getProd_id());
		Rating r = new Rating();
		r.setProduit(p);
		r.setUser(user);
		r.setRating(rating.getRating());
		if( ratingRepo.verifRating(id, rating.getProd_id()) != 0) {
			ratingRepo.delete(ratingRepo.getByUPid(id, rating.getProd_id()));
			ratingRepo.save(r);
		}
		else {
			ratingRepo.save(r);
		}
	return new ResponseEntity<>(new ApiResponse(true, "ok"), HttpStatus.OK);

	}

	

	@CrossOrigin(origins= "http://localhost:4200")
	@PostMapping("/get")
	@ResponseBody
	public  ResponseEntity<RatingDto> rating(@RequestParam("user_id") long id, @RequestBody RatingDto rating) {
		RatingDto r = new RatingDto(); 
		if( ratingRepo.verifRating(id, rating.getProd_id()) != 0) {
			r.setRating(ratingRepo.getRating(id, rating.getProd_id()));
		}else {
			r.setRating(0);
		}
		return new ResponseEntity<>(r, HttpStatus.OK);
	}
}

