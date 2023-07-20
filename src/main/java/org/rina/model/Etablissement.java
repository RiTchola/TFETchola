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
@Data
@Entity(name="TETABLISSEMENT")
public class Etablissement {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idE;
	
	@NotNull
	@Size(min = 3, max = 50, message = "{}")
	@Column(nullable = false)
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
	@DateTimeFormat( pattern = "yyyy-MM-dd")
	private LocalDate dateCreation;
	
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
