package com.cactus.cactussnack.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Operation;
import com.cactus.cactussnack.models.Reglement;
import com.cactus.cactussnack.models.Utilisateur;

@RepositoryRestResource
public interface OperationRepository extends CrudRepository<Operation, Integer> {

	@Query("SELECT o FROM Operation o WHERE o.utilisateur = :utilisateur")
	Page<Operation> findByUtilisateur(@Param("utilisateur") Utilisateur utilisateur, Pageable pageable);
	
//	@Query("SELECT o FROM Operation o WHERE o.charge = :charge")
//	Page<Operation> findByProduit(@Param("charge") Charge charge, Pageable pageable);
	
}
