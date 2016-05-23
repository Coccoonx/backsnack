package com.cactus.cactussnack.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity
@Data
//@Table(name="Reglement")
public class Reglement {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="valeur")
	@NotNull
	private double valeur;
	
	@Column(name="dateoperation")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOperation = new Date();
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Charge charge;
	

}
