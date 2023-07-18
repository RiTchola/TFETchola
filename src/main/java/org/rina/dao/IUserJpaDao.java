package org.rina.dao;

import org.rina.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJpaDao extends JpaRepository<User, String>  {

}
