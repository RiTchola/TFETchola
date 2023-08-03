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
import javax.persistence.ManyToMany;
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

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "prenom", "dateNaissance" }))
@Data
@Entity(name = "TPERSONNECONTACT")
public class PersonneContact {
	
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

	@NotNull
	@Column(nullable = false)
	//@DateTimeFormat( pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;

	@Email(message = "{email.nonValide}")
	@NotNull
	@Column(length = 40, nullable = false)
	@Size(min = 4, max = 40, message = "{elem.prenom}")
	private String email;

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
	private StatutM statut;
	
	@NotNull
	@Column(nullable = false)
	private TypePersonne choix;
	
	/**
	 * jointure à d'autres classes 
	 */
	
	@Getter
	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FKUSER", unique = true, nullable = false, updatable = false)
	private User user;

	@ManyToMany(mappedBy = "personneContacts")
	private Set<Resident> residents = new HashSet<Resident>();
	public Set<Resident> getResidents() { return residents;}
	
	/**
	 * Construction
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param email
	 * @param tel1 
	 * @param adresse
	 * @param statutM
	 * @param choix
	 * @param user
	 * @param 
	 */
	
	public PersonneContact(Integer id, String nom, String prenom, LocalDate dateNaissance,String email, 
			String tel1, String tel2, String adresse, StatutM statut, TypePersonne choix, User user) {
		
		assert (user.getRole() == Roles.ROLE_PCONTACT);
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.adresse = adresse;
		this.statut = statut;
		this.choix = choix;
		this.user = user;
	}
	
}
