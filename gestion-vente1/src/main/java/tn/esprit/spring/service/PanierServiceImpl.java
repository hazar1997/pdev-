package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.AddToPanierDto;
import tn.esprit.spring.dto.PanierDto;
import tn.esprit.spring.dto.PanierItemDto;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.PanierRepository;

@Service
public class PanierServiceImpl implements PanierService {

	@Autowired
	PanierRepository  panierRepository;
 
	@Autowired
    ProduitServiceImpl produitService;
	
	@Override
	public void add_Element_to_Panier(AddToPanierDto elem, User user) throws Exception{
		
        Produit produit = produitService.findById(elem.getProductId());

		if(panierRepository.verif_Produit(user.getId(), elem.getProductId())>0) {
			throw new Exception("Product is already exist.");
		}
		
		Panier p = new Panier();
		p.setProduit(produit);
		p.setUser(user);
		p.setQuantite(elem.getQuantity());

		panierRepository.save(p);
	}

	@Override
	public PanierDto delete_Element_from_panier(long elem_id, User user) {
		panierRepository.delete_Element(user.getId(), elem_id);
		return this.get_Elment_List(user);
	}

	@Override
	public int nbr_Element(long num_client) {
		return panierRepository.nbr_Element(num_client);
	}

	@Override
	public PanierDto get_Elment_List(User user) {
		List<Panier> list_elem = panierRepository.get_Elment_List(user.getId());
		System.out.println(list_elem);
		
		List<PanierItemDto> pi = new ArrayList<>();
		double totalCost = 0;
        for (Panier p: list_elem) {
            PanierItemDto pid = new PanierItemDto(p);
            totalCost += pid.getQuantity() * p.getProduit().getPrice();
            pi.add(pid);
        }
        
        PanierDto pd = new PanierDto();
        pd.setTotalCost(totalCost);
        pd.setPanierItems(pi);
        return  pd;
	}

	@Override
	public void delete_All_Element_from_panier(int user_id) {
		panierRepository.delete_All_Element_from_panier(user_id);		
	}

	@Override
	public boolean exist_In_Panier(long user_id, long produit_id) {
		if(panierRepository.verif_Produit(user_id, produit_id)>0) {
			return true;
		}
		return false;
	}

	@Override
	public PanierDto updateQtePlus(User user, long productId) {
		panierRepository.ubdateQtePlus(user.getId(), productId);
		return this.get_Elment_List(user);
	}
	
	@Override
	public PanierDto updateQteMinus(User user, long productId) {
		panierRepository.ubdateQteMinus(user.getId(), productId);
		return this.get_Elment_List(user);
	}
	
	public int countProductByUser(long user_id){
		return panierRepository.countProductByUser(user_id);
	}
	}
