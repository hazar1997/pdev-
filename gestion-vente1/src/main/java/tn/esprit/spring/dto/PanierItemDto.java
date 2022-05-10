package tn.esprit.spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Produit;

@Getter
@Setter
@NoArgsConstructor

public class PanierItemDto {
	
    private Integer quantity;
    private Produit produit;
    
    public PanierItemDto(Panier p) {
        this.quantity = p.getQuantite();
        this.setProduit(p.getProduit());
    }

}
