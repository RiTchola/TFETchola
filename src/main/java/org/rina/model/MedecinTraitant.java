package org.rina.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "prenom" }))
@Data
@Entity(name = "TMEDECINTRAITANT")
public class MedecinTraitant {
	
	@Id  // identifiant
	@Column(length = 50, nullable = false)
	private String numInami;

	@NotNull
	@Size(min = 1, max = 40, message = "{elem.nom}")
	@Column(length = 40, nullable = false)
	private String nom;
	
	@NotNull
	@Size(min = 1, max = 40, message = "{elem.prenom}")
	@Column(length = 40, nullable = false)
	private String prenom;

	@Email(message = "{email.nonValide}")
	@NotNull
	@Column(length = 40, nullable = false)
	@Size(min = 4, max = 40, message = "{elem.prenom}")
	private String email;

	@NumberFormat
	@NotNull
	@Column(length = 50)
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel1;
	
	@NumberFormat
	@Column(length = 50)
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel2;
	
	@NotNull
	@Column(nullable = false, updatable = true)
	@Size(min = 10, max = 125, message = "{}")
	private String adresse;
	
	/**
	 * Construction 
	 */
	
	public MedecinTraitant( String numInami, String nom, String prenom,
			String email, String tel1, String tel2, String adresse) {
		
		this.numInami = numInami;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.adresse = adresse;	
	}

}
