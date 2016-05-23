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

import com.cactus.cactussnack.models.Operation;
import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.services.OperationService;

@Controller
// @RestController
public class OperationController {

	@Autowired
	OperationService operationService;

	@RequestMapping(value = "/operation", method = RequestMethod.POST)
	@ResponseBody
	public Operation create(@Valid @RequestBody Operation operation) {
		Operation employeCree = operationService.createOperation(operation);
		System.out.println(employeCree);
		return employeCree;
	}

	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	@ResponseBody
	public List<Operation> findAll() {
		return operationService.findAll();
	}

	@RequestMapping(value = "/operationutilisateur/{page}/{size}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Operation> findByUtilisateur(
			@RequestParam(value = "id", required = true) String idUser,
			@PathVariable Integer page,
			@PathVariable Integer size) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(idUser);
		Pageable pageable = new PageRequest(page, size);
		return operationService.findOperationByUtilisateur(utilisateur,
				pageable);
	}


	@RequestMapping(value = "/operation", method = RequestMethod.PUT)
	@ResponseBody
	public Operation update(@Valid @RequestBody Operation operation) {
		Operation employeEdite = operationService.updateOperation(operation);
		return employeEdite;
	}

}
