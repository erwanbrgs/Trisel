package com.test;
import com.metier.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TypeDechetTest {
	private TypeDechet type = null;

	@Before
	public void setUp() throws Exception {
		
		type= new TypeDechet("D001","papiers",0.05);
	}

	@After
	public void tearDown() throws Exception {
		type = null;
	}

	@Test
	public void testTypeDechetTrue() {
		assertNotNull("Instanciation de l'objet correct : ",type);
	}
	
	@Test
	public void testTypeDechetFalse() {
		type = null;
		assertNull("Instanciation de l'objet incorrect : ",type);
	}

	@Test
	public void testGetCodeTrue() {
		assertEquals("Get correct : ","D001",type.getCode());
	}
	
	@Test
	public void testGetCodeFalse() {
		assertNotEquals("Get incorrect : ","D002",type.getCode());
	}

	@Test
	public void testSetCode() {
		type.setCode("D005");
		assertEquals("Set correct : ","D005",type.getCode());
	}

	@Test
	public void testGetLibelleTrue() {
		assertEquals("Get correct : ","papiers",type.getLibelle());
	}

	@Test
	public void testGetLibelleFalse() {
		assertNotEquals("Get incorrect : ","verre",type.getLibelle());
	}

	@Test
	public void testSetLibelle() {
		type.setLibelle("plastique");
		assertEquals("Set correct : ","plastique",type.getLibelle());
	}

	@Test
	public void testGetTarifTrue() {
		assertTrue(type.getTarif() == 0.05);
	}
	
	@Test
	public void testGetTarifFalse() {
		assertFalse(type.getTarif() == 0.07);
	}

	@Test
	public void testSetTarif() {
		type.setTarif(0.10);
		assertTrue(type.getTarif() == 0.10);
	}

	@Test
	public void testToString() {
		
		
		
	}

}
