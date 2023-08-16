package org.rina.controller.dto;

import java.time.LocalDate;


import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.rina.model.PersonneContact;
import org.rina.model.Roles;
import org.rina.model.StatutM;
import org.rina.model.TypePersonne;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class PersonneContactDto {

	private Integer id;

	@NotBlank
	private String nom;

	@NotBlank
	private String prenom;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;

	@Email(message = "{email.nonValide}")
	private String email;

	@NotBlank
	private String tel1;

	@NotBlank
	private String tel2;

	@NotBlank
	private String adresse;

	@NotNull
	private StatutM statut;

	@NotNull
	private TypePersonne choix;
	
	
	@Valid // N�cessaire pour la validation en cascade PersonneContact ==>User
	private UserDto user;

	/**
	 * 
	 */
	public PersonneContactDto() {
		id = null;
		user = new UserDto();
		user.setRole(Roles.ROLE_PCONTACT);
	}

	public PersonneContactDto(Integer id, String nom, String prenom, LocalDate dateNaissance, String email, 
			String tel1, String tel2, String adresse, StatutM statut, TypePersonne choix, UserDto user) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.adresse = adresse;
		this.statut = statut;
		this.choix = choix;
		user.setRole(Roles.ROLE_PCONTACT);
		this.user = user;
	}

	/**
	 * Conversion Dto ==> PersonneContact
	 * 
	 * @return PersonneContact sans cryptage du PW
	 */
	public PersonneContact toPersonneContact() {
		return new PersonneContact(id, nom, prenom, dateNaissance, email, tel1,
				tel2, adresse, statut, choix, user.toUser());
	}
	
	/**
	 * Conversion Dto ==> PersonneContact cryte le pw
	 * 
	 * @return PersonneContact avec le pw crypté
	 */
	public PersonneContact toPersonneContact(PasswordEncoder encodeur) {
		return new PersonneContact(id, nom, prenom, dateNaissance, email, tel1,
				tel2, adresse, statut, choix, user.toUser(encodeur));
	}
	
	/**
	 * Conversion PersonneContact ==> Dto 
	 * @param persC
	 * @return
	 */
	public static PersonneContactDto toDto(PersonneContact persC) {
		UserDto uDto = UserDto.toUserDto(persC.getUser());
	    PersonneContactDto persCDto = new PersonneContactDto(
	            persC.getId(),
	            persC.getNom(),
	            persC.getPrenom(),
	            persC.getDateNaissance(),
	            persC.getEmail(),
	            persC.getTel1(),
	            persC.getTel2(),
	            persC.getAdresse(),
	            persC.getStatut(),
	            persC.getChoix(),
	            uDto
	        );
	     return persCDto;
	 }
}
