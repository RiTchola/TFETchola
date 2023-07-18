package org.rina.professeur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.rina.dao.IProfesseurJpaDao;
import org.rina.dao.IUserJpaDao;
import org.rina.model.Professeur;
import org.rina.model.Roles;
import org.rina.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import lombok.extern.slf4j.Slf4j;


@ActiveProfiles(value = "testU")
@Sql(scripts = { "/dataTestU.sql" }, config = @SqlConfig(encoding = "utf-8"))
@SpringBootTest
@Slf4j
public class TestDaoProfesseur {
	@Autowired
	IProfesseurJpaDao professeurDao;
	@Autowired
	IUserJpaDao userDao;

	@Transactional
	@Test
	public void testAddGetDelete() {
		// insert
		Professeur test = new Professeur("TEST", "test", "test@gmail.com",
				new User("test", "MonPwTest1", Roles.ROLE_PROF));
		Professeur testS = professeurDao.save(test);
		log.info("prof ID: "+testS.getId());
		// test get
		assertEquals(test, testS);
		// vérifie que le prof et le user existent
		assertTrue(professeurDao.existsById(test.getId()));
		assertTrue(userDao.existsById(test.getUser().getUsername()));

		// delete
		professeurDao.deleteById(test.getId());
		// Vérifie que le professeur et le user n'existe plus
		assertFalse(professeurDao.existsById(test.getId()));
		assertFalse(userDao.existsById(test.getUser().getUsername()));
	}

}
