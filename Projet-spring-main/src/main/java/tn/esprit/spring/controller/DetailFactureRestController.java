package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.service.DetailFactureServiceImp;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/DetailFacture")
public class DetailFactureRestController {
	@Autowired
	DetailFactureServiceImp dfs;
	

	
	
	@GetMapping("/retreive-all-detailFacture")
	@ResponseBody
	public List<DetailFacture> getAllDetailFacture(){
		return this.dfs.getAllDetailFacture();
	}
}
