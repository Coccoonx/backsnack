package com.cactus.cactussnack.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
//@Table(name="Charge")
public class Charge {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code")
	@NotNull
	private String code;
	
	
	@Column(name="intitule")
	@NotNull
	private String intitule;
	
	@Column(name="periodicite")
	@NotNull
	private String periodicite;
	
	
}
