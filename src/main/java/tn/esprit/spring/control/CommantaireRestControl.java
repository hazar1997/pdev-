package tn.esprit.spring.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Commantaire;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.repository.CommantaireRepository;
import tn.esprit.spring.repository.SujetRepository;
import tn.esprit.spring.services.CommantaireService;
import tn.esprit.spring.services.SujetService;

@RestController
@RequestMapping("/comment")
@Api(tags = "Gestion Commantaire")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommantaireRestControl {

	//couplage faible 
	@Autowired
	CommantaireService commentService;
	@Autowired
	CommantaireRepository commentRepo;
	@Autowired
	SujetService sujetService;
	@Autowired
	SujetRepository sujetRepo;
	

	// URL : http://localhost:8081/SpringMVC/sujet/retrieve-all-sujets
	@GetMapping("/retrieve-all-comments")
	public List<Commantaire> retrieveAllCommentts() 
	{
		List<Commantaire> list = commentService.retrievAllComments();
		return list ;
	}

	@PostMapping("/add-comment")
	public Commantaire addComment(@RequestBody Commantaire p) 
	{
	    //Optional<Sujet> s = sujetRepo.findById(sujet);
		return commentService.addComment(p);
	}
	
 @PostMapping("/add-comment/{sujet-id}")
	public Commantaire addComment2(@RequestBody Commantaire c,@PathVariable("sujet-id" )Long sujetId) 
	{
	    
		
		//Optional<Sujet> s = sujetRepo.findById(sujet);
		Sujet s = sujetRepo.findById(sujetId).get();
		
		c.setSujet(s);
		return commentService.addComment(c);
	}
	


	@PutMapping("/modify-comment/{comment-id")
	public ResponseEntity<Commantaire> modifyComment(@RequestBody Commantaire comment,@PathVariable("comment-id") Long commentId) {
		
		Commantaire c = commentRepo.findById(commentId).get();
		c.setComment(comment.getComment());
		Commantaire updateComment = commentRepo.save(c);
		return ResponseEntity.ok(updateComment);
	}

	@DeleteMapping("/remove-comment/{comment-id}")
	public void removeComment(@PathVariable("comment-id") Long commentId) 
	{
		
		commentService.deleteComment(commentId);
	}

	@GetMapping("/retrieve-comment/{comment-id}")
	public Commantaire retrieveComment(@PathVariable("comment-id") Long commentId) 
	{
		return commentService.retrieveComment(commentId);
	}
}
