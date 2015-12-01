package com.test;
import com.metier.*;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LeveeTest {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date d1 = null;
	Date d2 = null;
	Date d3 = null;
	
	private Levee levee = null;
	private Levee levee2 = null;

	@Before
	public void setUp() throws Exception {

		try{
			d1 = dateFormat.parse("15/05/2015");
			d2 = dateFormat.parse("30/05/2015");
			d3 = dateFormat.parse("15/06/2015");
			
			levee = new Levee(d1,10.5,"P001");
			levee2 = new Levee(1,d2,10.5,"P001");
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		
	}

	@After
	public void tearDown() throws Exception {
		levee = null;
		levee2 = null;
	}

	@Test
	public void testLeveeDateDoubleString() {
		assertNotNull("Instanciation de l'objet correct : ",levee);
	}

	@Test
	public void testLeveeIntDate() {
		assertNotNull("Instanciation de l'objet correct : ",levee2);
	}

	@Test
	public void testGetIdLeveeTrue() {
		assertTrue(levee2.getIdLevee() == 1);
	}
	
	@Test
	public void testGetIdLeveeFalse() {
		assertFalse(levee2.getIdLevee() == 8);
	}

	@Test
	public void testSetIdLevee() {
		levee2.setIdLevee(5);
		assertTrue(levee2.getIdLevee() == 5);
	}

	@Test
	public void testGetLaDate1True() {
		assertEquals("Get correct : ",d1,levee.getDate());
	}

	@Test
	public void testGetLaDate1False() {
		assertNotEquals("Get incorrect : ",d3,levee.getDate());
	}
	
	@Test
	public void testGetLaDate2True() {
		assertEquals("Get correct : ",d2,levee2.getDate());
	}
	
	@Test
	public void testGetLaDate2False() {
		assertNotEquals("Get incorrect : ",d3,levee2.getDate());
	}
	
	@Test
	public void testSetLaDate1() {
		levee.setDate(d3);
		assertEquals("Set correct : ",d3,levee.getDate());
	}
	
	@Test
	public void testSetLaDate2() {
		levee2.setDate(d3);
		assertEquals("Set correct : ",d3,levee2.getDate());
	}

	@Test
	public void testGetPoids1True() {
		assertTrue(levee.getPoids() == 10.5);
	}
	
	@Test
	public void testGetPoids1False() {
		assertFalse(levee.getPoids() == 10.2);
	}
	
	@Test
	public void testGetPoids2True() {
		assertTrue(levee2.getPoids() == 10.5);
	}
	
	@Test
	public void testGetPoids2False() {
		assertFalse(levee2.getPoids() == 10.2);
	}

	@Test
	public void testSetPoids1() {
		levee.setPoids(7.0);
		assertTrue(levee.getPoids() == 7.0);
	}

	@Test
	public void testSetPoids2() {
		levee2.setPoids(7.0);
		assertTrue(levee2.getPoids() == 7.0);
	}

	@Test
	public void testGetIdPoubelle1True() {
		assertEquals("Get correct : ","P001",levee.getIdPoubelle());
		
	}
	
	@Test
	public void testGetIdPoubelle1False() {
		assertNotEquals("Get incorrect : ","P005",levee.getIdPoubelle());
		
	}
	
	@Test
	public void testGetIdPoubelle2True() {
		assertEquals("Get correct : ","P001",levee2.getIdPoubelle());
		
	}
	
	@Test
	public void testGetIdPoubelle2False() {
		assertNotEquals("Get incorrect : ","P005",levee2.getIdPoubelle());
		
	}

	@Test
	public void testSetIdPoubelle1() {
		levee.setIdPoubelle("P003");
		assertEquals("Get correct : ","P003",levee.getIdPoubelle());
	}

	@Test
	public void testSetIdPoubelle2() {
		levee2.setIdPoubelle("P003");
		assertEquals("Get correct : ","P003",levee2.getIdPoubelle());
	}
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
