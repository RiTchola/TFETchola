package org.rina.controller.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.rina.model.Etablissement;
import org.rina.model.MedecinTraitant;
import org.rina.model.Resident;
import org.rina.model.Roles;
import org.rina.model.StatutM;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class ResidentDto {
	
    private Integer id;
    
    @Valid // N�cessaire pour la validation en cascade Resident ==>User
	private UserDto user;
    
    @NotBlank
    private String nom;
    
    @NotBlank
    private String prenom;
    
    @NotNull
	@DateTimeFormat( pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance;
   
    @Email(message = "{email.nonValide}")
    private String email;
    
    @NumberFormat
	@NotNull
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
    private String tel;
   
    @NotBlank
    private String adresse;
   
    @NotNull
    private StatutM statut;
   
    @NotNull
	@DateTimeFormat( pattern = "yyyy-MM-dd")
    private LocalDate dateEntree;
    
    @NotBlank
    private String motifEntree;
    
	@DateTimeFormat( pattern = "yyyy-MM-dd")
    private LocalDate dateSortie;
    
    private String motifSortie;
   
    @NotBlank
    private String etatSante;

    @NotBlank
    private String antMedical;
    
    @NotBlank 
    private String antChirugical;
   
    @NotNull
    private Integer nbEnfant;
    
    @NotBlank
    private String chambre;
    
    @NotBlank
    private String medecinId;
    
    @NotBlank
    private String nomEtablissement;
    
    public ResidentDto() {
    	id = null;
		user = new UserDto();
		user.setRole(Roles.ROLE_RESIDENT);
    }
    
    /**
     * @param id
     * @param user
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param email
     * @param tel
     * @param adresse
     * @param statut
     * @param dateEntree
     * @param motifEntree
     * @param dateSortie
     * @param motifSortie
     * @param etatSante
     * @param antMedical
     * @param antChirugical
     * @param nbEnfant
     * @param chambre
     * @param medecinId
     * @param nomEtablissement
     */
    public ResidentDto(Integer id, UserDto user, String nom, String prenom, LocalDate dateNaissance, String email,
            String tel, String adresse, StatutM statut, LocalDate dateEntree, String motifEntree,
            LocalDate dateSortie, String motifSortie, String etatSante, String antMedical,
            String antChirugical, Integer nbEnfant, String chambre,
            String medecinId, String nomEtablissement ) {
    	
        this.id = id;
        user.setRole(Roles.ROLE_RESIDENT);
      	this.user = user;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
        this.statut = statut;
        this.dateEntree = dateEntree;
        this.motifEntree = motifEntree;
        this.dateSortie = dateSortie;
        this.motifSortie = motifSortie;
        this.etatSante = etatSante;
        this.antMedical = antMedical;
        this.antChirugical = antChirugical;
        this.nbEnfant = nbEnfant;
        this.chambre = chambre;
        this.medecinId = medecinId;
        this.nomEtablissement = nomEtablissement;
    }
    
    /**
   	 * Conversion Dto ==> Resident
   	 * 
   	 * @return Resident sans cryptage du PW
   	 */
   	public Resident toResident(MedecinTraitant medecin, Etablissement etab) {
		return new Resident(id, nom, prenom, dateNaissance, email, tel, adresse, statut, dateEntree, 
				motifEntree, dateSortie, motifSortie, etatSante, antMedical, antChirugical,
				nbEnfant, chambre, user.toUser(), medecin, etab);	
   	}
    
	/**
	 * Conversion Dto ==> Resident cryte le pw
	 * 
	 * @return Resident avec le pw crypté
	 */
   	public Resident toResident(PasswordEncoder encodeur, MedecinTraitant medecin, Etablissement etab) {
		return new Resident(id, nom, prenom, dateNaissance, email, tel, adresse, statut, dateEntree, 
				motifEntree, dateSortie, motifSortie, etatSante, antMedical, antChirugical,
				nbEnfant, chambre, user.toUser(encodeur), medecin, etab);	
   	}
    
    public static ResidentDto toDto(Resident resid) {
    	UserDto uDto = UserDto.toUserDto(resid.getUser());
    	MedecinTraitantDto mDto = MedecinTraitantDto.toDto(resid.getMedecinTraitant());
    	EtablissementDto eDto = EtablissementDto.toDto(resid.getEtablissement());
        ResidentDto residDto = new ResidentDto(
        		resid.getId(),
        		uDto,
        		resid.getNom(),
        		resid.getPrenom(),
        		resid.getDateNaissance(),
        		resid.getEmail(),
        		resid.getTel(),
                resid.getAdresse(),
                resid.getStatut(),
                resid.getDateEntree(),
                resid.getMotifEntree(),
                resid.getDateSortie(),
                resid.getMotifSortie(),
                resid.getEtatSante(),
                resid.getAntMedical(),
                resid.getAntChirugical(),
                resid.getNbEnfant(),
                resid.getChambre(),
                mDto.getNumInami(),
        		eDto.getNom() );
        return residDto;
    }

}
