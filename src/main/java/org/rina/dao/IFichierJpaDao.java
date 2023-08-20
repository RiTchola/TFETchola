package org.rina.dao;


import org.rina.model.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFichierJpaDao extends JpaRepository<Fichier, Long> {


}


