package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.config.ApiResponse;
import tn.esprit.spring.dto.AddToPanierDto;
import tn.esprit.spring.dto.PanierDto;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.PanierService;
import tn.esprit.spring.service.UserServiceImpl;

@RestController
@RequestMapping("/panier")
public class PanierControl {
	

    @Autowired
    private PanierService panierService;

    @Autowired
    private UserServiceImpl userService;
    
    @CrossOrigin(origins= "http://localhost:4200")
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ApiResponse> addToPanier(@RequestBody AddToPanierDto addToPanierDto,
                                                 @RequestParam("user_id") long id) {

        try {
            User user = userService.getUserById(id);
            if(panierService.exist_In_Panier(id, addToPanierDto.getProductId())) {
            	return new ResponseEntity<>(new ApiResponse(false, "L'élement déja existe dans le panier"), HttpStatus.EXPECTATION_FAILED);
            }else {
            	panierService.add_Element_to_Panier(addToPanierDto, user);}
	        return new ResponseEntity<>(new ApiResponse(true, "L'élement a ajouté au panier avec succé"), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(new ApiResponse(false, "erreur, Repetez une autre fois"), HttpStatus.EXPECTATION_FAILED);

		}

    }
    
    // get all cart items for a user
    @CrossOrigin(origins= "http://localhost:4200")
    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<PanierDto> getPanierElement(@RequestParam("user_id") long id) {
    	
    	User user = userService.getUserById(id);
        // get cart items

    	PanierDto pd = panierService.get_Elment_List(user);
        return new ResponseEntity<>(pd, HttpStatus.OK);
    }
    
    // delete a cart item for a user
    @CrossOrigin(origins= "http://localhost:4200")
    @DeleteMapping("/delete/{panier_Elem_Id}")
    @ResponseBody
    public ResponseEntity<PanierDto> deleteCartItem(@PathVariable("panier_Elem_Id") long itemId,
                                                      @RequestParam("user_id") long id) {

    	User user = userService.getUserById(id);

    	PanierDto pd = panierService.delete_Element_from_panier(itemId, user);

        return new ResponseEntity<>(pd, HttpStatus.OK);

    }
    
    @CrossOrigin(origins= "http://localhost:4200")
    @GetMapping("/updateqte/{panier_Elem_Id}")
    @ResponseBody
    public ResponseEntity<PanierDto> updateQteMinus(@PathVariable("panier_Elem_Id") long itemId,
            @RequestParam("user_id") long id) {
    	User user = userService.getUserById(id);

    	PanierDto pd = panierService.updateQteMinus(user, itemId);

    	return new ResponseEntity<>(pd, HttpStatus.OK);

    }
    
    @CrossOrigin(origins= "http://localhost:4200")
    @GetMapping("/updateqteplus/{panier_Elem_Id}")
    @ResponseBody
    public ResponseEntity<PanierDto> updateQtePlus(@PathVariable("panier_Elem_Id") long itemId,
            @RequestParam("user_id") long id) {
    	User user = userService.getUserById(id);

    	PanierDto pd = panierService.updateQtePlus(user, itemId);

    	return new ResponseEntity<>(pd, HttpStatus.OK);

    }

}
