package com.cactus.cactussnack.services;

import java.util.List;


import com.cactus.cactussnack.models.Fournisseur;


public interface FournisseurService {
	
	Fournisseur create(Fournisseur fournisseur);
	Fournisseur findBySociete(String nom);
	Fournisseur findByNumTelephone(String code);
	Fournisseur findById(String uuid);
	List<Fournisseur> findAll();
	Fournisseur update(Fournisseur fournisseur);
	void delete(Fournisseur fournisseur);

}
