package com.cactus.cactussnack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Caisse;

@RepositoryRestResource
public interface CaisseRepository extends CrudRepository<Caisse, String> {

	Caisse findByIntitule(@Param("intitule") String intitule);

	Caisse findByCode(@Param("code") String code);

	Caisse findById(@Param("id") String id);

}
