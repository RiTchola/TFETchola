package org.rina.dao;

import java.time.LocalDate;

import java.util.List;

import org.rina.model.Communique;
import org.rina.model.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommuniqueJpaDao extends JpaRepository<Communique, Integer> {
	
	// Utilisation d'un Query natif pour avoir les informations d'une activité
	@Query(value = "select * from TCOMMUNIQUE c where c.date=?1 and c.fketab=?2", nativeQuery = true)
	List<Communique> findCommuniqueByDate(LocalDate date, Etablissement etab);
	
	// Utilisation d'un Query natif pour avoir les informations d'une activité
	@Query(value = "select * from TCOMMUNIQUE c where c.fketab=?1", nativeQuery = true)
	List<Communique> findAllByEtablissement(Etablissement etab);

	
}
