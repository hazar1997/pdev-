package tn.esprit.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.LivraisonDTO;
import tn.esprit.spring.repository.LivraisonRepository;

@Service
@Transactional
public class LivraisonService {

	@Autowired
	LivraisonRepository livrRepository;
	
	public LivraisonDTO addLivraisonDetail(LivraisonDTO c) {
		
		return livrRepository.save(c);
				
	}
	
	public LivraisonDTO getLivraisonByUserId(long user_id) {
		return this.livrRepository.getByUserId(user_id);
		
	}
	
	//public LivraisonDTO get(long id ) {

		//return this.livrRepository.findByuserId
	//}
}
