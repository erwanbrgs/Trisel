package com.test;
import com.metier.*;
import java.util.Date;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PoubelleTest {
	
	private TypeDechet type = null;;
	private TypeDechet type2 = null;
	
	private Poubelle poubelle = null;	
	private Poubelle poubelle2 = null;	
	private Poubelle poubelle3 = null;	
	
	private Levee levee=null;
	private Levee levee2=null;
	private Levee levee3=null;
	
	private ArrayList<Levee> lesLevees = null;
	private ArrayList<Levee> lesLevees2 = null;
	private ArrayList<Levee> lesLevees3 = null;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date d1 = null;

	
	@Before
	public void setUp() throws Exception {
		
		//Instanciation des typedechets
		type = new TypeDechet("D001","verre",0.05);
		type2 = new TypeDechet("D002","plastique",0.03);
		
		//Instanciation des levees
		d1 = dateFormat.parse("15/05/2015");
		
		levee = new Levee(d1,10.5,"P001");
		levee2 = new Levee(1,d1,10.5,"P002");
		levee3 = new Levee(2,d1,11.2,"P003");
		
		lesLevees = new ArrayList<Levee>();
		lesLevees2 = new ArrayList<Levee>();
		lesLevees3 = new ArrayList<Levee>();
		lesLevees.add(levee);
		lesLevees.add(levee2);
		lesLevees3.add(levee);
		lesLevees3.add(levee2);
		lesLevees3.add(levee3);
		
		//Instanciation des poubelles
		poubelle = new Poubelle("P001",type,"H001");
		poubelle2 = new Poubelle("P002",type2);
		poubelle3 = new Poubelle("P003",type2);
				
		//Ajout des listes de levees aux poubelles
		poubelle.setLesLevees(lesLevees);
		poubelle2.setLesLevees(lesLevees);
		poubelle3.setLesLevees(lesLevees2);
		
	}

	@After
	public void tearDown() throws Exception {
		poubelle = null;
		poubelle2 = null;
	}

	@Test
	public void testPoubelleStringTypeDechetString() {
		assertNotNull("Instanciation de l'objet correct : ",poubelle);
	}

	@Test
	public void testPoubelleStringTypeDechet() {
		assertNotNull("Instanciation de l'objet correct : ",poubelle2);
	}

	@Test
	public void testGetIdPoubelle1True() {
		assertEquals("Get correct : ","P001",poubelle.getIdPoubelle());
	}
	
	@Test
	public void testGetIdPoubelle1False() {
		assertNotEquals("Get incorrect : ","P005",poubelle.getIdPoubelle());
	}
	
	@Test
	public void testGetIdPoubelle2True() {
		assertEquals("Get correct : ","P002",poubelle2.getIdPoubelle());
	}
	
	@Test
	public void testGetIdPoubelle2False() {
		assertNotEquals("Get incorrect : ","P005",poubelle2.getIdPoubelle());
	}

	@Test
	public void testSetIdPoubelle1() {
		poubelle.setIdPoubelle("P005");
		assertEquals("Get correct : ","P005",poubelle.getIdPoubelle());
	}
	
	@Test
	public void testSetIdPoubelle2() {
		poubelle2.setIdPoubelle("P005");
		assertEquals("Get correct : ","P005",poubelle2.getIdPoubelle());
	}

	@Test
	public void testGetNature1True() {
		assertEquals("Get correct : ",type,poubelle.getNature());
	}
	
	@Test
	public void testGetNature1False() {
		assertNotEquals("Get incorrect : ",type2,poubelle.getNature());
	}
	
	@Test
	public void testGetNature2True() {
		assertEquals("Get correct : ",type2,poubelle2.getNature());
	}
	
	@Test
	public void testGetNature2False() {
		assertNotEquals("Get incorrect : ",type,poubelle2.getNature());
	}

	@Test
	public void testSetNature1() {
		poubelle.setNature(type2);
		assertEquals("Get correct : ",type2,poubelle.getNature());
	}
	
	@Test
	public void testSetNature2() {
		poubelle2.setNature(type);
		assertEquals("Get correct : ",type,poubelle2.getNature());
	}

	@Test
	public void testGetLesLevees1True() {
		assertEquals("Get correct : ",lesLevees,poubelle.getLesLevees());
	}
	
	@Test
	public void testGetLesLevees1False() {
		assertNotEquals("Get incorrect : ",lesLevees2,poubelle.getLesLevees());
	}
	
	@Test
	public void testGetLesLevees2True() {
		assertEquals("Get correct : ",lesLevees,poubelle2.getLesLevees());
	}
	
	@Test
	public void testGetLesLevees2False() {
		assertNotEquals("Get incorrect : ",lesLevees2,poubelle2.getLesLevees());
	}

	@Test
	public void testSetLesLevees1() {
		poubelle.ajoutLevee(levee3);
		assertNotNull(poubelle.getLesLevees());
		assertEquals("Set correct : ",lesLevees3,poubelle.getLesLevees());
	}
	
	@Test
	public void testSetLesLevees2() {
		poubelle2.ajoutLevee(levee3);
		assertTrue(lesLevees3.size() == 3);
	}

	@Test
	public void testGetIdHabitation1True() {
		assertEquals("Get correct : ","H001",poubelle.getIdHabitation());
	}

	@Test
	public void testGetIdHabitation1False() {
		assertNotEquals("Get incorrect : ","H002",poubelle.getIdHabitation());
	}
	
	@Test
	public void testSetIdHabitation() {
		poubelle.setIdHabitation("H005");
		assertEquals("Get correct : ","H005",poubelle.getIdHabitation());
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAjoutLevee() {
		poubelle2.ajoutLevee(levee3);
		assertNotNull(poubelle2.getLesLevees());
	}

}
