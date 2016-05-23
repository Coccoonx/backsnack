package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.repositories.UtilisateurRepository;
import com.cactus.cactussnack.services.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	UtilisateurRepository utilisateurRepository ;

	@Override
	public Utilisateur create(Utilisateur employe) {
		Utilisateur tmp = utilisateurRepository.findByLogin(employe.getLogin());
		if(tmp == null){
			return utilisateurRepository.save(employe);
		}else
			throw new IllegalArgumentException("Utilisateur already exists. ");
	}

	public List<Utilisateur> findAll() {
		return (List<Utilisateur>) utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur update(Utilisateur employe) {
		
		Utilisateur tmp = utilisateurRepository.findByLogin(employe.getLogin());
		if(tmp != null){
			return utilisateurRepository.save(employe);
		}else
			throw new IllegalArgumentException("Utilisateur doesn't exists.");
		
		
	}

	@Override
	public void delete(Utilisateur employe) {
		try{
		utilisateurRepository.delete(employe);
		}catch(RuntimeException e){
			throw new IllegalArgumentException("An error occured when deleting Utilisateur");
		}
	}

	@Override
	public Utilisateur findByLogin(String login) {
		return utilisateurRepository.findByLogin(login);
	}

	@Override
	public Utilisateur findByNom(String nom) {
		return utilisateurRepository.findByNom(nom);
	}

	@Override
	public Utilisateur findByMatricule(String matricule) {
		return utilisateurRepository.findByMatricule(matricule);
	}

	@Override
	public Utilisateur findByUuid(String uuid) {
		return utilisateurRepository.findById(uuid);
	}
	
	

}
