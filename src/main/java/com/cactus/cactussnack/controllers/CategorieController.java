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

import com.cactus.cactussnack.models.Categorie;
import com.cactus.cactussnack.services.CategorieService;

@Controller
// @RestController
public class CategorieController {

	@Autowired
	CategorieService categorieService;

	@RequestMapping(value = "/categorie", method = RequestMethod.POST)
	@ResponseBody
	public Categorie create(@Valid @RequestBody Categorie categorie) {
		Categorie employeCree = categorieService.create(categorie);
		System.out.println(employeCree);
		return employeCree;
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	@ResponseBody
	public List<Categorie> findAll() {
		return categorieService.findAll();
	}
	
	@RequestMapping(value = "/categorie", method = RequestMethod.GET)
	@ResponseBody
	public Categorie findByCode(@RequestParam(value="code", required=true) String libelle) {
		System.out.println("Login : "+libelle);
		return categorieService.findByIntitule(libelle);
	}
	
	@RequestMapping(value = "/categorie", method = RequestMethod.PUT)
	@ResponseBody
	public Categorie update(@Valid @RequestBody Categorie categorie) {
		System.out.println("Old : "+ findByCode(categorie.getIntitule()));
		Categorie employeEdite = categorieService.update(categorie);
		System.out.println("New : "+ employeEdite);
		return employeEdite;
	}
	
	@RequestMapping(value = "/categorie", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(value="code", required=true) String libelle) {
		Categorie categorie = categorieService.findByIntitule(libelle);
		categorieService.delete(categorie);
	}

}
