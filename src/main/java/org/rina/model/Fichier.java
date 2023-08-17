package org.rina.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "TFICHIER")
public class Fichier {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(length = 100, nullable = false)
	private String nomFichier;

	@NotNull
	@Column(length = 50, nullable = false)
	private String typeF;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate date;
	
	@NotNull
	private MultipartFile file;
	
	/**
	 * jointure à d'autres classes 
	 */
	@ManyToOne
	@JoinColumn(name = "FKPersonneContact", nullable = false)
	private PersonneContact personneContact;

	/**
	 * Construction 
	 *
	 * @param id
	 * @param nomFichier
	 * @param typeF
	 * @param date
	 * @param file
	 * @param personneContact
	 */
	public Fichier(Integer id, String nomFichier, String typeF, LocalDate date,
			MultipartFile file, PersonneContact personneContact) {
		
		this.id = id;
		this.nomFichier = nomFichier;
		this.typeF = typeF;
		this.date = date;
		this.file = file;
		this.personneContact = personneContact;
	}	

}
