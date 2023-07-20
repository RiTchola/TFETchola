package org.rina.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "TRAPPORT")
public class Rapport {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRA;

	@NotNull
	@Size(min = 1, max = 50, message = "{elem.nom}")
	@Column(length = 50, nullable = false)
	private String nom;

	@NotNull
	@Size(min = 1, max = 50, message = "{elem.prenom}")
	@Column(length = 50, nullable = false)
	private String prenom;
	
	@NotNull
	@Column(nullable = false)
	private TypeExterne typeE;
	
	@NotNull
	@Column(nullable = false)
	@DateTimeFormat( pattern = "yyyy-MM-dd")
	private LocalDate dateVisite;

	@NotBlank
	@Column(nullable = false)
	private String description;
	
	/**
	 * jointure à d'autres classes 
	 */
	
	
	/**
	 * Construction 
	 */
}
