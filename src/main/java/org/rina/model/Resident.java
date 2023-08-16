package org.rina.model;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//Rajout d'une contrainte d'unicité sur la table
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "prenom", "dateNaissance" }))
@Data
@Entity(name = "TRESIDENT")
public class Resident {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Size(min = 1, max = 50, message = "{elem.nom}")
	@Column(length = 50, nullable = false)
	private String nom;

	@NotNull
	@Size(min = 1, max = 50, message = "{elem.prenom}")
	@Column(length = 50, nullable = false)
	private String prenom;

	@NotNull
	@Column(nullable = false)
	// @DateTimeFormat( pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;

	@Email(message = "{email.nonValide}")
	@NotNull
	@Column(length = 60, nullable = false)
	@Size(min = 4, max = 60, message = "{elem.prenom}")
	private String email;

	@NumberFormat
	@NotNull
	@Column(length = 50)
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel;

	@NotNull
	@Column(nullable = false, updatable = true)
	@Size(min = 10, max = 125, message = "{}")
	private String adresse;

	@NotNull
	@Column(nullable = false)
	private StatutM statut;

	@NotNull
	@Column(nullable = false)
	// @DateTimeFormat( pattern = "yyyy-MM-dd")
	private LocalDate dateEntree;

	@NotNull
	@Size(min = 5, max = 400, message = "{}")
	@Column(nullable = false)
	private String motifEntree;
	
	@Column(nullable = true)
	private LocalDate dateSortie;

	@Size(min = 5, max = 400, message = "{}")
	@Column(nullable = true)
	private String motifSortie;

	@NotNull
	@Size(min = 5, max = 400, message = "{}")
	@Column(nullable = false)
	private String etatSante;

	@NotNull
	@Size(min = 5, max = 800, message = "{}")
	@Column(nullable = false)
	private String antMedical;

	@NotNull
	@Size(min = 5, max = 800, message = "{}")
	@Column(nullable = false)
	private String antChirugical;

	@NotNull
	private Integer nbEnfant;

	@NotNull
	@Column(updatable = true)
	private String chambre;

	/**
	 * jointure à d'autres classes
	 */

	@Getter
	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FKUSER", unique = true, nullable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "FKMedecinTraitant", nullable = false)
	private MedecinTraitant medecinTraitant;

	@ManyToOne
	@JoinColumn(name = "FKEtablissement", nullable = false)
	private Etablissement etablissement;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TLIAISON", joinColumns = @JoinColumn(name = "FKRESIDENT"), inverseJoinColumns = @JoinColumn(name = "FKPERSONNECONTACT"))
	protected Set<PersonneContact> personneContacts = new HashSet<PersonneContact>();

	public Set<PersonneContact> getPersonneContacts() {
		return personneContacts;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "TVISITE", joinColumns = @JoinColumn(name = "FKRESIDENT"), inverseJoinColumns = @JoinColumn(name = "FKPERSONNEEXTERNE"))
	protected Set<PersonneExterne> personneExternes = new HashSet<PersonneExterne>();

	public Set<PersonneExterne> getPersonneExternes() {
		return personneExternes;
	}
	
	@OneToMany(mappedBy = "resident") // Nom de l'attribut dans RapportQuotidien
	private Set<RapportQuotidien> rapportQuotidiens = new HashSet<>();

	public Set<RapportQuotidien> getRapportQuotidiens() {
		return rapportQuotidiens;
	}
	
	@OneToMany(mappedBy = "resident")
	private Set<RapportVisite> rapportVisites = new HashSet<>(); 
	public Set<RapportVisite> getRapportVisite() { 
			return rapportVisites;
	}
	
	/**
	 * @param id
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
	 * @param user
	 * @param medecinTraitant
	 * @param etablissement
	 * @param personneContacts
	 */
	public Resident(Integer id, String nom, String prenom, LocalDate dateNaissance, String email,
			String tel, String adresse, StatutM statut, LocalDate dateEntree, String motifEntree,
			LocalDate dateSortie, String motifSortie, String etatSante, String antMedical,
			String antChirugical, Integer nbEnfant, String chambre, User user, MedecinTraitant medecinTraitant, 
			Etablissement etablissement) {

		assert (user.getRole() == Roles.ROLE_RESIDENT);
		this.id = id;
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
		this.user = user;
		this.medecinTraitant = medecinTraitant;
		this.etablissement = etablissement;
	}

}
