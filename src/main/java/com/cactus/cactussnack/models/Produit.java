package com.cactus.cactussnack.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
// @Table(name="Produit")
@Data
public class Produit {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();

	@Column(name = "code")
	@NotNull
	private String code;

	@Column(name = "intitule")
	@NotNull
	private String intitule;

	@Column(name = "prixachat")
	@NotNull
	private double prixAchat;

	@Column(name = "prixvente")
	@NotNull
	private double prixVente;

	@Column(name = "qtitestock")
	@NotNull
	private int quantiteStock;

	@Column(name = "isservice")
	@NotNull
	private boolean isSservice;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categorie_id")
	private Categorie categorie;

	@Transient
	private int categorieId;

}
