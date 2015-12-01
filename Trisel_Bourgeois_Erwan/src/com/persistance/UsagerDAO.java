package com.persistance;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.metier.Levee;
import com.metier.Usager;

public class UsagerDAO extends DAO<Usager> {

	@Override
	public boolean create(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Usager obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usager find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usager find(String id) {
		
		Usager unUsager = null;

		String sql = "SELECT * FROM usager WHERE idUsager='"+id+"';";

		ResultSet rsUsager = null;

		 // texte de la requête à faire

		try {

			 // execution de la requête
	
			 rsUsager = con.createStatement().executeQuery(sql);
	
			 // requête qui ramène 0 ou 1 tuple
	
			 // test du résultat
	
			if (rsUsager.next())
	
			 // instanciation objet unUsager à faire 
	
			{
				unUsager = new Usager(id,rsUsager.getString("nom"),rsUsager.getString("prenom"),
						rsUsager.getString("adrRueUsager"),rsUsager.getString("adrVilleUsager"),rsUsager.getString("cpUsager"));
			}

		}

		catch (SQLException e) { 

		}
		
		return unUsager;
	}

	@Override
	public ArrayList<Usager> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
