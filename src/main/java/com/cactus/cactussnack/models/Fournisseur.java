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
//@Table(name = "fournisseur")
@Data
public class Fournisseur {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();
	
	@Column(name = "societe")
	@NotNull
	private String societe;

	@Column(name = "numtelephone")
	@NotNull
	private String numTelephone;

	@Column(name = "dateenregistrement")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEnregistrement = new Date();


}
