package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Client;

public interface ClientService {
	
	List<Client>retrievAllClients();
	Client addClient(Client c);
	void deleteClient(Long id);
	Client updateClient(Client c);
	Client retrieveClient(Long id);
} 