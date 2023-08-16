package org.rina.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity(name = "TPERSONNEEXTERNE")
public class PersonneExterne {
	
	@Id // Id généré par la base de données
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter //pas de setter
	private Integer id;

	@NotNull
	@Size(min = 1, max = 40, message = "{elem.nom}")
	@Column(length = 40, nullable = false)
	private String nom;
	
	@NotNull
	@Size(min = 1, max = 40, message = "{elem.prenom}")
	@Column(length = 40, nullable = false)
	private String prenom;

	@Email(message = "{email.nonValide}")
	@NotNull
	@Column(length = 40, nullable = false)
	@Size(min = 4, max = 40, message = "{}")
	private String email;

	@NumberFormat
	@NotNull
	@Column(length = 50)
	@Size(min = 4, max = 30, message = "{tel.nonValide}")
	private String tel;
	
	@NotNull
	@Column(nullable = false)
	private TypePersonne choix;
	
	
	/**
	 * jointure à d'autres classes 
	 */
	@OneToMany(mappedBy = "personneExterne")
	private Set<RapportVisite> rapportVisites = new HashSet<>(); 
	public Set<RapportVisite> getRapportVisite() { 
			return rapportVisites;
	}
	
	@ManyToMany(mappedBy = "personneExternes")
	private Set<Resident> residents = new HashSet<Resident>();
	public Set<Resident> getResidents() { return residents;}
	
	/**
	 * Construction 
	 */
	
	public PersonneExterne(Integer id, String nom, String prenom, String email,
			String tel, TypePersonne choix) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.choix= choix;
	}

	
}
