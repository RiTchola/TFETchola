package org.rina.dao;

import org.rina.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvenementJpaDao extends JpaRepository<Evenement, Long> {

}
