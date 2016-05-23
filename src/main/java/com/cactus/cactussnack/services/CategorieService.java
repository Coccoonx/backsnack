package com.cactus.cactussnack.services;

import java.util.List;


import com.cactus.cactussnack.models.Categorie;


public interface CategorieService {
	
	Categorie create(Categorie categorie);
	Categorie findByIntitule(String intitule);
	Categorie findById(int id);
	List<Categorie> findAll();
	Categorie update(Categorie categorie);
	void delete(Categorie categorie);

}
