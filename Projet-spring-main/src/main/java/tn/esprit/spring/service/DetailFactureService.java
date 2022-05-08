package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;


public interface DetailFactureService {

	List<DetailFacture> getAllDetailFacture();
	
	DetailFacture updateDetailFacture(DetailFacture f);

	Optional<DetailFacture> retrieveDetailFacture(Long id);

}
