package com.cactus.cactussnack.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cactus.cactussnack.models.Caisse;
import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Transaction;
import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.services.TransactionService;
import com.cactus.cactussnack.services.TransactionService;

@Controller
// @RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	@ResponseBody
	public Transaction create(@Valid @RequestBody Transaction transaction) {
		Transaction employeCree = transactionService.createTransaction(transaction);
		System.out.println(employeCree);
		return employeCree;
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	@ResponseBody
	public List<Transaction> findAll() {
		return transactionService.findAll();
	}

	@RequestMapping(value = "/transactionutilisateur/{page}/{size}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Transaction> findByUtilisateur(
			@RequestParam(value = "id", required = true) String idUser,
			@PathVariable Integer page,
			@PathVariable Integer size) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(idUser);
		Pageable pageable = new PageRequest(page, size);
		return transactionService.findTransactionByUtilisateur(utilisateur,
				pageable);
	}

	@RequestMapping(value = "/transactioncaisse/{page}/{size}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Transaction> findByCaisse(
			@RequestParam(value = "code", required = true) String codeCaisse,
			@PathVariable Integer page,
			@PathVariable Integer size) {
		Caisse caisse = new Caisse();
		caisse.setCode(codeCaisse);
		Pageable pageable = new PageRequest(page, size);
		return transactionService.findTransactionByCaisse(caisse,
				pageable);
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.PUT)
	@ResponseBody
	public Transaction update(@Valid @RequestBody Transaction transaction) {
		Transaction employeEdite = transactionService.updateTransaction(transaction);
		return employeEdite;
	}

}
