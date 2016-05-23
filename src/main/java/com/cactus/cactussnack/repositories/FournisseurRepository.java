package com.cactus.cactussnack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Client;
import com.cactus.cactussnack.models.Fournisseur;

@RepositoryRestResource
public interface FournisseurRepository extends CrudRepository<Fournisseur, String> {

	Fournisseur findBySociete(@Param("societe") String societe);

	Fournisseur findByNumTelephone(@Param("numtelephone") String numTelephone);

	Fournisseur findById(@Param("id") String id);

}
