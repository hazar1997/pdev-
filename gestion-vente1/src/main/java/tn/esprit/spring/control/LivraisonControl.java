package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.LivraisonDTO;
import tn.esprit.spring.service.LivraisonService;

@RestController
@RequestMapping("/livraison")
public class LivraisonControl {
	
	@Autowired
	LivraisonService  livrService;
	
	@CrossOrigin(origins= "http://localhost:4200")
	@PostMapping(value="/post",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LivraisonDTO add(@RequestBody LivraisonDTO c) {
	return livrService.addLivraisonDetail(c);
	}

	@CrossOrigin(origins= "http://localhost:4200")
	@PutMapping("/put")
	@ResponseBody
	public LivraisonDTO modify(@RequestBody LivraisonDTO c   ) {
	return livrService.addLivraisonDetail(c);
	}

	@CrossOrigin(origins= "http://localhost:4200")
	@GetMapping("/get")
	@ResponseBody
	public  LivraisonDTO retrieve(@RequestParam("user_id") long id) {
	return livrService.getLivraisonByUserId(id);
	}
}

