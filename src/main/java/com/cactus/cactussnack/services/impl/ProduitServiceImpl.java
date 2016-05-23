package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.models.Produit;
import com.cactus.cactussnack.repositories.UtilisateurRepository;
import com.cactus.cactussnack.repositories.ProduitRepository;
import com.cactus.cactussnack.services.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService{
	
	@Autowired
	ProduitRepository productRepository ;

	@Override
	public Produit create(Produit produit) {
		Produit tmp = productRepository.findByCode(produit.getCode());
		if(tmp == null){
			return productRepository.save(produit);
		}else
			throw new IllegalArgumentException("Product already exists. ");
	}

	@Override
	public List<Produit> findAll() {
		return (List<Produit>) productRepository.findAll();
	}

	@Override
	public Produit update(Produit produit) {
		
		Produit tmp = productRepository.findByCode(produit.getCode());
		if(tmp != null){
			return productRepository.save(produit);
		}else
			throw new IllegalArgumentException("Product doesn't exists.");
		
		
	}

	@Override
	public void delete(Produit employe) {
		try{
		productRepository.delete(employe);
		}catch(RuntimeException e){
			throw new IllegalArgumentException("An error occured when deleting employe");
		}
	}

	@Override
	public Produit findByCode(String code) {
		return productRepository.findByCode(code);
	}

	@Override
	public Produit findByUuid(String uuid) {
		return productRepository.findById(uuid);
	}

	@Override
	public Produit findByIntitule(String intitule) {
		return productRepository.findByIntitule(intitule);
	}
	
	

}
