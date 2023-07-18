package org.rina.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.rina.util.validation.annotation.DatesPastAndFutureValidation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name = "TMODULE")
@DatesPastAndFutureValidation(d1 = "dateDebut", d2 = "dateFin", message = "{date.compare}")
public class Module {
	public static enum MAS {
		MATIN, APM, SOIR
	}

	@Id
	@Pattern(regexp = "[A-Z0-9]{3,8}-[0-9]-[A-Z]", message = "{elem.code}")
	@Column(length = 12)
	private String code;

	@NotNull
	@Column(nullable = false)
	private LocalDate dateDebut;

	@NotNull
	@Column(nullable = false)
	private LocalDate dateFin;

	@Column(nullable = false)
	private MAS moment;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FKCOURS", nullable = false)
	@NotNull
	private Cours cours;

	@ManyToOne
	@JoinColumn(name = "FKPROFESSEUR")
	private Professeur professeur;

}
