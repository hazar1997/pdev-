package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dto.sellerByCategoDto;
import tn.esprit.spring.dto.sellsCountryDto;
import tn.esprit.spring.dto.sellsDateDto;
import tn.esprit.spring.service.CommandeService;
import tn.esprit.spring.service.LigneCommandeService;

@RestController
@RequestMapping("/admin")
public class AdminPanel {
	
	@Autowired
	CommandeService cmdService;
	
	@Autowired
	LigneCommandeService lcmdService;
	
	// http://localhost:8181/SpringMVC/admin/seller-by-date
	@CrossOrigin(origins= "http://localhost:4200")
	@GetMapping("/seller-by-date")
	@ResponseBody
	public ResponseEntity<sellsDateDto> getmost_seller_product() {

		sellsDateDto pd = cmdService.sellersByDate();
        return new ResponseEntity<>(pd, HttpStatus.OK);	
	}
	
	@CrossOrigin(origins= "http://localhost:4200")
	@GetMapping("/seller-by-catego")
	@ResponseBody
	public ResponseEntity<sellerByCategoDto> get_seller_catego() {
		sellerByCategoDto sc = lcmdService.sellersByDate();
		return new ResponseEntity<>(sc, HttpStatus.OK);		
	}
	
	@CrossOrigin(origins= "http://localhost:4200")
	@GetMapping("/seller-by-country")
	@ResponseBody
	public ResponseEntity<sellsCountryDto> sellersByCountry(){
		sellsCountryDto sc = cmdService.sellersByCountry();
		return new ResponseEntity<>(sc, HttpStatus.OK);		
	}


}
