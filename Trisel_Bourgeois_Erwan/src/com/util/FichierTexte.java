package com.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author bourgeois-e
 *
 */
public class FichierTexte {
	
	// buffer de lecture
	private BufferedReader br;
	
	// buffer d'�criture
	private BufferedWriter bw;
	
	/**
	 * Permet d'instancier un objet FichierTexte
	 */
	public FichierTexte()
	{
		br=null;
		bw=null;
	}
	
	// ouverture du fichier en lecture
	/**
	 * Permet d'ouvrir le fichier en lecture
	 * @param nom
	 * @return
	 * Ramène un booléen en cas d'erreur d'ouverture
	 */
	public boolean openFileReader(String nom)
	{
		boolean open;
		FileInputStream fichier=null;
		try
		{
			fichier=new FileInputStream(new File(nom));
			br=new BufferedReader(new InputStreamReader(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	
	
	/**
	 * Permet d'ouvrir le fichier en écriture
	 * @param nom
	 * @return
	 * Ramène un booléen en cas d'erreur d'ouverture
	 */
	// ouverture du fichier en �criture
	public boolean openFileWriter(String nom)
	{ 
		boolean open;
		FileOutputStream fichier=null;
		try
		{
			fichier=new FileOutputStream(nom);
			bw=new BufferedWriter(new OutputStreamWriter(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	
	
	// fermeture du flux d'�criture
	/**
	 * Permet de fermer le flux d'écriture
	 * @return
	 */
	public boolean closeFileWriter()
	{
		boolean ok = true;
		try
		{
			bw.close();
		}
		catch (IOException e)
		{
			ok = false;
		}
		return ok;
	}
	
	
	// fermeture du flux de lecture
	/**
	 * Permet de fermer le flux de lecture
	 */
	public void closeFileReader()
	{
		try
		{
			br.close();}
		catch (IOException e)
		{
			System.out.println("pb fermeture");
		}
	}
	
	
	// �criture d'une ligne
	/**
	 * Permet d'écrire une ligne
	 * @param ligne
	 */
	public void writeLigne(String ligne)
	{
		try
		{
			bw.write(ligne+"\n");
		}
		catch (IOException e)
		{
			System.out.println("pb ecriture");
		}
	}
	
	
	// lecture d'une ligne
	/**
	 * Permet de lire une ligne
	 * @return
	 */
	public String readLigne()
	{
		String ligne=null;
		try
		{
			ligne= br.readLine();
		}
		catch (IOException e)
		{
			System.out.println("pb lecture");
		}
		return ligne;
	}
}