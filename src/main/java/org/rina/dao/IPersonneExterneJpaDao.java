package org.rina.dao;

import org.rina.model.PersonneExterne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonneExterneJpaDao extends JpaRepository<PersonneExterne, Long> {

}
