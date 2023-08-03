package org.rina.model;

import java.sql.Time;
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
@Entity(name = "TACTIVITE")
public class Activite {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(length = 50, nullable = false)
	private String nom;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate date;
	
	@NotNull
	@Column(nullable = false)
	private Time time;

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
	
	public Activite(Integer id, String nom, LocalDate date, Time time, String description,
			Etablissement etablissement) {
		
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.time = time;
		this.description = description;
		this.etablissement = etablissement;
	}
	
}
