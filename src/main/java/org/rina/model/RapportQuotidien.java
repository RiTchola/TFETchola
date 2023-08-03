package org.rina.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@org.hibernate.annotations.Immutable // uniquement lorsque la classe est immutable
@Data
@Entity(name = "TRAPPORTQUOTIDIEN")
public class RapportQuotidien {

	@Data
	@NoArgsConstructor
	@Embeddable
	public static class Id implements Serializable {
		private static final long serialVersionUID = 1L;
		@Column(name = "FKRESIDENT")
		protected Integer residentId;
		@Column(name = "FKETABLISSEMENT")
		protected String etablissementId;

		public Id(Integer residentId, String etablissementId) {
			this.residentId = residentId;
			this.etablissementId = etablissementId;
		}
	}

	@EmbeddedId
	private Id id = new Id();
	
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer numeroR;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate date;
	
	@NotNull
	@Column(nullable = false)
	private String freqCardiaque;
	
	@NotNull
	@Column(nullable = false)
	private String freqRespiratoire;
	
	@NotNull
	@Column(nullable = false)
	private String presArterielle;
	
	@NotNull
	@Column(nullable = false)
	private String temperature;
	
	@NotNull
	@Column(nullable = false)
	private String satOxygene;
	
	@NotNull
	@Column(nullable = false)
	private String selle;
	
	@NotNull
	@Column(nullable = false)
	private String urine;
	
	@NotNull
	@Column(nullable = false)
	private String sommeil;
	
	@NotNull
	@Column(nullable = false)
	private String commentaire;

	/**
	 * jointure à d'autres classes 
	 */
	
	@ManyToOne
	@JoinColumn(name = "FRESIDENT", insertable = false, updatable = false)
	private Resident resident;

	@ManyToOne
	@JoinColumn(name = "FKETABLISSEMENT", insertable = false, updatable = false)
	private Etablissement etablissement;

	// Constructeur vide pour JPA
	public RapportQuotidien() {
	}

	/**
	 * Construction 
	 */
	public RapportQuotidien( Integer numeroR, LocalDate date, String freqCardiaque,
			String freqRespiratoire, String presArterielle, String temperature,
			String satOxygene, String selle, String urine, String sommeil,
			String commentaire, Resident resident, Etablissement etablissement) {
		
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
		this.resident = resident;
		this.etablissement = etablissement;
		// initialise les cl�s �trang�res de l'ID compos�
		this.id= new Id(resident.getId(),etablissement.getNom());
		// effectue les liens bidirectionnels
		etablissement.getRapportQuotidien().add(this);
		//resident.getRapportQuotidien()).add(this);
	}

}