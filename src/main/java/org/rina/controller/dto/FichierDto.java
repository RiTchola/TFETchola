package org.rina.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.rina.model.Fichier;
import org.rina.model.PersonneContact;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FichierDto {
	
	private Integer id;
	
	@NotBlank
	private String nomFichier;
	
	@NotBlank
    private String typeF;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
	
	@NotNull
	private MultipartFile file;
	
	@NotNull
    private Integer personContactId;

	/**
	 * @param id
	 * @param typeF
	 * @param date
	 * @param document
	 * @param personContactId
	 */
	public FichierDto(Integer id, String nomFichier, String typeF, LocalDate date, MultipartFile file, Integer personContactId) {
		
		this.id = id;
		this.nomFichier = nomFichier;
		this.typeF = typeF;
		this.date = date;
		this.file = file;
		this.personContactId = personContactId;
	}

	/**
	 * Conversion Dto ==> Fichier
	 * @param personc
	 * @return
	 */
	public Fichier toFichier(PersonneContact persC) {
		return new Fichier(id, nomFichier, typeF, date, file, persC);
		
	}

    /**
     * Conversion Fichier ==> Dto
     * @param fichier
     * @return
     */
    public static FichierDto toDto(Fichier fichier) {
    	return new FichierDto(
            fichier.getId(),
            fichier.getNomFichier(),
            fichier.getTypeF(),
            fichier.getDate(),
            fichier.getFile(), 
            fichier.getPersonneContact().getId() );
    }
	
}
