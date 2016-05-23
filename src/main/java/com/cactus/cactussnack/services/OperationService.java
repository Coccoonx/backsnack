package com.cactus.cactussnack.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Operation;
import com.cactus.cactussnack.models.Utilisateur;


public interface OperationService {

	public void cancelOperation(String operationId);

	public Operation createOperation(Operation operation);

	public Operation updateOperation(Operation operation);

	public Page<Operation> findOperationByUtilisateur(Utilisateur utilisateur, Pageable pageable);
//	public Page<Operation> findOperationByCharge(Charge charge, Pageable pageable);
	
	public List<Operation> findAll();
}
