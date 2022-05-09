package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Sujet;

public interface SujetService {
	
	List<Sujet>retrievAllSujets();
	Sujet addSujet(Sujet c);
	void deleteSujet(Long id);
	Sujet updateSujet(Sujet c);
	Sujet retrieveSujet(Long id);
	
	

}
