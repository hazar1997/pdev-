package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.sellerByCategoDto;
import tn.esprit.spring.repository.LigneCommandeRepository;

@Service
public class LigneCommandeService {
	
	@Autowired
	LigneCommandeRepository lcmdRepository;
	
	public sellerByCategoDto sellersByDate() {
		
		List<Object[]> list_sc = lcmdRepository.sellersByCategorie();
        List<String> categories = new ArrayList<>();
		List quantite = new ArrayList<>();
		
		
		for (Object[] lcmd : list_sc) {
			quantite.add(lcmd[0]);
			categories.add((String)lcmd[1]);            
		}
		          
		sellerByCategoDto sdd = new sellerByCategoDto();
        sdd.setCategories(categories);;
        sdd.setQuantite(quantite);
        return sdd;
       	}

}
