package com.cactus.cactussnack.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Caisse;
import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Reglement;
import com.cactus.cactussnack.models.Transaction;
import com.cactus.cactussnack.models.Utilisateur;

@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	@Query("SELECT t FROM Transaction t WHERE t.utilisateur = :utilisateur")
	Page<Transaction> findByUtilisateur(@Param("utilisateur") Utilisateur utilisateur, Pageable pageable);
	
	@Query("SELECT t FROM Transaction t WHERE t.caisse = :caisse")
	Page<Transaction> findByCaisse(@Param("caisse") Caisse caisse, Pageable pageable);
	
}
