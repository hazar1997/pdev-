package tn.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.repository.SujetRepository;

@Service
@Slf4j
public class SujetServiceImpl implements SujetService {

	@Autowired
	SujetRepository sujetRepository;
	@Override
	public List<Sujet> retrievAllSujets() {
		List<Sujet> sujets =null;
		try {
			log.info("In method retrievAllProduits : ");
			log.debug("Conenction à la base de données : ");
			sujets = sujetRepository.findAll();
			log.debug("Le nombre total de Stocks : " + sujets.size());
			for (Sujet sujet : sujets) 
			{
				log.debug(" Sujet : " + sujet.toString());
			}
			log.info("Out method retrievAllSujets without Errors");
		}
		catch (Exception e) {log.error("Error in retrievAllProduits : " + e);}
		return (sujets);
	}

	@Override
	public Sujet addSujet(Sujet c) {
		return sujetRepository.save(c);
	}

	@Override
	public void deleteSujet(Long id) {
		// TODO Auto-generated method stub
		sujetRepository.deleteById(id);

	}

	@Override
	public Sujet updateSujet(Sujet c) {
		return sujetRepository.save(c);
	}

	@Override
	public Sujet retrieveSujet(Long id) {
		// TODO Auto-generated method stub
		//return null;
		return (sujetRepository.findById(id).get());
	}




	




}
