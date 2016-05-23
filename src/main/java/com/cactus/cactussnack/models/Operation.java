package com.cactus.cactussnack.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;



@Entity
//@Table(name="operation")
@Data
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="status")
	@Enumerated(EnumType.ORDINAL)
	StatusOperation status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateoperation")
	Date dateOperation = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datelivraison")
	Date dateLivraison = new Date();
	
	@Column(name="typeoperation")
	@Enumerated(EnumType.ORDINAL)
	OperationType typeOperation;
	
	@Column(name="commentaires")
	String commentaires;
	
	
	
//	@OneToMany(mappedBy = "Composer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(targetEntity=Composer.class)
	Set<Composer> composer;
	

	@ManyToOne(optional=true)
	Client client;
	
	@ManyToOne(optional=true)
	Fournisseur fournisseur;
	
	
	@ManyToOne(optional=true)
	Utilisateur utilisateur;

}
