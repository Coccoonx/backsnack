package com.cactus.cactussnack.services;

import java.util.List;


import com.cactus.cactussnack.models.Caisse;


public interface CaisseService {
	
	Caisse create(Caisse caisse);
	Caisse findByIntitule(String intitule);
	Caisse findByCode(String code);
	Caisse findByUuid(String uuid);
	List<Caisse> findAll();
	Caisse update(Caisse caisse);
	void delete(Caisse caisse);

}
