package org.rina.dao;

import org.rina.model.PersonneContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonneContactJpaDao extends JpaRepository<PersonneContact, Long> {


}
