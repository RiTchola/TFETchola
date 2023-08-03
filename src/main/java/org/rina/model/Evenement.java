package org.rina.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//Rajout d'une contrainte d'unicité sur la table
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "dateEvent" }))
@Data
@Entity(name = "TEVENEMENT")
public class Evenement {
	
	@Id  // identifiant
	@Column(length = 50, nullable = false)
	private String nom;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate dateEvent;
	
	@Column(length = 800, nullable = true)
	private String description;
	
	/**
	 * jointure à d'autres classes 
	 */
	@ManyToOne
	@JoinColumn(name = "FKEtablissement", nullable = false)
	private Etablissement etablissement;

	/**
	 * Construction 
	 */
	public Evenement(String nom, LocalDate dateEvent, String description, Etablissement etablissement) {
		
		this.nom = nom;
		this.dateEvent = dateEvent;
		this.description = description;
		this.etablissement = etablissement;
	}
	
}
