package com.vu;
import com.util.InsertionLevee;
import com.util.Parametre;
import com.util.facturePDF;
import com.metier.*;
import com.persistance.*;
import com.test2.testDAO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author bourgeois-e
 *
 */
public class Program {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//testDAO test = new testDAO();
		//test.test();
		
		facturePDF lafacture =new facturePDF();
		lafacture.testFacture("genererPDF");
		
		/*
		//Test de connexion bdd :
		Date d1 = null;
		SimpleDateFormat dateFormat = null;
		Levee le1 = null;
		
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		
		try{
		d1 = dateFormat.parse("15/05/2015");
		le1 = new Levee(d1, 5.0, "pb1");
		}
		
		catch (ParseException e1)
		{
			e1.printStackTrace();
		}
		
	
		LeveeDAO leveeDAO = new LeveeDAO();
		if(leveeDAO.create(le1))
		{
		
			System.out.println("ligne créée");
			
		} */
		
		
		
		
		/**
		 * On instancie un objet InsertionLevee en vue de g�rer les fichiers des levees
		 * @see InsertionLevee
		 */
		InsertionLevee IL = new InsertionLevee();
		
		//traitement fichier texte
		//IL.traitementFichierTexte("Z:\BTS2\SLAM4\Trisel\pesee.txt");
		
		//traitement fichier xml
		//IL.traitementFichierXml("Z:\BTS2\SLAM4\Trisel\pesee.xml");
		
		/*System.out.println(Parametre.getCheminBd());
		System.out.println(Parametre.getCheminATraiter());
		System.out.println(Parametre.getCheminLog());
		System.out.println(Parametre.getCheminTraite());
		System.out.println(Parametre.getCheminFacturePdf());*/
		
		/**
		 * Transfert des fichiers des levees vers les dossiers correspondant
		 * Le r�sultat du transfert est mis dans une variable res
		 */
		int res = IL.traitementLevee();
		
		/**
		 * Le switch va traiter les diff�rents r�sultats des transferts de fichiers
		 * @param res 
		 */
		switch(res)
		{
		
			case 0 :
			
				System.out.println("OK");
				
				break;
			
		
			case 1 :
				
				System.out.println("Erreur : ouverture du fichier");
				
				break;
				
			case 2 :
				
				System.out.println("Erreur : xml");
				
				break;
				
			case 3 :
				
				System.out.println("Erreur : transfert du fichier");
				
				break;
				
			case 4 :
				
				System.out.println("Erreur : Ajout levee bdd");
				
				break;	
		
		
		
		}
		
		
		
		
		
	}

}
