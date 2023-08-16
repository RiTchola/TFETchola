package org.rina.service;

import java.util.List;
import java.util.Optional;

import org.rina.dao.IRapportVisiteJpaDao;
import org.rina.model.Etablissement;
import org.rina.model.RapportVisite;
import org.rina.model.PersonneExterne;
import org.rina.model.Resident;

public class RapportVisiteServices {
	
private IRapportVisiteJpaDao rapportVisitedao;
	
	public RapportVisiteServices (IRapportVisiteJpaDao rapportVisitedao) {
		this.rapportVisitedao = rapportVisitedao;
	}

	/**
	 * @param personneExterne
	 * @return
	 */
	public List<RapportVisite> findByPersonneExterne(PersonneExterne personneExterne) {
		return rapportVisitedao.findByPersonneExterne(personneExterne);
	}

	/**
	 * @param etablissement
	 * @return
	 */
	public List<RapportVisite> findByEtablissement(Etablissement etablissement) {
		return rapportVisitedao.findByEtablissement(etablissement);
	}

	/**
	 * @param resident
	 * @return
	 */
	public List<RapportVisite> findByResident(Resident resident) {
		return rapportVisitedao.findByResident(resident);
	}

	/**
	 * @return
	 */
	public List<RapportVisite> findRapportVisiteOrderByDate() {
		return rapportVisitedao.findRapportVisiteOrderByDate();
	}

	/**
	 * @param idVisit
	 * @return
	 */
	public Optional<PersonneExterne> findPersonExterneByVisite(Integer idVisit) {
		return rapportVisitedao.findPersonExterneByVisite(idVisit);
	}

	/**
	 * @param idVisit
	 * @return
	 */
	public Optional<Resident> findResidentByVisite(Integer idVisit) {
		return rapportVisitedao.findResidentByVisite(idVisit);
	}

	/**
	 * @param idVisit
	 * @return
	 */
	public Optional<Etablissement> findEtablissementByVisite(Integer idVisit) {
		return rapportVisitedao.findEtablissementByVisite(idVisit);
	}

	/**
	 * @return
	 */
	public List<RapportVisite> findAll() {
		return rapportVisitedao.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<RapportVisite> findById(Integer id) {
		return rapportVisitedao.findById(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean existsById(Integer id) {
		return rapportVisitedao.existsById(id);
	}

	/**
	 * @param id
	 */
	public void deleteById(Integer id) {
		rapportVisitedao.deleteById(id);
	}
	
	/**
	 * Ajout d'un nouveau RapportVisite
	 * 
	 * @param c1
	 * @return
	 */
	public RapportVisite insert(RapportVisite rapvi) {
		return update(rapvi);
	}

	private RapportVisite update(RapportVisite rapvi) {
		assert rapvi != null : "La rapportVisite doit exister";
		return rapportVisitedao.save(rapvi);
	}	


}
