package com.test2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author bourgeois-e
 *@see LeveeTest
 *@see TypeDechetTest
 *@see PoubelleTest
 *@see UsagerTest
 *@see HabitationTest
 */
@RunWith(Suite.class)
@SuiteClasses(value={   // on note la liste des classes de test � enchainer
		LeveeTest.class,
		TypeDechetTest.class,
		PoubelleTest.class,
		UsagerTest.class,
		HabitationTest.class
		})

/**
 * Permet d'éxécuter la liste des tests
 */
public class ExecuterTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main(
				"ExecuterTest");
	}}
