package com.test2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.metier.Usager;

public class UsagerTest {
private Usager u1 = null;
private Usager u2 = null;
	@Before
	public void setUp() throws Exception {
		u1 = new Usager("u1", "Dupont", "Laurent","26 rue de quimper","Pluguffan","29700");
		u2 = new Usager("u2", "Albert", "André","26 rue de quimper","Pluguffan","29700","user2","mdp2");
	}
	@Test
	public void testUsager() {
		assertNotNull(u1);
		assertNotNull(u2);
	}

	@Test
	public void testGetIdUsager() {
		assertEquals(u1.getIdUsager(), "u1");
		assertNotEquals(u1.getIdUsager(), "test");
		assertEquals(u2.getIdUsager(), "u2");
		assertNotEquals(u2.getIdUsager(), "test");
	}

	@Test
	public void testGetNom() {
		assertEquals(u1.getNomUsager(), "Dupont");
		assertNotEquals(u1.getNomUsager(), "test");
		assertEquals(u2.getNomUsager(), "Albert");
		assertNotEquals(u2.getNomUsager(), "test");
	}

	
	@Test
	public void testGetPrenom() {
		assertEquals(u1.getPrenomUsager(), "Laurent");
		assertNotEquals(u1.getPrenomUsager(), "test");
		assertEquals(u2.getPrenomUsager(), "André");
		assertNotEquals(u2.getPrenomUsager(), "test");
	}
	
	@Test
	public void testGetNomUser() {
		assertEquals(u1.getNomUser(), null);
		assertEquals(u2.getNomUser(), "user2");
	}
	
	@Test
	public void testGetMotDePasse() {
		assertEquals(u1.getMotDePasse(), null);
		assertEquals(u2.getMotDePasse(), "mdp2");
	}
	
	@Test
	public void testSetNomUser() {
		u1.setNomUser("user1");
		assertEquals(u1.getNomUser(), "user1");
	}
	
	@Test
	public void testSetMotDePasse() {
		u1.setMotDePasse("azrzz");
		assertEquals(u1.getMotDePasse(), "azrzz");
	}
	
}
