package com.util;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bourgeois-e
 *
 */
public class Parametre {
	
	private static String nomFichier = "paramAppli.ini";
	private static ArrayList<String> chemins = new ArrayList<String>();

	
	/**
	 * Permet de récupérer le chemin de la base de données ligne 2
	 * @return
	 */
	public static String getCheminBd()
	{
			
		return Lire(2);
				
	}
	
	/**
	 * Permet de récupérer le chemin du dossier des levees à traiter ligne 4
	 * @return
	 */
	public static String getCheminATraiter()
	{
		
		return Lire(4);
		
	}
	
	/**
	 * Permet de récupérer le chemin du dossier des fichiers logs ligne 10
	 * @return
	 */
	public static String getCheminLog()
	{
		return Lire(10);
	}
	
	/**
	 * Permet de récupérer le chemin du dossier des levees traitées ligne 6
	 * @return
	 */
	public static String getCheminTraite()
	{
		return Lire(6);
	}
	
	/**
	 * Permet de récupérer le chemin du dossier de facturation ligne 8
	 * @return
	 */
	public static String getCheminFacturePdf()
	{
		return Lire(8);
	}
	
	/**
	 * Permet de récupérer un chemin contenu dans un fichier de chemins 
	 * Suivant un numéro de ligne
	 * @param n
	 * @return
	 * Ramène la ligne correspondante
	 */
	private static String Lire(int n)
	{
		//Instanciation d'un objet Fichier texte
		FichierTexte cheminLevee = new FichierTexte();
		String ligne = null;
		int i;
		
		//parcours du fichier pour remplir le tableau hors commentaires
		if(cheminLevee.openFileReader(nomFichier))
		{
			for(i=0;i<n;i++)
			{
				 ligne=cheminLevee.readLigne();
			}
		}
		return ligne;
	
	}
	
	/**
	 * Permet de récupérer l'extension suivant le nom d'un fichier
	 * @param nomFichier
	 * @return
	 */
	public static String getExtension(String nomFichier)
	{
		return nomFichier.split("\\.")[1];
	}
	
	
	/**
	 * Permet de transférer un fichier d'un chemin source vers un chemin destination
	 * @param source
	 * @param destination
	 * @return
	 * Ramène un entier en cas d'erreur de transfert
	 */
	public static int transfertFichier(File source, File destination)
	{
		int res = 3;
		
		//Transfert du fichier
		if(source.renameTo(destination))
		{
			res=0;
			
		}
		
		return res;
		
		
	
	}
	
/*	public static void errorProcess(int erreur)
	{
		
		switch(erreur)
		{
		
		case 1 :
			
			System.out.println("Erreur : ouverture du fichier");
			
			break;
			
		case 2 :
			
			System.out.println("Erreur : Xml");
			
			break;
		
		}
	}*/

}
