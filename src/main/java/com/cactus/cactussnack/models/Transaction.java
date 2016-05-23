package com.cactus.cactussnack.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Entity
//@Table(name="transaction")
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="status")
	@Enumerated(EnumType.ORDINAL)
	StatusTransaction status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetransaction")
	Date dateTransaction = new Date();
	
	@Column(name="typetransaction")
	@Enumerated(EnumType.ORDINAL)
	TransactionType transactionType;
	
	@Column(name="commentaires")
	String commentaires;
	
	@ManyToOne(optional=true)
	Caisse caisse;
	
	@ManyToOne(optional=true)
	Utilisateur utilisateur;
}
