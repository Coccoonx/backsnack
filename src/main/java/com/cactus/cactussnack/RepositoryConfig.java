package com.cactus.cactussnack;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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
@Import(RepositoryRestMvcConfiguration.class)

public class RepositoryConfig extends RepositoryRestMvcConfiguration  {
	@Override
	protected void configureRepositoryRestConfiguration(
			RepositoryRestConfiguration config) {
		config.exposeIdsFor(Caisse.class, Produit.class, Categorie.class,
				Charge.class, Client.class, Composer.class, Fournisseur.class,
				Operation.class, Reglement.class, Transaction.class,
				Utilisateur.class);
	}
}

