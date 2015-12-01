package com.persistance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.metier.Facture;

public class FactureDAO extends DAO<Facture> {

	@Override
	public boolean create(Facture obj) {
		// TODO Auto-generated method stub
		boolean res = false;
		
		try{
			
			//Vérification de la non existence
			Statement requeteSelect = con.createStatement();
			
			String sqlSelect ="SELECT idFacture from facture "
					+ "where moisFacture="+obj.getMoisFacture()+" and anFacture="+obj.getAnFacture()+ 
					" and idHabitation="+ obj.getIdHabitation()+";";
			
			ResultSet enr = requeteSelect.executeQuery(sqlSelect);
			
			if(enr != null){
				
				// création d'un objet statement 
				Statement requeteInsert = con.createStatement();
				
				// texte de la requête
				String sqlInsert = " INSERT INTO facture (moisFacture,anFacture,nomFacture,idHabitation) VALUES("+
				obj.getMoisFacture() +","+ obj.getAnFacture() +","+ obj.getNomFacture() 
						+","+ obj.getIdHabitation() +");";
				
				// exécution de la requête, résultat dans un jeu d'enregistrement de type resulset
				requeteInsert.executeUpdate(sqlInsert);
				
				res = true;
				
			}
			
		}
		
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		
		return res;
	}

	@Override
	public boolean delete(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Facture obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Facture find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Facture> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
