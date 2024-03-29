package com.skilldistillery.carwash.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class VehicleTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Vehicle vehicle;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPACarWash");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		vehicle = em.find(Vehicle.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		vehicle = null;
	}

	@Test
	void test_Vehicle_entity_mapping() {
		assertNotNull(vehicle);
		assertEquals("F150", vehicle.getModel());
	}

	//Vehicle to User mapping
	@Test
	void test_Vehicle_to_User_mapping() {
		assertNotNull(vehicle);
		assertEquals("John", vehicle.getUser().getFirstName());
		assertEquals("Doe", vehicle.getUser().getLastName());
	}

	@Test
	void test_Vehicle_to_Wash_mapping() {
		assertNotNull(vehicle);
		assertTrue(vehicle.getWashes().size() > 0);
	}
	
	

}
