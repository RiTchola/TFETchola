package org.rina.dao;

import java.util.List;

import org.rina.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserJpaDao extends JpaRepository<User, String> {

	// Query pour avoir le username de l'établissement
	@Query(value = "select u.username from TUSER u where u.role=1", nativeQuery = true)
	List<String> getUsernameEtab();

}
