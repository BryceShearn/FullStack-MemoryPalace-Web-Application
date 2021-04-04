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

class ItemTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Item item;
	
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
		item = em.find(Item.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		item = null;
	}

	@Test
	@DisplayName(" testing mapping of Item table relation ")
	void test() {
		assertNotNull(item);
		assertEquals(1 , item.getId());
		assertEquals(1 , item.getRoom_id());
		assertEquals("coffee table" , item.getLocation());
		assertEquals("car keys" , item.getName());
		assertEquals("meaning: There are 8 primary data types in java" , item.getDescription());
		assertEquals("relative disc image locat item" , item.getPhoto());
		assertEquals(true , item.isActive());
	}
}