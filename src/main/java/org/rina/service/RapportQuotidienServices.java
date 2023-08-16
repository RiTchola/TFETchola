package org.rina.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.rina.dao.IRapportQuotidienJpaDao;
import org.rina.model.Etablissement;
import org.rina.model.RapportQuotidien;
import org.rina.model.RapportQuotidien.Id;
import org.rina.model.Resident;

public class RapportQuotidienServices {
private IRapportQuotidienJpaDao rapportQuotidiendao;
	
	public RapportQuotidienServices (IRapportQuotidienJpaDao rapportQuotidiendao) {
		this.rapportQuotidiendao = rapportQuotidiendao;
	}

	/**
	 * @param resident
	 * @return
	 */
	public List<RapportQuotidien> findByResident(Resident resident) {
		return rapportQuotidiendao.findByResident(resident);
	}

	/**
	 * @param etablissement
	 * @return
	 */
	public List<RapportQuotidien> findByEtablissement(Etablissement etablissement) {
		return rapportQuotidiendao.findByEtablissement(etablissement);
	}

	/**
	 * @return
	 */
	public List<RapportQuotidien> findRapportQuotidienOrderByDate() {
		return rapportQuotidiendao.findRapportQuotidienOrderByDate();
	}

	/**
	 * @param date
	 * @return
	 */
	public Optional<RapportQuotidien> findRapportQuotidienByDate(LocalDate date) {
		return rapportQuotidiendao.findRapportQuotidienByDate(date);
	}

	/**
	 * @return
	 */
	public List<RapportQuotidien> findAll() {
		return rapportQuotidiendao.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<RapportQuotidien> findById(Id id) {
		return rapportQuotidiendao.findById(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean existsById(Id id) {
		return rapportQuotidiendao.existsById(id);
	}

	/**
	 * @param id
	 */
	public void deleteById(Id id) {
		rapportQuotidiendao.deleteById(id);
	}

	/**
	 * Ajout d'un nouveau RapportQuotidien
	 * 
	 * @param rapQuot
	 * @return
	 */
	public RapportQuotidien insert(RapportQuotidien rapQuot) {
		return update(rapQuot);
	}

	private RapportQuotidien update(RapportQuotidien rapQuot) {
		assert rapQuot != null : "La rapportVisite doit exister";
		return rapportQuotidiendao.save(rapQuot);
	}	

}
