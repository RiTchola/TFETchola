package org.rina.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "prenom", "dateNaissance" }))
@Data
@Entity(name = "TPERSONNEEXTERNE")
public class PersonneExterne {
	
	@Id // Id généré par la base de données
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter //pas de setter
	private Integer idPE;

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
	@DateTimeFormat( pattern = "yyyy-MM-dd")
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
	private String tel;
	
	@NotNull
	@Column(nullable = false, updatable = true)
	@Size(min = 10, max = 125, message = "{}")
	private String adresse;
	
	@NotNull
	@Column(nullable = false)
	private TypeExterne typeE;
	
	
	/**
	 * jointure à d'autres classes 
	 */
	
	@Getter
	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FKUSER", unique = true, nullable = false, updatable = false)
	private User user;
	
	/**
	 * Construction 
	 */

}
