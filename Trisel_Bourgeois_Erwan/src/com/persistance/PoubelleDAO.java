package com.persistance;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Levee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PoubelleDAO extends DAO<Poubelle> {

	@Override
	public boolean create(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Poubelle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Poubelle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Poubelle find(String id) {
		// TODO Auto-generated method stub
			Poubelle p = null;
	
			TypeDechet typeD = null;
	
			Levee lv = null;
	
			ResultSet rsPoubelle = null;
	
			ResultSet rsLevee = null;
			
	
			// instanciation objets DAO car on va faire appel au find 
	
			// pour ne pas tout faire de redondance
	
			LeveeDAO lvDAO = new LeveeDAO();
	
			TypeDechetDAO tdDAO = new TypeDechetDAO();
	
			// recherche de la poubelle concernée dans la base à écrire
			
			String sql = "SELECT * FROM poubelle WHERE idPoubelle='"+id+"';";

			 // texte de la requête à faire

			try {

				 // execution de la requête
				// test d'existence à écrire
	
				 rsPoubelle = con.createStatement().executeQuery(sql);
	
				 // requête qui ramène 0 ou 1 tuple
	
				 // test du résultat

				if (rsPoubelle.next())
					
				 // instanciation objet à faire 
					
				{
					// appel à tdDAO pour récupérer l’objet TypeDechet
					typeD = tdDAO.find(rsPoubelle.getString("idTypeDechet"));
					
					// instanciation objet poubelle
					p = new Poubelle(id,typeD,rsPoubelle.getString("idHabitation"));
					
					// requête recherche des id des levées pour la poubelle 
					String sqlLevees = "SELECT idLevee FROM levee WHERE idPoubelle='"+id+"';";
					
					// exécution de la requête
					rsLevee = con.createStatement().executeQuery(sqlLevees);

					// parcours des levées de la poubelle 0 ou n tuples
					while (rsLevee.next()) {

						// appel à la méthode find de lvDAO pour récupérer objet levee
						lv = lvDAO.find(rsLevee.getInt("idLevee"));
						
						// ajout levée à la poubelle
						p.ajoutLevee(lv);
						
						}
					
					//System.out.println("levee : "+lv.getIdPoubelle()+" "+lv.getIdLevee());
					
				}

			}

			catch (SQLException e) { 

			}
			
			return p;
	}

	@Override
	public ArrayList<Poubelle> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}

}
