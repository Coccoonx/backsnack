package com.cactus.cactussnack.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cactus.cactussnack.models.Caisse;
import com.cactus.cactussnack.services.CaisseService;

@Controller
// @RestController
public class CaisseController {

	@Autowired
	CaisseService caisseService;

	@RequestMapping(value = "/caisse", method = RequestMethod.POST)
	@ResponseBody
	public Caisse create(@Valid @RequestBody Caisse caisse) {
		Caisse employeCree = caisseService.create(caisse);
		System.out.println(employeCree);
		return employeCree;
	}

	@RequestMapping(value = "/caisses", method = RequestMethod.GET)
	@ResponseBody
	public List<Caisse> findAll() {
		return caisseService.findAll();
	}
	
	@RequestMapping(value = "/caisse", method = RequestMethod.GET)
	@ResponseBody
	public Caisse findByCode(@RequestParam(value="code", required=true) String code) {
		System.out.println("Login : "+code);
		return caisseService.findByCode(code);
	}
	
	@RequestMapping(value = "/caisse", method = RequestMethod.PUT)
	@ResponseBody
	public Caisse update(@Valid @RequestBody Caisse caisse) {
		System.out.println("Old : "+ findByCode(caisse.getCode()));
		Caisse employeEdite = caisseService.update(caisse);
		System.out.println("New : "+ employeEdite);
		return employeEdite;
	}
	
	@RequestMapping(value = "/caisse", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(value="code", required=true) String code) {
		Caisse caisse = caisseService.findByCode(code);
		caisseService.delete(caisse);
	}

}
