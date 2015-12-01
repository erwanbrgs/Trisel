package com.util;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.metier.Levee;
import com.persistance.LeveeDAO;

/**
 * 
 * @author bourgeois-e
 *
 */
public class InsertionLevee {

	/**
	 * Permet d'afficher les informations d'une levee contenues dans un fichier txt
	 * @param cheminlevee
	 * @return
	 * Ramène un entier en cas de lecture impossible
	 */
	private static int traitementFichierTexte(String cheminlevee)
	{
		//affiche la date de la lev�e
		//pour chaque lev�e du fichier
		//Affiche le code de la poubelle et la quantit�
		/**
		 *@see FichierTexte
		 */
		FichierTexte levee = new FichierTexte();
		String ligne ;
		int res = 1;
		
		
		if(levee.openFileReader(cheminlevee))
		{
			//Date en première ligne
			String date = levee.readLigne();
			Date dateParse = null;
			SimpleDateFormat dateFormat = null;
			
			dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
			
			try
			{
					
				dateParse = dateFormat.parse(date);
	
				//System.out.println(ligne);
				LeveeDAO leveeDAO = new LeveeDAO();
				
				while( (ligne=levee.readLigne()) != null )
				{
					String[] data = ligne.split(":");
					//data[0]=>code habitation
					//data[1]=>poubelle
					//data[2]=>poids
					
					Double poids = Double.parseDouble(data[2]);
							
					//System.out.println("codeHabitation : " + data[0] + " Poubelle : " + data[1] + " Poids : " + data[2]);
					Levee l = new Levee(dateParse,poids,data[1]);
					
					if(!leveeDAO.create(l))
					{
						res = 4;
					}
					else
					{
						System.out.println("Insertion effectuée.");
						res= 0;
					}
					
				}
				
				levee.closeFileReader();
			
			}
			
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			
		}
		
		return res;
		
		//on disposera ensuite des donn�es en vue de l'insertion dans la base
	}
	
	
	/**
	 * Permet d'afficher les informations d'une levee contenues dans un fichier xml
	 * @param cheminlevee
	 * @return
	 * Ramène un entier en cas de lecture impossible
	 */
	private static int traitementFichierXml(String cheminlevee)
	{
		//affiche la date de la lev�e
		//pour chaque lev�e du fichier
		//Affiche le code de la poubelle et la quantit�
		
		//*** Ouverture du fichier xml et chargement dans un objet doc xml ***//
		//D�claration document XML
		Document document = null;
		//d�claration �l�ment racine;
		Element racine = null;
		//On cr�e une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		int res = 1;
		
		try{
			
			//On cr�e un nouveau document JDOM avec en argument le fichier XML
			document = sxb.build(new File(cheminlevee));
			
			//On initialise un nouvel �l�ment racine avec l'�l�ment racine du document
			racine = document.getRootElement();
			
			//On r�cup�re la date
			String date = racine.getChildText("Date");
			
			Date dateParse = null;
			SimpleDateFormat dateFormat = null;
			
			dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
			
			try
			{
				dateParse = dateFormat.parse(date);
				
				//On cr�e une List contenant tous les noeuds "Levee"
				List<Element> listLevee = racine.getChildren("Levee");
				
				LeveeDAO leveeDAO = new LeveeDAO();
				
				//System.out.println();
				//System.out.println("Lev�e du : " + date);
				
				//parcours
				for(Element e: listLevee)
				{
					//System.out.println(" Poubelle : " + e.getChildText("poubelle") + " Poids : " + e.getChildText("poids"));
					
					Double poids = Double.parseDouble( e.getChildText("poids"));
					
					Levee l = new Levee(dateParse,poids, e.getChildText("poubelle"));
					
					if(!leveeDAO.create(l))
					{
						res = 4;
					}
					else{
						System.out.println("Insertion effectuée.");
						res= 0;
					}
				}
			}
			
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			
			
			
		}
			
		catch (JDOMException e2)
		{
			e2.printStackTrace();
			res=2;
			
		} catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		 
		return res;
		
		
	}
	
	/**
	 * Permet le transfert des fichiers dans les dossiers correspondants
	 * L'extension du fichier détermine le dossier de destination
	 * @return
	 * Ramène un entier pour le traitement des erreurs
	 */
	public static int traitementLevee()
	{
		/**
		 * @see Parametre
		 */
		Parametre p = new Parametre();

		//On r�cup�re les chemins des dossiers
		String cheminATraiter = p.getCheminATraiter();
		String cheminTraite = p.getCheminTraite();
		String cheminLog = p.getCheminLog();
		int res =0;

		System.out.println(p.getCheminATraiter());

		//Instancier le dossier
		File dossierATraiter = new File(cheminATraiter);
		File[] fichiers = dossierATraiter.listFiles();

		//Si le dossier est vide
		if( fichiers.length == 0 )
		{
			System.out.println("Dossier vide ... ");
		}

		//Si le dossier contient des fichiers 
		else{

			//On parcourt les fichiers
			for(File fichier : fichiers)
			{
				if(fichier.isFile())
				{


					String extension=p.getExtension(fichier.getName());
					System.out.println(extension);
					switch(extension){

					case "txt" : 

						//Affichage du contenu
						int i = traitementFichierTexte(fichier.getAbsolutePath());

						if(i==0)
						{

							//Instanciation d'un fichier de destination pour le transfert
							File fichierTxtDestination = new File(cheminTraite +  "\\" + fichier.getName());

							//Transfert du fichier
							i = p.transfertFichier(fichier,fichierTxtDestination);

						}

						res=i;

						break;

					case "xml" : 

						//Affichage du contenu
						int j = traitementFichierXml(fichier.getAbsolutePath());

						if(j==0)
						{

							//Instanciation d'un fichier de destination pour le transfert
							File fichierXmlDestination = new File(cheminTraite +  "\\" +  fichier.getName());

							//Transfert du fichier
							j = p.transfertFichier(fichier,fichierXmlDestination);

						}

						res=j;

						break;

					default :

						int k ;

						//Instanciation d'un fichier de destination pour le transfert
						File fichierAutreDestination = new File(cheminLog +  "\\" + fichier.getName());

						//Transfert du fichier
						k = p.transfertFichier(fichier,fichierAutreDestination);

						res=k;

						break;


					}
				}

			}
			
		}

		return res;
	}
	
	
}
