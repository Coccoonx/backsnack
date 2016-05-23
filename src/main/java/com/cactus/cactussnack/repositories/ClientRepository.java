package com.cactus.cactussnack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Client;

@RepositoryRestResource
public interface ClientRepository extends CrudRepository<Client, String> {

	Client findByNom(@Param("nom") String nom);

	Client findByNumTelephone(@Param("numtelephone") String numTelephone);

	Client findById(@Param("id") String id);

}
