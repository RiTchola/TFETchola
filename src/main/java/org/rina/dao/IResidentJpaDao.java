package org.rina.dao;

import org.rina.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResidentJpaDao extends JpaRepository<Resident, Long> {

}
