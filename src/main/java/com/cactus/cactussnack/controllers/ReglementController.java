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

import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Reglement;
import com.cactus.cactussnack.models.Utilisateur;
import com.cactus.cactussnack.services.ReglementService;

@Controller
// @RestController
public class ReglementController {

	@Autowired
	ReglementService reglementService;

	@RequestMapping(value = "/reglement", method = RequestMethod.POST)
	@ResponseBody
	public Reglement create(@Valid @RequestBody Reglement reglement) {
		Reglement employeCree = reglementService.createReglement(reglement);
		System.out.println(employeCree);
		return employeCree;
	}

	@RequestMapping(value = "/reglements", method = RequestMethod.GET)
	@ResponseBody
	public List<Reglement> findAll() {
		return reglementService.findAll();
	}

	@RequestMapping(value = "/reglementutilisateur/{page}/{size}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Reglement> findByUtilisateur(
			@RequestParam(value = "id", required = true) String idUser,
			@PathVariable Integer page,
			@PathVariable Integer size) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(idUser);
		Pageable pageable = new PageRequest(page, size);
		return reglementService.findReglementByUtilisateur(utilisateur,
				pageable);
	}

	@RequestMapping(value = "/reglementcharge/{page}/{size}", method = RequestMethod.GET)
	@ResponseBody
	public Page<Reglement> findByCharge(
			@RequestParam(value = "code", required = true) String codeCharge,
			@PathVariable Integer page,
			@PathVariable Integer size) {
		Charge charge = new Charge();
		charge.setCode(codeCharge);
		Pageable pageable = new PageRequest(page, size);
		return reglementService.findReglementByCharge(charge,
				pageable);
	}

	@RequestMapping(value = "/reglement", method = RequestMethod.PUT)
	@ResponseBody
	public Reglement update(@Valid @RequestBody Reglement reglement) {
		Reglement employeEdite = reglementService.updateReglement(reglement);
		return employeEdite;
	}

}
