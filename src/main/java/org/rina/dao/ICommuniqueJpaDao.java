package org.rina.dao;


import org.rina.model.Communique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommuniqueJpaDao extends JpaRepository<Communique, Long> {


}
