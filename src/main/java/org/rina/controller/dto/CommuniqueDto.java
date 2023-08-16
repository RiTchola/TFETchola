package org.rina.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.rina.model.Communique;
import org.rina.model.Etablissement;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommuniqueDto {
	
	private Integer id;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
	
	@NotBlank
    private String titre;
	
	@NotBlank
    private String contenu;
	
	@NotBlank
    private String nomEtablissement;

	/**
	 * @param id
	 * @param date
	 * @param contenu
	 * @param nomEtablissement
	 */
	public CommuniqueDto(Integer id, LocalDate date, String titre, String contenu,
			@NotBlank String nomEtablissement) {
		
		this.id = id;
		this.date = date;
		this.titre = titre;
		this.contenu = contenu;
		this.nomEtablissement = nomEtablissement;
	}
	
	/**
	 * Conversion Dto ==> Communique
	 * @param etab
	 * @return
	 */
	public Communique toCommunique (Etablissement etab) {
		return new Communique(id, date, titre, contenu, etab);
	}
	
	 /**
	  * Conversion Communique ==> Dto
	  * @param communique
	  * @return
	  */
	public static CommuniqueDto toDto(Communique com) {
		EtablissementDto eDto = EtablissementDto.toDto(com.getEtablissement());
		 return new CommuniqueDto(
				 com.getId(),
				 com.getDate(),
				 com.getTitre(),
				 com.getContenu(),
	             eDto.getNom() );
	 }
	 
}