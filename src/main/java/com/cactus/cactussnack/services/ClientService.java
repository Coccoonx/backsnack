package com.cactus.cactussnack.services;

import java.util.List;


import com.cactus.cactussnack.models.Client;


public interface ClientService {
	
	Client create(Client client);
	Client findByNom(String nom);
	Client findByNumTelephone(String code);
	Client findById(String uuid);
	List<Client> findAll();
	Client update(Client client);
	void delete(Client client);

}
