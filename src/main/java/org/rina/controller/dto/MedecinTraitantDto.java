package org.rina.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.rina.model.MedecinTraitant;
import org.springframework.format.annotation.NumberFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedecinTraitantDto {

	@NotBlank
	private String numInami;

	@NotNull
	@Size(min = 1, max = 40, message = "{elem.nom}")
	private String nom;

	@NotNull
	@Size(min = 1, max = 40, message = "{elem.prenom}")
	private String prenom;

	@Email(message = "{email.nonValide}")
	private String email;

	@NumberFormat
	@NotNull
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel1;

	@NumberFormat
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel2;

	@NotNull
	@Size(min = 10, max = 125, message = "{}")
	private String adresse;

	/**
	 * @param numInami
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel1
	 * @param tel2
	 * @param adresse
	 */
	public MedecinTraitantDto(String numInami, String nom, String prenom, String email, String tel1, String tel2,
			String adresse) {

		this.numInami = numInami;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.adresse = adresse;
	}
	
	/**
	 * Conversion Dto ==> MedecinTraitant
	 * @return
	 */
	public MedecinTraitant toMedecinTraitant () {
		return new MedecinTraitant(numInami, nom, prenom, email, tel1, tel2, adresse);
	}

	/**
	 * Conversion MedecinTraitant ==> Dto 
	 * @return
	 */
	public static MedecinTraitantDto toDto(MedecinTraitant medct) {
		 return new MedecinTraitantDto(
				 medct.getNumInami(),
				 medct.getNom(),
				 medct.getPrenom(),
				 medct.getEmail(),
				 medct.getTel1(),
				 medct.getTel2(),
				 medct.getAdresse() );
	}
}
