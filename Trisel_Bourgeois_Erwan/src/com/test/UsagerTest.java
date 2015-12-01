package com.test;
import com.metier.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.TypeDechet;

public class UsagerTest {
	
	private Usager usager = null;

	@Before
	public void setUp() throws Exception {
		
		usager= new Usager("U001","Bourgeois","Erwan","26 rue de quimper","Pluguffan","29700");
	}

	@After
	public void tearDown() throws Exception {
		
		usager = null;
	}

	@Test
	public void testUsager() {
		usager = null;
		assertNull("Instanciation de l'objet incorrect : ",usager);
	}

	@Test
	public void testGetIdUsagerTrue() {
		assertEquals("Get correct : ","U001",usager.getIdUsager());
	}

	@Test
	public void testGetIdUsagerFalse() {
		assertNotEquals("Get incorrect : ","U002",usager.getIdUsager());
	}

	@Test
	public void testSetIdUsager() {
		usager.setIdUsager("U005");
		assertEquals("Set correct : ","U005",usager.getIdUsager());
	}

	@Test
	public void testGetNomUsagerTrue() {
		assertEquals("Get correct : ","Bourgeois",usager.getNomUsager());
	}
	
	@Test
	public void testGetNomUsagerFalse() {
		assertNotEquals("Get incorrect : ","Buzit",usager.getNomUsager());
	}

	@Test
	public void testSetNomUsager() {
		usager.setNomUsager("Martins");
		assertEquals("Set correct : ","Martins",usager.getNomUsager());
	}

	@Test
	public void testGetPrenomUsagerTrue() {
		assertEquals("Get correct : ","Erwan",usager.getPrenomUsager());
	}
	
	@Test
	public void testGetPrenomUsagerFalse() {
		assertNotEquals("Get incorrect : ","Buzit",usager.getPrenomUsager());
	}

	@Test
	public void testSetPrenomUsager() {
		usager.setPrenomUsager("Marco");
		assertEquals("Set correct : ","Marco",usager.getPrenomUsager());
	}

	@Test
	public void testGetAdresseRueUsagerTrue() {
		assertEquals("Get correct : ","26 rue de quimper",usager.getAdresseRueUsager());
	}
	
	@Test
	public void testGetAdresseRueUsagerFalse() {
		assertNotEquals("Get incorrect : ","27 rue de quimper",usager.getAdresseRueUsager());
	}

	@Test
	public void testSetAdresseRueUsager() {
		usager.setAdresseRueUsager("29 rue de brest");
		assertEquals("Set correct : ","29 rue de brest",usager.getAdresseRueUsager());
	}

	@Test
	public void testGetAdresseVilleUsagerTrue() {
		assertEquals("Get correct : ","Pluguffan",usager.getAdresseVilleUsager());
	}
	
	@Test
	public void testGetAdresseVilleUsagerFalse() {
		assertNotEquals("Get incorrect : ","Quimper",usager.getAdresseVilleUsager());
	}

	@Test
	public void testSetAdresseVilleUsager() {
		usager.setAdresseVilleUsager("Brest");
		assertEquals("Set correct : ","Brest",usager.getAdresseVilleUsager());
	}

	@Test
	public void testGetCpUsagerTrue() {
		assertEquals("Get correct : ","29700",usager.getCpUsager());
	}

	@Test
	public void testGetCpUsagerFalse() {
		assertNotEquals("Get incorrect : ","29000",usager.getCpUsager());
	}
	
	@Test
	public void testSetCpUsager() {
		usager.setCpUsager("29500");
		assertEquals("Set correct : ","29500",usager.getCpUsager());
	}

	@Test
	public void testSetGetNomUserTrue() {
		usager.setNomUser("Bourgeois");
		assertEquals("Get correct : ","Bourgeois",usager.getNomUser());
	}
	
	@Test
	public void testGetNomUserFalse() {
		assertNotEquals("Get incorrect : ","Martins",usager.getNomUser());
	}

	@Test
	public void testSetGetMotDePasse() {
		usager.setMotDePasse("myerwan");
		assertEquals("Get correct : ","myerwan",usager.getMotDePasse());
	}

	@Test
	public void testGetMotDePasseFalse() {
		assertNotEquals("Get incorrect : ","mymartins",usager.getMotDePasse());
	}
	

	@Test
	public void testToString() {
	
	}

}
