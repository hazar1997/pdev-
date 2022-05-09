package tn.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Commantaire;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.repository.CommantaireRepository;
import tn.esprit.spring.repository.SujetRepository;

@Service
@Slf4j
public class CommantaireServiceImpl implements CommantaireService {

	@Autowired
	CommantaireRepository commentRepository;
	@Override
	public List<Commantaire> retrievAllComments() {
		List<Commantaire> comment =null;
		try {
			log.info("In method retrievAllProduits : ");
			log.debug("Conenction à la base de données : ");
			comment = commentRepository.findAll();
			log.debug("Le nombre total de Stocks : " + comment.size());
			for (Commantaire comments : comment) 
			{
				log.debug(" Sujet : " + comments.toString());
			}
			log.info("Out method retrievAllSujets without Errors");
		}
		catch (Exception e) {log.error("Error in retrievAllProduits : " + e);}
		return (comment);
	}

	@Override
	public Commantaire addComment(Commantaire c) {
		return commentRepository.save(c);
	}

	@Override
	public void deleteComment(Long id) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(id);

	}

	@Override
	public Commantaire updateComment(Commantaire c) {
		return commentRepository.save(c);
	}

	@Override
	public Commantaire retrieveComment(Long id) {
		// TODO Auto-generated method stub
		//return null;
		return (commentRepository.findById(id).get());
	}




	




}
