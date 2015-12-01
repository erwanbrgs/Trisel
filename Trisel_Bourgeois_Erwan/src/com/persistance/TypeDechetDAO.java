package com.persistance;
import com.metier.TypeDechet;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author bourgeois-e
 *
 */
public class TypeDechetDAO extends DAO<TypeDechet> {

	/**
	 * Méthode d'insertion dans la base de données
	 * @param TypeDechet
	 * @see TypeDechet
	 */
	@Override
	public boolean create(TypeDechet obj) {
		// TODO Auto-generated method stub
		boolean res = false;
		
		
		try{
			
			
			// création d'un objet statement
			Statement requete = con.createStatement();
			
			// texte de la requête
			String sql = " INSERT INTO typedechet VALUES('"+ obj.getCode() +"','"+ obj.getLibelle() + "',"+ obj.getTarif()+");";
			
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

	
	/**
	 * Méthode de suppression dans la base de données
	 * @param TypeDechet
	 * @see TypeDechet
	 */
	@Override
	public boolean delete(TypeDechet obj) {
		// TODO Auto-generated method stub
		boolean res = false;
		
		
		return res;
	}

	/**
	 * Méthode de mise à jour de la base de données
	 * @param TypeDechet
	 * @see TypeDechet
	 */
	@Override
	public boolean update(TypeDechet obj) {
		// TODO Auto-generated method stub
		boolean res = false;
		
		
		return res;
	}

	@Override
	public TypeDechet find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDechet find(String id) {
		// TODO Auto-generated method stub
		TypeDechet unType = null;
		
		String sql = "SELECT * FROM typedechet WHERE idTypeDechet='"+id+"';";

		ResultSet rsType = null;

		 // texte de la requête à faire

		try {

		 // execution de la requête

		 rsType = con.createStatement().executeQuery(sql);

		 // requête qui ramène 0 ou 1 tuple

		 // test du résultat

		if (rsType.next())

		 // instanciation objet uneLevee à faire 
			

		{
			
			unType = new TypeDechet(id,rsType.getString("libelle"),rsType.getDouble("tarif"));
			
		}

		}

		catch (SQLException e) { 

		}
		
		return unType;
	}

	@Override
	public ArrayList<TypeDechet> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
