package org.rina.dao;

import org.rina.model.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtablissementJpaDao extends JpaRepository<Etablissement, Long> {


}
