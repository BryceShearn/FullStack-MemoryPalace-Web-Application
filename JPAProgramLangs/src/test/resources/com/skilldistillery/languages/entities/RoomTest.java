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

class RoomTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Room room;
	
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
		room = em.find(Room.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		room = null;
	}

	@Test
	@DisplayName(" testing mapping of Room table relation ")
	void test() {
		assertNotNull(room);
		assertEquals(1, room.getId());
		assertEquals("living room", room.getName());
		assertEquals("living room holds three items", room.getDescription());
		assertEquals("relative disc image locat room", room.getPhoto());
		assertEquals(true, room.isActive());
	}
	
	@Test
	@DisplayName(" Testing User to Room relationship")
	void test1() {
		assertNotNull(room);
		assertEquals("meaning: There are 8 primary data types in java", room.getItems().get(0).getDescription());
		assertEquals("coffee table", room.getItems().get(0).getLocation());
	}
}
