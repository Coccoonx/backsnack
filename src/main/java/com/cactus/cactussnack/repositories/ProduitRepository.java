package com.cactus.cactussnack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Produit;

@RepositoryRestResource
public interface ProduitRepository extends CrudRepository<Produit, String> {

	Produit findByIntitule(@Param("intitule") String intitule);

	Produit findByCode(@Param("code") String code);

	Produit findById(@Param("id") String id);

}
