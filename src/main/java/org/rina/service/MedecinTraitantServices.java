package org.rina.service;

import java.util.List;
import java.util.Optional;

import org.rina.dao.IMedecinTraitantJpaDao;
import org.rina.model.MedecinTraitant;
import org.rina.model.Etablissement;
import org.rina.model.Resident;

public class MedecinTraitantServices {
	
	private IMedecinTraitantJpaDao medecinTraitantdao;
		
		public MedecinTraitantServices(IMedecinTraitantJpaDao medecinTraitantdao) {
			this.medecinTraitantdao = medecinTraitantdao;
		}

		/**
		 * @param medecin
		 * @param etab
		 * @return
		 */
		public List<Resident> findResidByMedecin(MedecinTraitant medecin, Etablissement etab) {
			return medecinTraitantdao.findResidByMedecin(medecin, etab);
		}

		/**
		 * @param nom
		 * @return
		 */
		public List<MedecinTraitant> findByNom(String nom) {
			return medecinTraitantdao.findByNom(nom);
		}

		/**
		 * @param etab
		 * @return
		 */
		public int findMedecinByEtablissement(Etablissement etab) {
			return medecinTraitantdao.findMedecinByEtablissement(etab);
		}

		/**
		 * @return
		 */
		public List<MedecinTraitant> findAll() {
			return medecinTraitantdao.findAll();
		}

		/**
		 * @param id
		 * @return
		 */
		public Optional<MedecinTraitant> findById(String id) {
			return medecinTraitantdao.findById(id);
		}

		/**
		 * @param id
		 * @return
		 */
		public boolean existsById(String id) {
			return medecinTraitantdao.existsById(id);
		}

		/**
		 * @param id
		 */
		public void deleteById(String id) {
			medecinTraitantdao.deleteById(id);
		}

		/**
		 * @param entity
		 */
		public void delete(MedecinTraitant entity) {
			medecinTraitantdao.delete(entity);
		}
		
		/**
		 * Ajout d'un nouveau MedecinTraitant
		 * 
		 * @param c1
		 * @return
		 */
		public MedecinTraitant insert(MedecinTraitant m1) {
			return update(m1);
		}

		private MedecinTraitant update(MedecinTraitant m1) {
			assert m1 != null : "Le medecinTraitant doit exister";
			return medecinTraitantdao.save(m1);
		}	
		
}
