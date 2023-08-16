package org.rina.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.rina.dao.IFichierJpaDao;
import org.rina.model.Fichier;
import org.rina.model.PersonneContact;

public class FichierServices {

	private IFichierJpaDao fichierdao;

	public FichierServices(IFichierJpaDao fichierdao) {
		this.fichierdao = fichierdao;
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<PersonneContact> findPCByFichier(Integer id) {
		return fichierdao.findPCByFichier(id);
	}

	/**
	 * @param personneContact
	 * @return
	 */
	public List<Fichier> findByPersonneContactOrderByDate(PersonneContact personneContact) {
		return fichierdao.findByPersonneContactOrderByDate(personneContact);
	}

	/**
	 * @param date
	 * @return
	 */
	public List<Fichier> findAllFichiersOrderByDate(LocalDate date) {
		return fichierdao.findAllFichiersOrderByDate(date);
	}

	/**
	 * @return
	 */
	public List<Fichier> findAll() {
		return fichierdao.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<Fichier> findById(Integer id) {
		return fichierdao.findById(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean existsById(Integer id) {
		return fichierdao.existsById(id);
	}

	/**
	 * @param id
	 */
	public void deleteById(Integer id) {
		fichierdao.deleteById(id);
	}

	/**
	 * @return
	 */
	public List<Fichier> findAllFichierOrderByDateDesc() {
		return fichierdao.findAllFichierOrderByDateDesc();
	}

	/**
	 * Ajout d'un nouveau Fichier
	 * 
	 * @param c1
	 * @return
	 */
	public Fichier insert(Fichier f1) {
		return update(f1);
	}

	private Fichier update(Fichier f1) {
		assert f1 != null : "Le fichier doit exister";
		return fichierdao.save(f1);
	}

}
