package org.rina.dao;

import java.sql.Time;

import java.time.LocalDate;
import java.util.List;

import org.rina.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IActiviteJpaDao extends JpaRepository<Activite, Integer> {

		// Utilisation d'un Query natif pour avoir les informations d'une activité
		@Query(value = "select * from TACTIVITE a where a.nom=?1 and a.fketab=?2", nativeQuery = true)
		List<Activite> findActivityByName(String nom, String etab);
	
		// Utilisation d'un Query natif pour savoir si une activité existe
		@Query(value = "select * from TACTIVITE a where a.nom=?1 and a.fketab=?2", nativeQuery = true)
		boolean existByName(String nom, String etab);
	
		// Utilisation d'un Query natif pour avoir les informations d'une activité
		@Query(value = "select * from TACTIVITE a where a.date=?1 and a.fketab=?2", nativeQuery = true)
		List<Activite> findActivityByDate(LocalDate date, String etab);
		
		// Utilisation d'un Query natif pour avoir les informations d'une activité
		@Query(value = "select * from TACTIVITE a where a.fketab=?1", nativeQuery = true)
		List<Activite> findAllByEtablissement(String etab);
	
		// Utilisation d'un Query natif pour savoir si une activité existe
		@Query(value = "select * from TACTIVITE a where a.nom=?1 and a.date=?2 and a.time=?3 and a.fketab=?4", nativeQuery = true)
		boolean existByActivity(String nom,LocalDate date, Time time, String etab);
		
}
