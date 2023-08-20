package org.rina.dao;


import org.rina.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActiviteJpaDao extends JpaRepository<Activite, Long> {


}
