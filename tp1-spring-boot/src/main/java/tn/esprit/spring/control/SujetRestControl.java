package tn.esprit.spring.control;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Commantaire;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.repository.SujetRepository;
import tn.esprit.spring.services.EmailService;
import tn.esprit.spring.services.SujetService;

@RestController
@RequestMapping("/sujet")
@Api(tags = "Gestion Sujet")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SujetRestControl {

	//couplage faible 
	@Autowired
	SujetService sujetService;
	@Autowired
	EmailService emailService;
	@Autowired
	private SujetRepository sujetRepository;

	// URL : http://localhost:8081/SpringMVC/sujet/retrieve-all-sujets
	@GetMapping("/retrieve-all-sujets")
	public List<Sujet> retrieveAllSujets() 
	{
		List<Sujet> list = sujetService.retrievAllSujets();
		return list ;
	}

	//@EventListener(ApplicationReadyEvent.class)
	@PostMapping("/add-sujet")
	public Sujet addSujet(@RequestBody Sujet p)  
	{
		
		emailService.sendEmail("firas.benaissa@gmail.com", "Sujet ajoutee avec succ�s " +p.getLibelleSujet(), "Sujet ajoutee avec succ�s");
		//emailService.sendEmail("consomitounsi8@gmail.com", "sdqsd", "qsdqsds");
		return sujetService.addSujet(p);
	}
	


	@PutMapping("/modify-sujet/{sujet-id}")
	public ResponseEntity<Sujet> modifySujet(@PathVariable("sujet-id") Long sujetId,@RequestBody Sujet sujett) {
		Sujet s = sujetRepository.findById(sujetId)
				.get();
		//emailService.sendEmail("firas.benaissa@gmail.com", "Sujet modifié avec succ�s", "Sujet modifié avec succ�s");
		s.setIdSujet(sujett.getIdSujet());
		s.setLibelleSujet(sujett.getLibelleSujet());
		Sujet updateSujet = sujetRepository.save(s);
		return ResponseEntity.ok(updateSujet);
	}

	@DeleteMapping("/remove-sujet/{sujet-id}")
	public void removeSujet(@PathVariable("sujet-id") Long sujetId) 
	{
		emailService.sendEmail("firas.benaissa@gmail.com", "Sujet supprimeé avec succ�s", "Sujet supprimeé avec succ�s");
		sujetService.deleteSujet(sujetId);
	}

	
	@GetMapping("/retrieve-sujet/{sujet-id}")
	public Sujet retrieveSujet(@PathVariable("sujet-id") Long sujetId) 
	{
		return sujetService.retrieveSujet(sujetId);
	}
	
	@GetMapping("/retrieve-all-comments/{sujetId}")
	public Set<Commantaire> retrieveAllSujets(@PathVariable("sujetId") Long sujetId) 
	{
		Sujet s = sujetRepository.findById(sujetId).get();
		Set<Commantaire> list = s.getCommantaires();
		return list ;
	}
}
