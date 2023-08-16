package org.rina.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.rina.model.Etablissement;
import org.rina.model.PersonneExterne;
import org.rina.model.RapportVisite;
import org.rina.model.Resident;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RapportVisiteDto {
	
    private Integer id;
    
    @NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateVisite;
    
    @NotBlank
    private String commentaire;
    
    @NotBlank
    private String nomEtablissement;
    
    @NotNull
    private Integer personneExterneId;
    
    @NotNull
    private Integer residentId;

    /**
     * @param id
     * @param dateVisite
     * @param commentaire
     * @param nomEtablissement
     * @param personneExterneId
     * @param residentId
     */
    public RapportVisiteDto(Integer id, LocalDate dateVisite, String commentaire,
    		String nomEtablissement, Integer personneExterneId, Integer residentId) {

        this.id = id;
        this.dateVisite = dateVisite;
        this.commentaire = commentaire;
        this.nomEtablissement = nomEtablissement;
        this.personneExterneId = personneExterneId;
        this.residentId = residentId;
    }
    
    /**
     * conversion Dto ==> RapportVisite
     * @param etab
     * @param persE
     * @param resid
     * @return
     */
    public RapportVisite toRapportVisite(Etablissement etab, PersonneExterne persE, Resident resid) {
		return new RapportVisite(id, dateVisite, commentaire, etab, persE, resid);	
    }
    
    /**
     * conversion RapportVisite ==> Dto
     * @param rapVi
     * @return
     */
    public static RapportVisiteDto toDto(RapportVisite rapVi) {
    	 return new RapportVisiteDto(
            rapVi.getId(),
            rapVi.getDateVisite(),
            rapVi.getCommentaire(),
            rapVi.getEtablissement().getNom(),
            rapVi.getPersonneExterne().getId(),
            rapVi.getResident().getId() );
    }

}
