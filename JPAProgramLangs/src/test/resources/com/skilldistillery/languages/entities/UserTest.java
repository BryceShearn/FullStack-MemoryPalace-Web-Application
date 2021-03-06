package com.skilldistillery.languages.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	emf = Persistence.createEntityManagerFactory("programLangsPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	@DisplayName(" testing mapping of User table relation ")
	void test() {
		assertNotNull(user);		
		assertEquals(1 , user.getId());
		assertEquals("testUser", user.getUsername());
		assertEquals("password", user.getPassword());
		assertEquals(true , user.isActive());
		assertEquals("home", user.getMainLocation());
	}

	@Test
	@DisplayName(" Testing User to Room relationship")
	void test1() {
		assertNotNull(user);
		assertEquals("living room", user.getRooms().get(0).getName());
		assertEquals("living room holds three items", user.getRooms().get(0).getDescription());
	}
}
