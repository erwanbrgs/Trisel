package com.persistance;
import com.metier.Habitation;
import com.metier.Poubelle;
import com.metier.Usager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabitationDAO extends DAO<Habitation> {

	@Override
	public boolean create(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Habitation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Habitation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Habitation find(String id) {
		
		Habitation hab = null ;

		Usager u = null;

		Poubelle pb = null;

		String sqlHab, sqlPoubelle; 

		ResultSet rsHab, rsPoubelle;

		PoubelleDAO pbDAO = new PoubelleDAO();

		UsagerDAO uDAO = new UsagerDAO();

		// requête de sélection de l'habitation à écrire

		sqlHab = "SELECT * FROM habitation WHERE idHabitation='"+id+"';";

		try {

			// à écrire
	
			// exécution requête
	
			 rsHab = con.createStatement().executeQuery(sqlHab);
			 
			// test lecture car 0 ou 1 tuple
	
			if (rsHab.next())
	
			{
	
			// à écrire
	
			// récupération de l’objet Usager avec uDAO
	
			u = uDAO.find(rsHab.getString("idUsager"));
				
			// instanciation objet habitation
	
			hab = new Habitation(id,rsHab.getString("adresseRue"),
					rsHab.getString("adresseVille"),rsHab.getString("codePostal"),u);
			
			// requête de recherche des idPoubelle de l'habitation 
	
			sqlPoubelle = "SELECT idPoubelle FROM poubelle WHERE idHabitation='"+id+"';";
	
			// exécution requête de recherche des poubelles
	
			rsPoubelle = con.createStatement().executeQuery(sqlPoubelle);
			
			// parcours des poubelles, requête ramène 0 ou n tuples
	
				while (rsPoubelle.next()) {
					
					pb = pbDAO.find(rsPoubelle.getString("idPoubelle"));
					
					hab.ajoutPoubelle(pb);
		
				}
	
			}
		}

		catch (SQLException e) { 

		}

		return hab;
	}

	@Override
	public ArrayList<Habitation> retrieve() {
		
		// Appel à la méthode find qui ramène un objet habitation à rajouter à la 
		
		// déclaration et instanciation collection 
		ArrayList<Habitation> listeHab = new ArrayList<Habitation>();
		
		// déclaration jeu d’enregistrement

		ResultSet rsHab = null;

		// requête de sélection des idhabitation

		String sql = "select idHabitation from habitation";

		try {

		rsHab = con.createStatement().executeQuery(sql);

		while (rsHab.next())

		{
			listeHab.add(this.find(rsHab.getString("idHabitation")));
		}

		}

		catch (SQLException e) { 

		}

		// on retourne la collection de travail

		return listeHab;
	}

}
