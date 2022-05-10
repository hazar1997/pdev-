package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.sellsCountryDto;
import tn.esprit.spring.dto.sellsDateDto;
import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.repository.CommandeRepository;

@Service
public class CommandeService {
	
	@Autowired
	CommandeRepository cmdRepository;
	
	
	//@SuppressWarnings("deprecation")
	public sellsDateDto sellersByDate() {
		
		List<Object[]> list_sc = cmdRepository.sellersByDate();
		//System.out.println(list_sc);
        List<String> month = new ArrayList<>();
		List totalCost = new ArrayList<>();
		List year = new ArrayList<>();
		
		for (Object[] cmd : list_sc) {
			year.add((int)cmd[0]);
			month.add(this.getMonthString((int)cmd[1]));
	        totalCost.add(cmd[2]);
	        
		}
		          
        sellsDateDto sdd = new sellsDateDto();
        sdd.setYear(year);
        sdd.setMonth(month);
        sdd.setTotalCost(totalCost);
        return sdd;
       	}
	
	
	
	

	public sellsCountryDto sellersByCountry() {
		
		List<Object[]> list_sc = cmdRepository.sellersByCountry();
        List<String> country = new ArrayList<>();
		List totalCost = new ArrayList<>();
		
		for (Object[] cmd : list_sc) {
			country.add((String) cmd[0]);
	        totalCost.add(cmd[1]);
	        
		}
		          
        sellsCountryDto sdd = new sellsCountryDto();
        sdd.setCountry(country);
        sdd.setTotalCost(totalCost);
        return sdd;
       	}

	
	
	
	
	
	 public String getMonthString(int m) {
		 String month = null ; 
		 switch (m) {
		 
		 case 1: month = "Janv"; break;
		 case 2: month = "Fevr"; break;
		 case 3: month = "Mars"; break;
		 case 4: month = "Avril"; break;
		 case 5: month = "Mai"; break;
		 case 6: month = "Juin"; break;
		 case 7: month = "Juil"; break;
		 case 8: month = "Aout"; break;
		 case 9: month = "Sept"; break;
		 case 10: month = "Octo"; break;
		 case 11: month = "Novbre"; break;
		 case 12: month = "Decem"; break;
		 }
		 return month;
			 
	 }


}
