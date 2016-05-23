package com.cactus.cactussnack.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cactus.cactussnack.models.Caisse;
import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Transaction;
import com.cactus.cactussnack.models.Transaction;
import com.cactus.cactussnack.models.Utilisateur;


public interface TransactionService {

	public void cancelTransaction(String transactionId);

	public Transaction createTransaction(Transaction transaction);

	public Transaction updateTransaction(Transaction transaction);

	public Page<Transaction> findTransactionByUtilisateur(Utilisateur utilisateur, Pageable pageable);
	public Page<Transaction> findTransactionByCaisse(Caisse caisse, Pageable pageable);
	
	public List<Transaction> findAll();
}
