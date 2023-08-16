package org.rina.controller.dto;

import java.sql.Time;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.rina.model.Activite;
import org.rina.model.Etablissement;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActiviteDto {
	
	private Integer id;
	
	@NotBlank
	private String nom;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@NotNull
	private Time time;

	@NotBlank
	@Size(min=1, max=800, message="{description}")
	private String description;
	
	@NotBlank
	@Size(min=1, max= 50, message ="{description}")
	private String nomEtablissement;

	/**
	 * @param id
	 * @param nom
	 * @param date
	 * @param time
	 * @param description
	 * @param nomEtablissement
	 */
	public ActiviteDto(Integer id, String nom, @NotNull LocalDate date, @NotNull Time time,
			@NotBlank @Size(min = 1, max = 800, message = "{description}") String description,
			@NotBlank @Size(min = 1, max = 50, message = "{description}") String nomEtablissement) {
		
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.time = time;
		this.description = description;
		this.nomEtablissement = nomEtablissement;
	}
	
	/**
	 * Conversion Dto ==> Activite
	 * @param etab
	 * @return
	 */
	public Activite toActivite(Etablissement etab) {
		return new Activite(id, nom, date, time, description, etab);	
	}
	
	/**
	 * Conversion Activite ==> Dto
	 * @param act
	 * @return
	 */
	public static ActiviteDto toDto(Activite act) {
		EtablissementDto eDto = EtablissementDto.toDto(act.getEtablissement());
		return new ActiviteDto(
				act.getId(),
				act.getNom(), 
				act.getDate(), 
				act.getTime(), 
				act.getDescription(),
				eDto.getNom() );	
	}	
	
}
