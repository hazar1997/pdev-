package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import tn.esprit.spring.config.StripeResponse;
import tn.esprit.spring.dto.CheckoutItemDto;
import tn.esprit.spring.service.PaimentServiceImpl;
import tn.esprit.spring.service.PanierService;
import tn.esprit.spring.service.UserServiceImpl;

@RestController
@RequestMapping("/")
public class PaiementControl {
	

    @Autowired
    private PanierService panierService;
	
	@Autowired
    PaimentServiceImpl paimentService;

    @Autowired
    UserServiceImpl userService;
    
    @CrossOrigin(origins= "http://localhost:4200")
    @PostMapping("create-checkout-session")
    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList)
            throws StripeException {
        Session session = paimentService.createSession(checkoutItemDtoList);
        StripeResponse stripeResponse = new StripeResponse(session.getId());
        
        //panierService.delete_All_Element_from_panier(checkoutItemDtoList.get(0).getUserId());
        return new ResponseEntity<>(stripeResponse, HttpStatus.OK);

    }

    
}
