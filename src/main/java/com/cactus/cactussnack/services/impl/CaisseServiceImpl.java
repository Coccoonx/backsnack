package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.models.Caisse;
import com.cactus.cactussnack.repositories.CaisseRepository;
import com.cactus.cactussnack.repositories.UtilisateurRepository;
import com.cactus.cactussnack.repositories.ProduitRepository;
import com.cactus.cactussnack.services.CaisseService;

@Service
public class CaisseServiceImpl implements CaisseService{
	
	@Autowired
	CaisseRepository caisseRepository ;

	@Override
	public Caisse create(Caisse produit) {
		Caisse tmp = caisseRepository.findByCode(produit.getCode());
		if(tmp == null){
			return caisseRepository.save(produit);
		}else
			throw new IllegalArgumentException("Caisse already exists. ");
	}

	@Override
	public List<Caisse> findAll() {
		return (List<Caisse>) caisseRepository.findAll();
	}

	@Override
	public Caisse update(Caisse produit) {
		
		Caisse tmp = caisseRepository.findByCode(produit.getCode());
		if(tmp != null){
			return caisseRepository.save(produit);
		}else
			throw new IllegalArgumentException("Caisse doesn't exists.");
		
		
	}

	@Override
	public void delete(Caisse employe) {
		try{
		caisseRepository.delete(employe);
		}catch(RuntimeException e){
			throw new IllegalArgumentException("An error occured when deleting Caisse");
		}
	}

	@Override
	public Caisse findByCode(String code) {
		return caisseRepository.findByCode(code);
	}

	@Override
	public Caisse findByUuid(String uuid) {
		return caisseRepository.findById(uuid);
	}

	@Override
	public Caisse findByIntitule(String intitule) {
		return caisseRepository.findByIntitule(intitule);
	}
	
	

}
