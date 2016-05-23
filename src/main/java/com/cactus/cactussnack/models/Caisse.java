package com.cactus.cactussnack.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
//@Table(name = "Caisse")
public class Caisse {
	
	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();

	@Column(name = "code")
	@NotNull
	private String code;
	
	@Column(name = "intitule")
	@NotNull
	private String intitule ;

	@Column(name = "datecreation")
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation = new Date();

}
