package org.rina.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.rina.model.Etablissement;
import org.rina.model.Evenement;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class EvenementDto {
	
	private String nom;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEvent;
	
	@NotBlank
    private String description;
	
	@NotBlank
	private String nomEtablissement;

	/**
	 * @param nom
	 * @param dateEvent
	 * @param description
	 * @param nomEtablissement
	 */
	public EvenementDto(String nom, @NotNull LocalDate dateEvent, @NotBlank String description,
			@NotBlank String nomEtablissement) {
	
		this.nom = nom;
		this.dateEvent = dateEvent;
		this.description = description;
		this.nomEtablissement = nomEtablissement;
	}
	
	/**
	 * Conversion Dto ==> Evenement
	 * @param etab
	 * @return
	 */
	public Evenement toEvenement(Etablissement etab) {
		return new Evenement(nom, dateEvent, description, etab);
	}
    
    
    /**
     * Conversion Evenement ==> Dto
     * @param evenement
     * @return
     */
    public static EvenementDto toDto(Evenement event) {
    	EtablissementDto eDto = EtablissementDto.toDto(event.getEtablissement());
    	return new EvenementDto(
    			event.getNom(),
    			event.getDateEvent(),
    			event.getDescription(),
    			eDto.getNom() );
    }

}
