package org.rina.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.rina.model.PersonneExterne;
import org.rina.model.TypePersonne;
import org.springframework.format.annotation.NumberFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonneExterneDto {

	private Integer id;

	@NotBlank
	@Size(min = 1, max = 40, message = "{elem.nom}")
	private String nom;

	@NotBlank
	@Size(min = 1, max = 40, message = "{elem.prenom}")
	private String prenom;

	@Email(message = "{email.nonValide}")
	private String email;

	@NumberFormat
	@NotBlank
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel;

	@NotNull
	private TypePersonne choix;
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param choix
	 */
	public PersonneExterneDto(Integer id, String nom, String prenom, String email, String tel, TypePersonne choix) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.choix = choix;
	}
	
	/**
	 * conversion Dto ==> PersonneExterne
	 * @return
	 */
	public PersonneExterne toPersonneExterne() {
		return new PersonneExterne(id, nom, prenom, email, tel, choix);	
	}
	
	/**
	 * conversion PersonneExterne ==> Dto 
	 * @return
	 */
	public static PersonneExterneDto toDto(PersonneExterne persE) {
		return  new PersonneExterneDto(
        		persE.getId(),
        		persE.getNom(),
        		persE.getPrenom(),
        		persE.getEmail(),
        		persE.getTel(),
        		persE.getChoix() );
    }

}
