package com.test2;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleTest {
private	TypeDechet td;
private	TypeDechet td2;
private	Poubelle pb1;
private	Poubelle pb2;
private Date d1 = null;
private Date d2 = null ;
private Levee le1 = null;
private Levee le2 = null;
private Levee le3 = null;
private Levee le4 = null;
private SimpleDateFormat dateFormat;
private ArrayList<Levee> listeLeveeP1;
private ArrayList<Levee> listeLeveeP2;
@Before
public void setUp() throws Exception {
	// instanciation d'un type déchet nécessaire dans l'objet Poubelle
	td = new TypeDechet("ver", "verre", 0.1156);
	td2 = new TypeDechet("pla", "plastique", 0.251);
	// instanciation Poubelle avec les deux constructeurs
	pb1 = new Poubelle("pb1", td);
	pb2 = new Poubelle("pb2", td2, "hab2");
	// instanciation dates de levées au format français
	dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
	try
	{
		d1 = dateFormat.parse("15/05/2015");
		d2 = dateFormat.parse("30/05/2015");
		// instanciation 2 levées par poubelle
		le1 = new Levee(d1, 5.0, pb1.getIdPoubelle());
		le2 = new Levee(d2, 10.0, pb1.getIdPoubelle());
		le3 = new Levee(d1, 12.0, pb2.getIdPoubelle());
		le4 = new Levee(d2, 30.0, pb2.getIdPoubelle());
		// pour affectation des levées par liste
		// et non pas par la méthode ajout
		listeLeveeP1 = new ArrayList<Levee>();
		listeLeveeP2 = new ArrayList<Levee>();
		listeLeveeP1.add(le1);
		listeLeveeP1.add(le2);
		listeLeveeP2.add(le3);
		listeLeveeP2.add(le4);
	} catch (ParseException e){
		e.printStackTrace();
	} 
}
	@Test
	public void testPoubelle() {
		// on vérifie le fonctionnement des deux constructeurs
		assertNotNull(pb1);
		assertNotNull(pb2);
	}

	@Test
	public void testGetIdPoubelle() {
		// on teste le vrai et le faux sur les 2 poubelles
		assertEquals(pb1.getIdPoubelle(), "pb1");
		assertNotEquals(pb1.getIdPoubelle(), "test");
		assertEquals(pb2.getIdPoubelle(), "pb2");
		assertNotEquals(pb2.getIdPoubelle(), "test");
	}

	@Test
	public void testGetNature() {
		assertEquals(pb1.getNature(), td);
		assertEquals(pb2.getNature(), td2);
		assertNotNull(pb1.getNature());
		assertNotNull(pb2.getNature());
	}
	@Test
	public void testGetIdHabitation() {
		assertEquals(pb1.getIdHabitation(), "");
		assertEquals(pb2.getIdHabitation(), "hab2");
	}
	
	@Test
	public void testSetIdHabitation() {
		pb1.setIdHabitation("hab1");
		assertEquals(pb1.getIdHabitation(), "hab1");
	
	}
	@Test
	public void testGetLesLevees() {
		// test pour savoir si la collection a été instanciée dans les 2 constructeurs, vide pour l'instant
		assertEquals(pb1.getLesLevees().size(), 0);
		assertEquals(pb2.getLesLevees().size(), 0);
		// affectation de la collection de levée
		pb2.setLesLevees(listeLeveeP2);
		assertEquals(pb2.getLesLevees(), listeLeveeP2);
		assertEquals(pb2.getLesLevees().size(), 2);
		assertEquals(pb2.getLesLevees().get(0), le3);
		assertEquals(pb2.getLesLevees().get(1), le4);
		
	}
	@Test
	public void testAjoutLevee() {
		// ajout 1 levée pour chaque poubelle
		pb1.ajoutLevee(le1);
		pb2.ajoutLevee(le3);
		// test qu'il y a bien un élément ajouté
		assertEquals(pb1.getLesLevees().size(), 1);
		assertEquals(pb2.getLesLevees().size(), 1);
		// test sur les éléments ajoutés
		assertEquals(pb1.getLesLevees().get(0),le1);
		assertNotEquals(pb1.getLesLevees().get(0),null);
		assertEquals(pb2.getLesLevees().get(0),le3);
		assertNotEquals(pb2.getLesLevees().get(0),null);
	}

	
	@Test
	public void testSetLesLevees() {
		pb1.setLesLevees(listeLeveeP1);
		assertEquals(pb1.getLesLevees().size(), 2);
		assertEquals(pb1.getLesLevees().get(0), le1);
		assertEquals(pb1.getLesLevees().get(1), le2);
		assertEquals(pb1.getLesLevees(), listeLeveeP1);
	}
	
	@Test
	public void testGetCout() {
		
		pb1.setLesLevees(listeLeveeP1);
		//System.out.println(pb1.getCout(2015,05));
		assertTrue(pb1.getCout(2015,05) == 1.73);
		assertFalse(pb1.getCout(2015,06) == 1.73);
	}
}
