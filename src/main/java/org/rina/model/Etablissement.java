package org.rina.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Entity(name="TETABLISSEMENT")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "adresse" }))
public class Etablissement {
	
	@Id  // identifiant
	@Column(length = 50, nullable = false)
	private String nom;
	
	@Email(message = "{email.nonValide}")
	@NotNull
	@Column(length = 40, nullable = false)
	@Size(min = 4, max = 40)
	private String email1;
	
	@Email(message = "{email.nonValide}")
	@Column(length = 40)
	@Size(min = 4, max = 40)
	private String email2;

	@NumberFormat
	@NotNull
	@Column(length = 50)
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel1;
	
	@NumberFormat
	@Column(length = 50)
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel2;
	
	@NotNull
	@Column(nullable = false, updatable = true)
	@Size(min = 10, max = 125, message = "{}")
	private String adresse;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate dateCreation;
	
	/**
	 * jointure à d'autres classes 
	 */
	
	@Getter
	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FKUSER", unique = true, nullable = false, updatable = false)
	private User user;

	// Le nom "seance" doit correspondre au nom de l'attribut dans "Presence"
	@OneToMany(mappedBy = "etablissement")
	private Set<RapportQuotidien> rapportQuotidiens = new HashSet<>(); 
	public Set<RapportQuotidien> getRapportQuotidien() { 
			return rapportQuotidiens;
	}
	
	@OneToMany(mappedBy = "etablissement")
	private Set<RapportVisite> rapportVisites = new HashSet<>(); 
	public Set<RapportVisite> getRapportVisite() { 
			return rapportVisites;
	}
	
	/**
	 * Construction 
	 * @param nom
	 * @param email1
	 * @param tel1
	 * @param adresse
	 * @param dateCreation
	 * @param user
	 */
	public Etablissement(String nom, String email1, String email2, String tel1,
			String tel2, String adresse, LocalDate dateCreation,
			User user) {
		
		assert (user.getRole() == Roles.ROLE_ETABLISSEMENT);
		this.nom = nom;
		this.email1 = email1;
		this.email2 = email2;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.adresse = adresse;
		this.dateCreation = dateCreation;
		this.user = user;
	}
	
}
