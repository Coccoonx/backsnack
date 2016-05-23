package com.cactus.cactussnack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.cactus.cactussnack.models.Caisse;
import com.cactus.cactussnack.models.Categorie;
import com.cactus.cactussnack.models.Charge;
import com.cactus.cactussnack.models.Client;
import com.cactus.cactussnack.models.Composer;
import com.cactus.cactussnack.models.Fournisseur;
import com.cactus.cactussnack.models.Operation;
import com.cactus.cactussnack.models.Produit;
import com.cactus.cactussnack.models.Reglement;
import com.cactus.cactussnack.models.Transaction;
import com.cactus.cactussnack.models.Utilisateur;

@Configuration
@ComponentScan
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@PropertySource("application.properties")
public class LaucherApp{

	public static void main(String[] args) {
		SpringApplication.run(LaucherApp.class, args);			
	}
	
	/*
	@Override
	protected void configureRepositoryRestConfiguration(
			RepositoryRestConfiguration config) {
		config.exposeIdsFor(Caisse.class, Produit.class, Categorie.class,
				Charge.class, Client.class, Composer.class, Fournisseur.class,
				Operation.class, Reglement.class, Transaction.class,
				Utilisateur.class);
	}
	*/
	

}