package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;

import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.FactureRepository;
@Service
public class DetailFactureServiceImp implements DetailFactureService{

	@Autowired  
	DetailFactureRepository dFR;  
	
	@Autowired  
	FactureRepository fR;
	
	@Override
	public List<DetailFacture> getAllDetailFacture() {
		List<DetailFacture> DetailFactures = new ArrayList<DetailFacture>();  
		this.dFR.findAll().forEach(dfr1 -> DetailFactures.add(dfr1));  
		return DetailFactures;
	}


	@Override
	public DetailFacture updateDetailFacture(DetailFacture df) {
		this.dFR.save(df);
		return(df);
	}

	@Override
	public Optional<DetailFacture> retrieveDetailFacture(Long id) {
		return Optional.ofNullable(this.dFR.findById(id).get());
	}

	
}
