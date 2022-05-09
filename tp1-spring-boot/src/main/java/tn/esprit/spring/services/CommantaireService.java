package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Commantaire;
import tn.esprit.spring.entity.Sujet;

public interface CommantaireService {
	
	List<Commantaire>retrievAllComments();
	Commantaire addComment(Commantaire c);
	void deleteComment(Long id);
	Commantaire updateComment(Commantaire c);
	Commantaire retrieveComment(Long id);
	

}
