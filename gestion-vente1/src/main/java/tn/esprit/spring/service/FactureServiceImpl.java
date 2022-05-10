package tn.esprit.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.repository.FactureRepository;

@Service
@Transactional
public class FactureServiceImpl implements FactureService {
	@Autowired
    FactureRepository factureRepository ;
	
	@Override
	public List<Facture> retrieveAllFactures() {
		return ( List<Facture>)factureRepository.findAll();
	}

	@Override
	public Facture addFacture(Facture c) {
		
		return factureRepository.save(c);
				
	}

	@Override
	public void deleteFacture(Long Num) {
		factureRepository.deleteById(Num);
		
	}

	@Override
	public Facture updateFacture(Facture c) {
		
		return factureRepository.save(c);
	}

	@Override
	public Facture retrieveFacture(long NumFacture) {
		Facture c= factureRepository.findById(NumFacture).get();
		return c;
	}
	
	}

	
	