package org.rina.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "TRAPPORTVISITE")
public class RapportVisite {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate dateVisite;
	
	@NotNull//différence entre not null et not blank
	@Column(length = 800, nullable = true)
	private String commentaire;
	
	/**
	 * jointure à d'autres classes 
	 */
	
	@ManyToOne
	@JoinColumn(name = "FKEtablissement", nullable = false)
	private Etablissement etablissement;
	
	@ManyToOne
	@JoinColumn(name = "FKPersonneExterne", nullable = false)
	private PersonneExterne personneExterne;

	@ManyToOne
	@JoinColumn(name = "FKResident", nullable = false)
	private Resident resident;

	/**
	 * Construction 
	 */
	public RapportVisite(Integer id, LocalDate dateVisite, String commentaire,
			Etablissement etablissement, PersonneExterne personneExterne, Resident resident) {
		
		this.id = id;
		this.dateVisite = dateVisite;
		this.commentaire = commentaire;
		this.etablissement = etablissement;
		this.personneExterne = personneExterne;
		this.resident = resident;
	}

}
