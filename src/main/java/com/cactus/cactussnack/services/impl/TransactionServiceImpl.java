package com.cactus.cactussnack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cactus.cactussnack.models.Caisse;
import com.cactus.cactussnack.models.Transaction;
import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.repositories.TransactionRepository;
import com.cactus.cactussnack.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public void cancelTransaction(String transactionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		Transaction existingTransaction = transactionRepository.findOne(transaction
				.getId());
		if (existingTransaction != null) {
			return transactionRepository.save(transaction);
		}
		 throw new IllegalArgumentException("Transaction doesn't exists.");
	}

	@Override
	public Page<Transaction> findTransactionByUtilisateur(Utilisateur utilisateur,
			Pageable pageable) {
		return transactionRepository.findByUtilisateur(utilisateur, pageable);
	}

	@Override
	public Page<Transaction> findTransactionByCaisse(Caisse charge,
			Pageable pageable) {
		return transactionRepository.findByCaisse(charge, pageable);
	}

	@Override
	public List<Transaction> findAll() {
		return (List<Transaction>) transactionRepository.findAll();
	}

}
