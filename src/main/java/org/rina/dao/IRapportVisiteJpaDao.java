package org.rina.dao;


import org.rina.model.RapportVisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRapportVisiteJpaDao extends JpaRepository<RapportVisite, Long> {

}
