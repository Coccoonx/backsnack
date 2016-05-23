package com.cactus.cactussnack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Caisse;
import com.cactus.cactussnack.models.Categorie;

@RepositoryRestResource
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {

	Categorie findByIntitule(@Param("intitule") String intitule);

	Categorie findById(@Param("id") int id);

}
