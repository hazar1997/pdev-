package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.services.ClientService;

@RestController
@RequestMapping("/client")
@Api(tags = "Gestion Clients")
public class ClientRestControl {

	//couplage faible 
	@Autowired
	ClientService clientService;

	// URL : http://localhost:8081/SpringMVC/client/retrieve-all-clients
	@GetMapping("/retrieve-all-clients")
	public List<Client> retrieveAllClients() 
	{
		List<Client> list = clientService.retrievAllClients();
		return list ;
	}

	@PostMapping("/add-client")
	public Client addClient(@RequestBody Client p) 
	{
		return clientService.addClient(p);
	}


	@PutMapping("/modify-client")
	public Client modifyClient(@RequestBody Client client) {
		return clientService.updateClient(client);
	}

	@DeleteMapping("/remove-client/{client-id}")
	public void removeClient(@PathVariable("client-id") Long clientId) 
	{
		clientService.deleteClient(clientId);
	}
	
	@GetMapping("/retrieve-client/{client-id}")
	public Client retrieveClient(@PathVariable("client-id") Long clientId) 
	{
		return clientService.retrieveClient(clientId);
	}
	
}
