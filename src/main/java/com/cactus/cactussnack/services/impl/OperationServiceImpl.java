package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Operation;
import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.repositories.OperationRepository;
import com.cactus.cactussnack.repositories.OperationRepository;
import com.cactus.cactussnack.services.OperationService;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	OperationRepository operationRepository;

	@Override
	public void cancelOperation(String transactionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Operation createOperation(Operation operation) {
		return operationRepository.save(operation);
	}

	@Override
	public Operation updateOperation(Operation operation) {
		Operation existingOperation = operationRepository.findOne(operation
				.getId());
		if (existingOperation != null) {
			return operationRepository.save(operation);
		}
		 throw new IllegalArgumentException("Operation doesn't exists.");
	}

	@Override
	public Page<Operation> findOperationByUtilisateur(Utilisateur utilisateur,
			Pageable pageable) {
		return operationRepository.findByUtilisateur(utilisateur, pageable);
	}


	@Override
	public List<Operation> findAll() {
		return (List<Operation>) operationRepository.findAll();
	}

}
