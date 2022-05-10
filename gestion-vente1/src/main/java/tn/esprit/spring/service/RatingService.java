package tn.esprit.spring.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Rating;
import tn.esprit.spring.repository.RatingRepository;

@Service
@Transactional
public class RatingService {

	RatingRepository ratingRepository;
	
	public Rating addRating(Rating r) {
		return ratingRepository.save(r);
	}
	
	public void delete(Rating r) {
		 ratingRepository.delete(r);
	}
	
	public int verifRating(long user_id, long prod_id) {
		return ratingRepository.verifRating(user_id, prod_id);
	}
	
	
}
