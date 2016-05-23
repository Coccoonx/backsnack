package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Client;
import com.cactus.cactussnack.repositories.ClientRepository;
import com.cactus.cactussnack.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository clientRepository ;

	@Override
	public Client create(Client client) {
		Client tmp = clientRepository.findById(client.getId());
		if(tmp == null){
			return clientRepository.save(client);
		}else
			throw new IllegalArgumentException("Client already exists. ");
	}

	public List<Client> findAll() {
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Client update(Client client) {
		
		Client tmp = clientRepository.findById(client.getId());
		if(tmp != null){
			return clientRepository.save(client);
		}else
			throw new IllegalArgumentException("Client doesn't exists.");
		
		
	}

	@Override
	public void delete(Client client) {
		try{
		clientRepository.delete(client);
		}catch(RuntimeException e){
			throw new IllegalArgumentException("An error occured when deleting client");
		}
	}

	@Override
	public Client findByNumTelephone(String numTelephone) {
		return clientRepository.findByNumTelephone(numTelephone);
	}

	@Override
	public Client findById(String uuid) {
		return clientRepository.findById(uuid);
	}

	@Override
	public Client findByNom(String intitule) {
		return clientRepository.findByNom(intitule);
	}
	
	

}
