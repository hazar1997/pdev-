package tn.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	

	
	
	@Override
	public List<Client> retrievAllClients() {
		List<Client> clients =null;
		try {
			log.info("In method retrievAllClients : ");
			log.debug("Conenction à la base de données : ");
			clients = clientRepository.findAll();
			log.debug("Le nombre total de Stocks : " + clients.size());
			for (Client client : clients) 
			{
				log.debug(" Client : " + client.toString());
			}
			log.info("Out method retrievAllClients without Errors");
		}
		catch (Exception e) {log.error("Error in retrievAllClients : " + e);}
		return (clients);
	}

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);

	}

	@Override
	public Client updateClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Client retrieveClient(Long id) {
		return (clientRepository.findById(id).get());
	}
	
	//@Scheduled(fixedDelay = 1000)
//	public void scheduledMethod() {
		//log.info("Method with fixed Delay 1 secondes");
	//}
}
