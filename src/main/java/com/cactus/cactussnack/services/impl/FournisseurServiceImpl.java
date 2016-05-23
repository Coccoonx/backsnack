package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Fournisseur;
import com.cactus.cactussnack.repositories.FournisseurRepository;
import com.cactus.cactussnack.services.FournisseurService;

@Service
public class FournisseurServiceImpl implements FournisseurService{
	
	@Autowired
	FournisseurRepository fournisseurRepository ;

	@Override
	public Fournisseur create(Fournisseur fournisseur) {
		Fournisseur tmp = fournisseurRepository.findById(fournisseur.getId());
		if(tmp == null){
			return fournisseurRepository.save(fournisseur);
		}else
			throw new IllegalArgumentException("Fournisseur already exists. ");
	}

	@Override
	public List<Fournisseur> findAll() {
		return (List<Fournisseur>) fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur update(Fournisseur fournisseur) {
		
		Fournisseur tmp = fournisseurRepository.findById(fournisseur.getId());
		if(tmp != null){
			return fournisseurRepository.save(fournisseur);
		}else
			throw new IllegalArgumentException("Fournisseur doesn't exists.");
		
		
	}

	@Override
	public void delete(Fournisseur fournisseur) {
		try{
		fournisseurRepository.delete(fournisseur);
		}catch(RuntimeException e){
			throw new IllegalArgumentException("An error occured when deleting fournisseur");
		}
	}

	@Override
	public Fournisseur findByNumTelephone(String numTelephone) {
		return fournisseurRepository.findByNumTelephone(numTelephone);
	}

	@Override
	public Fournisseur findById(String uuid) {
		return fournisseurRepository.findById(uuid);
	}

	@Override
	public Fournisseur findBySociete(String intitule) {
		return fournisseurRepository.findBySociete(intitule);
	}
	
	

}
