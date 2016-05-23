package com.cactus.cactussnack.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;


/*
 * Cette classe materialise une liste de produit
 * */

@Entity
//@Table(name="composer")
@Data
public class Composer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="quantite")
	@NotNull
	int quantite;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "produit_id")
	Produit produit;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "operation_id")
	Operation operation;
	
	

}
