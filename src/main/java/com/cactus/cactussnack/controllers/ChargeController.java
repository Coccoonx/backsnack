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

import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.services.ChargeService;

@Controller
// @RestController
public class ChargeController {

	@Autowired
	ChargeService chargeService;

	@RequestMapping(value = "/charge", method = RequestMethod.POST)
	@ResponseBody
	public Charge create(@Valid @RequestBody Charge charge) {
		Charge employeCree = chargeService.create(charge);
		System.out.println(employeCree);
		return employeCree;
	}

	@RequestMapping(value = "/charges", method = RequestMethod.GET)
	@ResponseBody
	public List<Charge> findAll() {
		return chargeService.findAll();
	}
	
	@RequestMapping(value = "/charge", method = RequestMethod.GET)
	@ResponseBody
	public Charge findByCode(@RequestParam(value="code", required=true) String code) {
		System.out.println("Login : "+code);
		return chargeService.findByCode(code);
	}
	
	@RequestMapping(value = "/charge", method = RequestMethod.PUT)
	@ResponseBody
	public Charge update(@Valid @RequestBody Charge charge) {
		System.out.println("Old : "+ findByCode(charge.getCode()));
		Charge employeEdite = chargeService.update(charge);
		System.out.println("New : "+ employeEdite);
		return employeEdite;
	}
	
	@RequestMapping(value = "/charge", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(value="code", required=true) String code) {
		Charge charge = chargeService.findByCode(code);
		chargeService.delete(charge);
	}

}
