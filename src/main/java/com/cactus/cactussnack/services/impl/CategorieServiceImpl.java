package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.models.Categorie;
import com.cactus.cactussnack.repositories.CategorieRepository;
import com.cactus.cactussnack.repositories.CategorieRepository;
import com.cactus.cactussnack.repositories.UtilisateurRepository;
import com.cactus.cactussnack.repositories.ProduitRepository;
import com.cactus.cactussnack.services.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService{
	
	@Autowired
	CategorieRepository categorieRepository ;

	@Override
	public Categorie create(Categorie categorie) {
		Categorie tmp = categorieRepository.findByIntitule(categorie.getIntitule());
		if(tmp == null){
			return categorieRepository.save(categorie);
		}else
			throw new IllegalArgumentException("Categorie already exists. ");
	}

	@Override
	public List<Categorie> findAll() {
		return (List<Categorie>) categorieRepository.findAll();
	}

	@Override
	public Categorie update(Categorie categorie) {
		
		Categorie tmp = categorieRepository.findByIntitule(categorie.getIntitule());
		if(tmp != null){
			return categorieRepository.save(categorie);
		}else
			throw new IllegalArgumentException("Categorie doesn't exists.");
		
		
	}

	@Override
	public void delete(Categorie employe) {
		try{
		categorieRepository.delete(employe);
		}catch(RuntimeException e){
			throw new IllegalArgumentException("An error occured when deleting categorie");
		}
	}


	@Override
	public Categorie findById(int id) {
		return categorieRepository.findById(id);
	}

	@Override
	public Categorie findByIntitule(String intitule) {
		return categorieRepository.findByIntitule(intitule);
	}
	
	

}
