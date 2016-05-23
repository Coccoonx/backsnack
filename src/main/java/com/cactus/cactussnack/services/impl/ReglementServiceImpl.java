package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Reglement;
import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.repositories.ReglementRepository;
import com.cactus.cactussnack.services.ReglementService;

@Service
public class ReglementServiceImpl implements ReglementService {

	@Autowired
	ReglementRepository reglementRepository;

	@Override
	public void cancelReglement(String transactionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Reglement createReglement(Reglement reglement) {
		return reglementRepository.save(reglement);
	}

	@Override
	public Reglement updateReglement(Reglement reglement) {
		Reglement existingReglement = reglementRepository.findOne(reglement
				.getId());
		if (existingReglement != null) {
			return reglementRepository.save(reglement);
		}
		 throw new IllegalArgumentException("Reglement doesn't exists.");
	}

	@Override
	public Page<Reglement> findReglementByUtilisateur(Utilisateur utilisateur,
			Pageable pageable) {
		return reglementRepository.findByUtilisateur(utilisateur, pageable);
	}

	@Override
	public Page<Reglement> findReglementByCharge(Charge charge,
			Pageable pageable) {
		return reglementRepository.findByCharge(charge, pageable);
	}

	@Override
	public List<Reglement> findAll() {
		return (List<Reglement>) reglementRepository.findAll();
	}

}
