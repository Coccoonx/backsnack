package com.cactus.cactussnack.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
//@Table(name = "utilisateur")
@Data
public class Utilisateur {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();
	
	@Column(name = "matricule")
	@NotNull
	private String matricule;

	@Column(name = "login")
	@NotNull
	private String login;

	@Column(name = "password")
	@NotNull
	private String password;

	@Column(name = "nom")
	@NotNull
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "poste")
	private String poste;
	
	@Column(name = "niveau")
	@NotNull
	private int niveau;

	@Column(name = "dateenregistrement")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEnregistrement = new Date();

}
