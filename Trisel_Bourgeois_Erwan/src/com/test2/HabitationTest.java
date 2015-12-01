package com.test2;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;

/**
 * 
 * @author bourgeois-e
 *
 */
public class HabitationTest {
	
	/**
	 * @see Habitation
	 * @see Usager
	 * @see TypeDechet
	 * @see Poubelle
	 * @see Levee
	 */
	private Habitation habIn = null;
	private Usager u = null;
	private	TypeDechet td1;
	private	TypeDechet td2;
	private	Poubelle pb1;
	private	Poubelle pb2;
	private Date d1 = null;
	private Date d2 = null ;
	private Date d3 = null;
	private Date d4 = null;
	private Levee le1=null;
	private Levee le2=null;
	private Levee le3=null;
	private Levee le4=null;
	private SimpleDateFormat dateFormat;
	
	/**
	 * Initialisation des éléments nécessaires aux tests de la classe habitation
	 */
	@Before
	public void setUp() throws Exception {
		
		// instanciation usager
		u = new Usager("u1", "Dupont", "Albert","26 rue de quimper","Pluguffan","29700");
		// instanciation habitation
		habIn = new Habitation("hab1", "63 grand-rue","Chateaulin","29150" , u);
		// instanciation 2 types de d�chets
		td1 = new TypeDechet("ver", "verre", 0.1156);
		td2 = new TypeDechet("plas", "plastique", 0.251);
		// instanciation 2 poubelles affect�es � l'habitation
		pb1 = new Poubelle("pb1", td1 , habIn.getIdHabitation());
		pb2 = new Poubelle("pb2", td2 , habIn.getIdHabitation());
		// instanciation dates de lev�e
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			d1 = dateFormat.parse("15/05/2015");
			d2 = dateFormat.parse("30/05/2015");
			d3 = dateFormat.parse("15/06/2015");
			d4 = dateFormat.parse("30/06/2015");
		} catch (ParseException e){
			e.printStackTrace();
		} 
		// instanciation 3 lev�es pour la poubelle pb1, 1 pour pb2
		// 2 en mai , 1 en juin
		le1 = new Levee(d1, 5.0, pb1.getIdPoubelle());
		le2 = new Levee(d2, 10.0, pb1.getIdPoubelle());
		le3 = new Levee(d3, 12.0, pb1.getIdPoubelle());
		le4 = new Levee(d4, 30.0, pb2.getIdPoubelle());
		// ajout des lev�es � la poubelle 
		pb1.ajoutLevee(le1);
		pb1.ajoutLevee(le2);
		pb1.ajoutLevee(le3);
		pb2.ajoutLevee(le4);
	}

	/**
	 * Test de l'objet habitation
	 * Affirmation : l'objet n'est pas null
	 */
	@Test
	public void testHabitation() {
		assertNotNull(habIn);
	}

	/**
	 * Test de la méthode getUsager de l'objet Habitation
	 * Affirmation : l'objet est égal à u
	 * Affirmation : l'objet n'est pas null
	 */
	@Test
	public void testGetUnUsager() {
		assertEquals(habIn.getUsager(), u);
		assertNotEquals(habIn.getUsager(), null);
	}

	/**
	 * Test de la méthode getIdHabitation de l'objet Habitation
	 * Affirmation : l'id est égal à "hab1"
	 * Affirmation : l'id n'est pas égal à ""
	 */
	@Test
	public void testGetIdHabitation() {
		assertEquals(habIn.getIdHabitation(), "hab1");
		assertNotEquals(habIn.getIdHabitation(), "");
	}
	
	/**
	 * Test de la méthode getLesPoubelles de l'objet Habitation
	 * Affirmation : la liste possède une poubelle
	 * Affirmation : la liste n'est pas null
	 */
	@Test
	public void testGetLesPoubelles() {
		habIn.ajoutPoubelle(pb1);
		assertEquals(habIn.getLesPoubelles().size(), 1);
		assertNotEquals(habIn.getLesPoubelles().size(), null);
	}

	
	/**
	 * Test de la méthode getAdresseRue de l'objet Habitation
	 * Affirmation : l'adresse rue est "63 grand-rue"
	 */
	@Test
	public void testGetAdresseRue() {
		assertEquals(habIn.getAdresseRue(), "63 grand-rue");
	}

	/**
	 * Test de la méthode getAdresseVille de l'objet Habitation
	 * Affirmation : l'adresse ville est "Chateaulin"
	 */
	@Test
	public void testGetAdresseVille() {
		assertEquals(habIn.getAdresseVille(), "Chateaulin");
	}

	/**
	 * Test de la méthode getCodePostal de l'objet Habitation
	 * Affirmation : le code postal est "29150"
	 */
	@Test
	public void testGetCodePostal() {
		assertEquals(habIn.getCp(), "29150");
	}
	
	/**
	 * Test de la méthode ajoutPoubelle de l'objet Habitation
	 * Affirmation : la liste de poubelle possède 2 poubelles
	 * Affirmation : la poubelle d'index 0 correspond à la poubelle pb1
	 * Affirmation : la poubelle d'index 1 correspond à la poubelle pb2
	 */
	@Test
	public void testAjoutPoubelle() {
		habIn.ajoutPoubelle(pb1);
		habIn.ajoutPoubelle(pb2);
		assertEquals(habIn.getLesPoubelles().size(), 2);
		assertEquals(habIn.getLesPoubelles().get(0), pb1);
		assertEquals(habIn.getLesPoubelles().get(1), pb2);
	}
	
	
	/**
	 * Test de la méthode getCout de l'objet Habitation
	 * Affirmation : le coût de l'habitation habIn au 05/2015 est égal à 1.73
	 * Affirmation : le coût de l'habitation habIn au 06/2015 n'est pas égal à 1.73
	 */
	@Test
	public void testGetCout() {
		habIn.ajoutPoubelle(pb1);
		System.out.println(habIn.getCout(2015,05));
		assertTrue(habIn.getCout(2015,05) == 1.73);
		assertFalse(habIn.getCout(2015,06) == 1.73);

	}
}
