package com.cactus.cactussnack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cactus.cactussnack.models.Utilisateur;

@RepositoryRestResource
public interface UtilisateurRepository extends CrudRepository<Utilisateur, String> {

	Utilisateur findByNom(@Param("nom") String name);

	Utilisateur findByLogin(@Param("login") String login);
	
	Utilisateur findByMatricule(@Param("matricule") String matricule);
	
	Utilisateur findById(@Param("id") String id);
	
	

}
