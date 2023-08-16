package org.rina.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.rina.model.Etablissement;
import org.rina.model.RapportQuotidien;
import org.rina.model.Resident;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RapportQuotidienDto {

	private Integer numeroR;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@NotBlank
	private String freqCardiaque;
	
	@NotBlank
	private String freqRespiratoire;
	
	@NotBlank
	private String presArterielle;
	
	@NotBlank
	private String temperature;
	
	@NotBlank
	private String satOxygene;
	
	@NotBlank
	private String selle;
	
	@NotBlank
	private String urine;
	
	@NotBlank
	private String sommeil;
	
	@NotBlank
	private String commentaire;
	
	@NotNull
	private Integer residentId;
	
	@NotBlank
	private String nomEtablissement;

	/**
	 * @param numeroR
	 * @param date
	 * @param freqCardiaque
	 * @param freqRespiratoire
	 * @param presArterielle
	 * @param temperature
	 * @param satOxygene
	 * @param selle
	 * @param urine
	 * @param sommeil
	 * @param commentaire
	 * @param residentId
	 * @param nomEtablissement
	 */
	public RapportQuotidienDto( Integer numeroR, LocalDate date, String freqCardiaque, String freqRespiratoire,
			String presArterielle, String temperature, String satOxygene, String selle, String urine,
			String sommeil, String commentaire, Integer residentId, String nomEtablissement) {

		this.numeroR = numeroR;
		this.date = date;
		this.freqCardiaque = freqCardiaque;
		this.freqRespiratoire = freqRespiratoire;
		this.presArterielle = presArterielle;
		this.temperature = temperature;
		this.satOxygene = satOxygene;
		this.selle = selle;
		this.urine = urine;
		this.sommeil = sommeil;
		this.commentaire = commentaire;
		this.residentId = residentId;
		this.nomEtablissement = nomEtablissement;
	}
	
	/**
	 * conersion Dto ==> RapportQuotidien
	 * @param etab
	 * @param resid
	 * @return
	 */
	public RapportQuotidien toRapportQuotidien(Etablissement etab, Resident resid) {
		return new RapportQuotidien(numeroR, date, freqCardiaque, freqRespiratoire, presArterielle,
						 temperature, satOxygene, selle, urine, sommeil, commentaire, resid, etab);	
	}

    /**
     * conersion RapportQuotidien ==> Dto 
     * @param rapQuot
     * @return
     */
    public static RapportQuotidienDto toDto(RapportQuotidien rapQuot) {
    	return new RapportQuotidienDto(
            rapQuot.getNumeroR(),
            rapQuot.getDate(),
            rapQuot.getFreqCardiaque(),
            rapQuot.getFreqRespiratoire(),
            rapQuot.getPresArterielle(),
            rapQuot.getTemperature(),
            rapQuot.getSatOxygene(),
            rapQuot.getSelle(),
            rapQuot.getUrine(),
            rapQuot.getSommeil(),
            rapQuot.getCommentaire(),
            rapQuot.getResident().getId(),
            rapQuot.getEtablissement().getNom() );
    }
    
}
