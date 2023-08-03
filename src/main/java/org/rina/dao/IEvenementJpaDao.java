package org.rina.dao;

import java.time.LocalDate;

import java.util.List;

import org.rina.model.Etablissement;
import org.rina.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvenementJpaDao extends JpaRepository<Evenement, String>{
	
		// Utilisation d'un Query natif pour avoir les informations d'une activité
		@Query(value = "select * from TEVENEMENT e where e.dateEvent=?1 and e.fketab=?2", nativeQuery = true)
		List<Evenement> findEventByDate(LocalDate dateEvent, Etablissement etab);
		
		// Utilisation d'un Query natif pour avoir les informations d'une activité
		@Query(value = "select * from TEVENEMENT e where e.fketab=?1", nativeQuery = true)
		List<Evenement> findAllByEtablissement(Etablissement etab);

}
