package com.cactus.cactussnack.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cactus.cactussnack.models.Client;
import com.cactus.cactussnack.services.ClientService;
import com.cactus.cactussnack.services.ClientService;

@Controller
// @RestController
public class ClientController {

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/client", method = RequestMethod.POST)
	@ResponseBody
	public Client create(@Valid @RequestBody Client client) {
		Client employeCree = clientService.create(client);
		System.out.println(employeCree);
		return employeCree;
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> findAll() {
		return clientService.findAll();
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	@ResponseBody
	public Client findById(@RequestParam(value="id", required=true) String id) {
		System.out.println("Login : "+id);
		return clientService.findById(id);
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.PUT)
	@ResponseBody
	public Client update(@Valid @RequestBody Client client) {
		System.out.println("Old : "+ findById(client.getId()));
		Client employeEdite = clientService.update(client);
		System.out.println("New : "+ employeEdite);
		return employeEdite;
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(value="code", required=true) String id) {
		Client client = clientService.findById(id);
		clientService.delete(client);
	}

}
