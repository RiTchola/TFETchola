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
@Entity(name = "TCOMMUNIQUE")
public class Communique {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate date;
	
	@NotNull
	@Column(nullable = false)
	private String contenu;
	
	/**
	 * jointure à d'autres classes 
	 */
	
	@ManyToOne
	@JoinColumn(name = "FKEtablissement", nullable = false)
	private Etablissement etablissement;
	
	/**
	 * Construction 
	 */
	
	public Communique(Integer id, LocalDate date, String contenu, Etablissement etablissement) {
		
		this.id = id;
		this.date = date;
		this.contenu = contenu;
		this.etablissement = etablissement;
	}

}
