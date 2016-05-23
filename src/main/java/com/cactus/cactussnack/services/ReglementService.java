package com.cactus.cactussnack.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Reglement;
import com.cactus.cactussnack.models.Utilisateur;


public interface ReglementService {

	public void cancelReglement(String reglementId);

	public Reglement createReglement(Reglement reglement);

	public Reglement updateReglement(Reglement reglement);

	public Page<Reglement> findReglementByUtilisateur(Utilisateur utilisateur, Pageable pageable);
	public Page<Reglement> findReglementByCharge(Charge charge, Pageable pageable);
	
	public List<Reglement> findAll();
}
