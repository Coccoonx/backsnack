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

import com.cactus.cactussnack.models.Categorie;
import com.cactus.cactussnack.models.Produit;
import com.cactus.cactussnack.services.CategorieService;
import com.cactus.cactussnack.services.ProduitService;

@Controller
// @RestController
public class ProduitController {

	@Autowired
	ProduitService produitService;
	
	@Autowired
	CategorieService categorieService;

	@RequestMapping(value = "/produit", method = RequestMethod.POST)
	@ResponseBody
	public Produit create(@Valid @RequestBody Produit produit) {
		
		Categorie categorie = categorieService.findById(produit.getCategorieId());
		produit.setCategorie(categorie);
		Produit produitCree = produitService.create(produit);
		System.out.println(produit);
		return produitCree;
	}

	@RequestMapping(value = "/produits", method = RequestMethod.GET)
	@ResponseBody
	public List<Produit> findAll() {
		List<Produit> produits = (List<Produit>) produitService.findAll();
		for(Produit p : produits){
			Categorie categorie = categorieService.findById(p.getCategorie().getId());
			p.setCategorie(categorie);
		}
		System.out.println("produits : "+ produits);
		return produits;
	}
	
	@RequestMapping(value = "/produit", method = RequestMethod.GET)
	@ResponseBody
	public Produit findByCode(@RequestParam(value="code", required=true) String code) {
		System.out.println("Login : "+code);
		return produitService.findByCode(code);
	}
	
	@RequestMapping(value = "/produit", method = RequestMethod.PUT)
	@ResponseBody
	public Produit update(@Valid @RequestBody Produit produit) {
		System.out.println("Old : "+ findByCode(produit.getCode()));
		Produit employeEdite = produitService.update(produit);
		System.out.println("New : "+ employeEdite);
		return employeEdite;
	}
	
	@RequestMapping(value = "/produit", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(value="code", required=true) String code) {
		Produit produit = produitService.findByCode(code);
		produitService.delete(produit);
	}
	

}
