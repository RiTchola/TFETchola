package org.rina.dao;

import java.util.List;

import org.rina.model.Cours;
import org.rina.model.Module;
import org.rina.model.Professeur;
import org.rina.model.Module.MAS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IModuleJpaDao extends JpaRepository<Module, String> {

	List<Module> findByCoursOrderByMoment(Cours geb);

	@Query(value = "select ?1||'-'||(count(*)+1)||'-A' from tmodule m where m.fkcours=?1", nativeQuery = true)
	String generateCodeModule(String code);

	@Query("from TMODULE m join m.cours where m.moment=?2 and  ?1 member of m.cours.sections ")
	List<Module> getModulesSection(String string, MAS jour);
	
	@Query("from TMODULE m where m.professeur.user.username=?1 order by m.code")
	List<Module> getModuleProfesseur(String username);
	
	List<Module> findModuleByProfesseurOrderByCode(Professeur professeur);
	
	
	
	
	
	
	
	
	
	
	
	
	
}
