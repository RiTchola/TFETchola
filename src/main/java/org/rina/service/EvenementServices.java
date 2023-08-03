package org.rina.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.rina.dao.IEvenementJpaDao;
import org.rina.model.Etablissement;
import org.rina.model.Evenement;

public class EvenementServices {
	
	private IEvenementJpaDao evenementdao;
		
		public EvenementServices(IEvenementJpaDao evenementdao) {
			this.evenementdao = evenementdao;
		}

		/**
		 * @param dateEvent
		 * @return
		 */
		public List<Evenement> findEventByDate(LocalDate dateEvent, Etablissement etab) {
			return evenementdao.findEventByDate(dateEvent, etab);
		}

		/**
		 * @return
		 */
		public List<Evenement> findAll() {
			return evenementdao.findAll();
		}

		
		
		/**
		 * @param etablissement
		 * @return
		 */
		public List<Evenement> findAllByEtablissement(Etablissement etablissement) {
			return evenementdao.findAllByEtablissement(etablissement);
		}

		/**
		 * @param id
		 * @return
		 */
		public Optional<Evenement> findById(String id) {
			return evenementdao.findById(id);
		}

		/**
		 * @param id
		 * @return
		 */
		public boolean existsById(String id) {
			return evenementdao.existsById(id);
		}

		/**
		 * @param id
		 */
		public void deleteById(String id) {
			evenementdao.deleteById(id);
		}
		
		/**
		 * Ajout d'un nouveau evenement
		 * 
		 * @param c1
		 * @return
		 */
		public Evenement insert(Evenement e1) {
			return update(e1);
		}

		private Evenement update(Evenement e1) {
			assert e1 != null : "Le evenement doit exister";
			return evenementdao.save(e1);
		}
		
}
