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
@Entity(name = "TFICHIER")
public class Fichier {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(length = 50, nullable = false)
	private String typeF;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate date;
	
	/**
	 * jointure à d'autres classes 
	 */
	@ManyToOne
	@JoinColumn(name = "FKPersonneContact", nullable = false)
	private PersonneContact personneContact;

	/**
	 * Construction 
	 */
	public Fichier(Integer id, String typeF, LocalDate date, PersonneContact personneContact) {
		
		this.id = id;
		this.typeF = typeF;
		this.date = date;
		this.personneContact = personneContact;
	}	

}
