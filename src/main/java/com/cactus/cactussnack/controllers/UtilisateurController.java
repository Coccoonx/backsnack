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

import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.services.UtilisateurService;

@Controller
// @RestController
public class UtilisateurController {

	@Autowired
	UtilisateurService utilisateurService;

	@RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
	@ResponseBody
	public Utilisateur create(@Valid @RequestBody Utilisateur utilisateur) {
		Utilisateur utilisateurCree = utilisateurService.create(utilisateur);
		System.out.println(utilisateurCree);
		return utilisateurCree;
	}

	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	@ResponseBody
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.GET)
	@ResponseBody
	public Utilisateur findByLogin(@RequestParam(value="matricule", required=true) String matricule) {
		System.out.println("Login : "+matricule);
		return utilisateurService.findByMatricule(matricule);
	}
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.PUT)
	@ResponseBody
	public Utilisateur update(@Valid @RequestBody Utilisateur utilisateur) {
		System.out.println("Old : "+ findByLogin(utilisateur.getLogin()));
		Utilisateur utilisateurEdite = utilisateurService.update(utilisateur);
		System.out.println("New : "+ utilisateurEdite);
		return utilisateurEdite;
	}
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(value="login", required=true) String login) {
		Utilisateur utilisateur = utilisateurService.findByLogin(login);
		utilisateurService.delete(utilisateur);
	}

}
