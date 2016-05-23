package com.cactus.cactussnack.services;

import java.util.List;


import com.cactus.cactussnack.models.Charge;


public interface ChargeService {
	
	Charge create(Charge caisse);
	Charge findByIntitule(String intitule);
	Charge findByCode(String code);
	Charge findByUuid(String uuid);
	List<Charge> findAll();
	Charge update(Charge caisse);
	void delete(Charge caisse);

}
