package org.rina.model;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//Rajout d'une contrainte d'unicité sur la table
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "prenom" , "dateNaissance" }))
@Data
@Entity(name = "TRESIDENT")
public class Resident {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRE;

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
	@DateTimeFormat( pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;

	@Email(message = "{email.nonValide}")
	@NotNull
	@Column(length = 60, nullable = false)
	@Size(min = 4, max = 60, message = "{elem.prenom}")
	private String email;

	@NumberFormat
	@NotNull
	@Column(length = 50)
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel;
	
	@NotNull
	@Column(nullable = false, updatable = true)
	@Size(min = 10, max = 125, message = "{}")
	private String adresse;
	
	@NotNull
	@Column(nullable = false)
	private StatutM statutM;
	
	@NotNull
	@Column(nullable = false)
	//@DateTimeFormat( pattern = "yyyy-MM-dd")
	private LocalDate dateEntree;
	
	@NotNull
	@Size(min = 5, max = 400, message = "{}")
	@Column(nullable = false)
	private String motifEntree;
	
	@NotNull
	@Size(min = 5, max = 400, message = "{}")
	@Column(nullable = false)
	private String etatSante;
	
	@NotNull
	@Size(min = 5, max = 800, message = "{}")
	@Column(nullable = false)
	private String antMedical;
	
	@NotNull
	@Size(min = 5, max = 800, message = "{}")
	@Column(nullable = false)
	private String antChirugical;
	
	@NotNull
	private Integer nbEnfant;
	
	@NotNull
	@Column(updatable = true)
	private String chambre;
	
	/**
	 * jointure à d'autres classes 
	 */
	
	@NotNull
	@Size(min = 2, max = 50 , message = "{elem.nom}")
	@Column(nullable = false, updatable = true)
	private String medecinTraitant; 
	@Getter
	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FKUSER", unique = true, nullable = false, updatable = false)
	private User user;
	
	
	/**
	 * Construction 
	 */


}
