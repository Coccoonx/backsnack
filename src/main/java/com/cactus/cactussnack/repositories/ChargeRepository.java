package com.cactus.cactussnack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Charge;

@RepositoryRestResource
public interface ChargeRepository extends CrudRepository<Charge, String> {

	Charge findByIntitule(@Param("intitule") String intitule);

	Charge findByCode(@Param("code") String code);

	Charge findById(@Param("id") String id);

}
