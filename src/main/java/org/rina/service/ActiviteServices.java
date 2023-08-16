package org.rina.service;

import java.sql.Time;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.rina.dao.IActiviteJpaDao;
import org.rina.model.Activite;

public class ActiviteServices {
	
	private IActiviteJpaDao activitedao;
	
	public ActiviteServices(IActiviteJpaDao activitedao) {
		this.activitedao = activitedao;
	}

	/**
	 * @param nom
	 * @return
	 */
	public List<Activite> findActivityByName(String nom ,String etab) {
		return activitedao.findActivityByName(nom, etab);
	}

	/**
	 * @param nom
	 * @return
	 */
	public boolean existByName(String nom, String etab) {
		return activitedao.existByName(nom, etab);
	}
	
	/**
	 * @return
	 */
	public List<Activite> findAll() {
		return activitedao.findAll();
	}
	
	/**
	 * @param etablissement
	 * @return
	 */
	public List<Activite> findAllByEtablissement(String etab) {
		return activitedao.findAllByEtablissement(etab);
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<Activite> findById(Integer id) {
		return activitedao.findById(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean existsById(Integer id) {
		return activitedao.existsById(id);
	}

	/**
	 * @return
	 */
	public long count() {
		return activitedao.count();
	}

	/**
	 * @param id
	 */
	public void deleteById(Integer id) {
		activitedao.deleteById(id);
	}

	/**
	 * @param date
	 * @return
	 */
	public List<Activite> findActivityByDate(LocalDate date, String etab) {
		return activitedao.findActivityByDate(date, etab);
	}


	/**
	 * @param nom
	 * @param date
	 * @param time
	 * @return
	 */
	public boolean existByActivity(String nom, LocalDate date, Time time,String etab) {
		return activitedao.existByActivity(nom, date, time, etab);
	}
	
	/**
	 * Ajout d'un nouveau Activite
	 * 
	 * @param c1
	 * @return
	 */
	public Activite insert(Activite a1) {
		return update(a1);
	}

	private Activite update(Activite a1) {
		assert a1 != null : "L'activite doit exister";
		return activitedao.save(a1);
	}	

}
