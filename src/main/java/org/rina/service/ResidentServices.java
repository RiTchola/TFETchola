package org.rina.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.rina.dao.IResidentJpaDao;
import org.rina.model.Resident;
import org.rina.model.PersonneContact;
import org.rina.model.PersonneExterne;

public class ResidentServices {

	private IResidentJpaDao residentdao;
	
	public ResidentServices (IResidentJpaDao residentdao) {
		this.residentdao = residentdao;
	}

	/**
	 * @param username
	 * @return
	 */
	public Optional<Resident> findByUsername(String username) {
		return residentdao.findByUsername(username);
	}

	/**
	 * @param username
	 * @return
	 */
	public boolean existByUserName(String username) {
		return residentdao.existByUserName(username);
	}

	/**
	 * @param nom
	 * @param prenom
	 * @return
	 */
	public Optional<Resident> findByNames(String nom, String prenom) {
		return residentdao.findByNames(nom, prenom);
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @return
	 */
	public Optional<Resident> findByNamesAndBirth(String nom, String prenom, LocalDate dateNaissance) {
		return residentdao.findByNamesAndBirth(nom, prenom, dateNaissance);
	}

	/**
	 * @param nom
	 * @param prenom
	 * @return
	 */
	public boolean existByNames(String nom, String prenom) {
		return residentdao.existByNames(nom, prenom);
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @return
	 */
	public boolean existByNamesAndBirth(String nom, String prenom, LocalDate dateNaissance) {
		return residentdao.existByNamesAndBirth(nom, prenom, dateNaissance);
	}

	/**
	 * @param idResid
	 * @return
	 */
	public List<PersonneContact> findAllPersonContactToResid(Integer idResid) {
		return residentdao.findAllPersonContactToResid(idResid);
	}

	/**
	 * @return
	 */
	public List<Resident> findAll() {
		return residentdao.findAll();
	}

	/**
	 * @param idResid
	 * @return
	 */
	public List<PersonneExterne> findAllPersonExterneToResid(Integer idResid) {
		return residentdao.findAllPersonExterneToResid(idResid);
	}

	/**
	 * @param idResid
	 * @return
	 */
	public List<Resident> findMedecinByResid(Integer idResid) {
		return residentdao.findMedecinByResid(idResid);
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<Resident> findById(Integer id) {
		return residentdao.findById(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean existsById(Integer id) {
		return residentdao.existsById(id);
	}

	/**
	 * @param id
	 */
	public void deleteById(Integer id) {
		residentdao.deleteById(id);
	}

	/**
	 * Ajout d'un nouveau Resident
	 * 
	 * @param c1
	 * @return
	 */
	public Resident insert(Resident re1) {
		return update(re1);
	}

	private Resident update(Resident re1) {
		assert re1 != null : "La resident doit exister";
		return residentdao.save(re1);
	}	


}
