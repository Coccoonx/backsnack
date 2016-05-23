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

import com.cactus.cactussnack.models.Fournisseur;
import com.cactus.cactussnack.services.FournisseurService;

@Controller
// @RestController
public class FournisseurController {

	@Autowired
	FournisseurService fournisseurService;

	@RequestMapping(value = "/fournisseur", method = RequestMethod.POST)
	@ResponseBody
	public Fournisseur create(@Valid @RequestBody Fournisseur fournisseur) {
		Fournisseur employeCree = fournisseurService.create(fournisseur);
		System.out.println(employeCree);
		return employeCree;
	}

	@RequestMapping(value = "/fournisseurs", method = RequestMethod.GET)
	@ResponseBody
	public List<Fournisseur> findAll() {
		return fournisseurService.findAll();
	}
	
	@RequestMapping(value = "/fournisseur", method = RequestMethod.GET)
	@ResponseBody
	public Fournisseur findById(@RequestParam(value="id", required=true) String id) {
		System.out.println("Login : "+id);
		return fournisseurService.findById(id);
	}
	
	@RequestMapping(value = "/fournisseur", method = RequestMethod.PUT)
	@ResponseBody
	public Fournisseur update(@Valid @RequestBody Fournisseur fournisseur) {
		System.out.println("Old : "+ findById(fournisseur.getId()));
		Fournisseur employeEdite = fournisseurService.update(fournisseur);
		System.out.println("New : "+ employeEdite);
		return employeEdite;
	}
	
	@RequestMapping(value = "/fournisseur", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(value="code", required=true) String id) {
		Fournisseur fournisseur = fournisseurService.findById(id);
		fournisseurService.delete(fournisseur);
	}

}
