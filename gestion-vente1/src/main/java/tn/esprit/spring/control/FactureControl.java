package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.service.FactureService;


@RestController
@RequestMapping("/factures")
public class FactureControl {
	
	@Autowired
	FactureService factureService;
	// http://localhost:8181/SpringMVC/facture/retrieve-all-factures
	@GetMapping("/retrieve-all-factures")
	@ResponseBody
	public List<Facture> getFactures() {
	List<Facture> listFactures = factureService.retrieveAllFactures();
	return listFactures;
	}

	// http://localhost:8181/SpringMVC/Facture/retrieve-facture/8
	@GetMapping("/retrieve-facture/{facture-Num}")
	@ResponseBody
	public  Facture retrieveFacture(@PathVariable("facture-Num") Long Num) {
	return factureService.retrieveFacture(Num);
	}
	
	@PostMapping(value="/add-facture",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Facture addFacture(@RequestBody Facture c) {
	return factureService.addFacture(c);
	}
	
	// http://localhost:8181/SpringMVC/facture/remove-facture/{facture-Num}
	@DeleteMapping("/remove-facture/{facture-Num}")
	@ResponseBody
	public void removeClient(@PathVariable("facture-Num") Long Num) {
		factureService.deleteFacture(Num);
	}

	// http://localhost:8181/SpringMVC/facture/modify-facture
	@PutMapping("/modify-facture")
	@ResponseBody
	public Facture modifyFacture(@RequestBody Facture facture ) {
	return factureService.updateFacture(facture);
	}
}
	
