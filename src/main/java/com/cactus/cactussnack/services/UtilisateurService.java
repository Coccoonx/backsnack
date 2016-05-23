package com.cactus.cactussnack.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Utilisateur;


public interface UtilisateurService {
	
	Utilisateur create(Utilisateur employe);
	Utilisateur findByLogin(String login);
	Utilisateur findByNom(String nom);
	Utilisateur findByMatricule(String matricule);
	Utilisateur findByUuid(String uuid);
	List<Utilisateur> findAll();
	Utilisateur update(Utilisateur employe);
	void delete(Utilisateur employe);

}
