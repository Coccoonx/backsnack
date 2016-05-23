package com.cactus.cactussnack.services;

import java.util.List;


import com.cactus.cactussnack.models.Produit;


public interface ProduitService {
	
	Produit create(Produit produit);
	Produit findByIntitule(String intitule);
	Produit findByCode(String code);
	Produit findByUuid(String uuid);
	List<Produit> findAll();
	Produit update(Produit produit);
	void delete(Produit produit);

}
