package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.repositories.ChargeRepository;
import com.cactus.cactussnack.repositories.UtilisateurRepository;
import com.cactus.cactussnack.repositories.ProduitRepository;
import com.cactus.cactussnack.services.ChargeService;

@Service
public class ChargeServiceImpl implements ChargeService{
	
	@Autowired
	ChargeRepository caisseRepository ;

	@Override
	public Charge create(Charge charge) {
		Charge tmp = caisseRepository.findByCode(charge.getCode());
		if(tmp == null){
			return caisseRepository.save(charge);
		}else
			throw new IllegalArgumentException("Charge already exists. ");
	}

	@Override
	public List<Charge> findAll() {
		return (List<Charge>) caisseRepository.findAll();
	}

	@Override
	public Charge update(Charge charge) {
		
		Charge tmp = caisseRepository.findByCode(charge.getCode());
		if(tmp != null){
			return caisseRepository.save(charge);
		}else
			throw new IllegalArgumentException("Charge doesn't exists.");
		
		
	}

	@Override
	public void delete(Charge employe) {
		try{
		caisseRepository.delete(employe);
		}catch(RuntimeException e){
			throw new IllegalArgumentException("An error occured when deleting charge");
		}
	}

	@Override
	public Charge findByCode(String code) {
		return caisseRepository.findByCode(code);
	}

	@Override
	public Charge findByUuid(String uuid) {
		return caisseRepository.findById(uuid);
	}

	@Override
	public Charge findByIntitule(String intitule) {
		return caisseRepository.findByIntitule(intitule);
	}
	
	

}
