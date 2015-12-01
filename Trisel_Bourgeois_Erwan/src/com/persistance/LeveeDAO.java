package com.persistance;
import com.metier.Levee;
import java.sql.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.metier.Levee;
import com.metier.TypeDechet;

/**
 * 
 * @author bourgeois-e
 *
 */
public class LeveeDAO extends DAO<Levee> {

	/**
	 * Méthode d'insertion dans la base de données
	 * @param Levee
	 * @see Levee
	 */
	@Override
	public boolean create(Levee obj) {
		// TODO Auto-generated method stub
		boolean res = false;
		
		try{
			
			// création d'un objet statement 
			Statement requete = con.createStatement();
			
			//Récupération de la date au format sql
			java.sql.Date laDateSql = new java.sql.Date(obj.getDate().getTime());
			
			// texte de la requête
			String sql = " INSERT INTO levee (idPoubelle,laDate,poids) VALUES('"+ obj.getIdPoubelle() +"','"+ laDateSql + "' ,"+ obj.getPoids()+");";
			
			// exécution de la requête, résultat dans un jeu d'enregistrement de type resulset
			requete.executeUpdate(sql);
			
			res = true;
				
			
		}
		
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		return res;
	}

	@Override
	public boolean delete(Levee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Levee obj) {
		// TODO Auto-generated method stub
				boolean res = false;
				
				return res;
	}


	@Override
	public Levee find(int id) {
		
		// TODO Auto-generated method stub
		Levee uneLevee = null;
		
		String sql = "SELECT * FROM levee WHERE idLevee="+id+";";

		ResultSet rsLevee = null;

		 // texte de la requête à faire

		try {

		 // execution de la requête

		 rsLevee = con.createStatement().executeQuery(sql);

		 // requête qui ramène 0 ou 1 tuple

		 // test du résultat

		if (rsLevee.next())

		 // instanciation objet uneLevee à faire 
			

		{
			// conversion java.sql.Date en java.util.Date
			Date dateUtil = new Date(rsLevee.getDate("laDate").getTime());
			
			uneLevee = new Levee(id,dateUtil,rsLevee.getDouble("poids"),rsLevee.getString("idPoubelle"));
			
		}

		}

		catch (SQLException e) { 

		}
		
		return uneLevee;
		
	}
	
	@Override
	public Levee find(String id) { return null;}

	@Override
	public ArrayList<Levee> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
