package tn.esprit.spring.service;


import tn.esprit.spring.dto.AddToPanierDto;
import tn.esprit.spring.dto.PanierDto;
import tn.esprit.spring.entities.User;


public interface PanierService {

	public void add_Element_to_Panier(AddToPanierDto elem, User user) throws Exception;
	
	public PanierDto delete_Element_from_panier(long elem_id, User user);

	public void delete_All_Element_from_panier(int user_id);
	
	public int nbr_Element(long num_client);
	
    public PanierDto get_Elment_List(User user);

	boolean exist_In_Panier(long user_id, long produit_id);

	public PanierDto updateQtePlus(User user, long productId);

	public PanierDto updateQteMinus(User user, long productId);

	int countProductByUser(long user_id);
    
}
