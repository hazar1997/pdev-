package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Facture;

public interface FactureService {
	
	List<Facture> retrieveAllFactures();
	Facture addFacture(Facture c);
	void deleteFacture(Long Num);

	Facture updateFacture(Facture c);

	Facture retrieveFacture(long NumFacture);


	
}



