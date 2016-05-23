package com.cactus.cactussnack.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Reglement;
import com.cactus.cactussnack.models.Utilisateur;

@RepositoryRestResource
public interface ReglementRepository extends CrudRepository<Reglement, Integer> {

	@Query("SELECT r FROM Reglement r WHERE r.utilisateur = :utilisateur")
	Page<Reglement> findByUtilisateur(@Param("utilisateur") Utilisateur utilisateur, Pageable pageable);
	
	@Query("SELECT r FROM Reglement r WHERE r.charge = :charge")
	Page<Reglement> findByCharge(@Param("charge") Charge charge, Pageable pageable);
	
}
