package org.rina.dao;

import org.rina.model.RapportQuotidien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRapportQuotidienJpaDao  extends JpaRepository<RapportQuotidien, Long>{

}
