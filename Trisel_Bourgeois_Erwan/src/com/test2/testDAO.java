package com.test2;

import java.util.ArrayList;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.persistance.HabitationDAO;
import com.persistance.LeveeDAO;
import com.persistance.PoubelleDAO;
import com.persistance.TypeDechetDAO;
import com.persistance.UsagerDAO;

public class testDAO {

	public void test() {
		// TODO Auto-generated method stub


		LeveeDAO lDAO =new LeveeDAO();
		Levee levee = lDAO.find(1);
		
		if(levee!=null)
		{
			System.out.println("levee1 : "+levee.getIdLevee()+" "+levee.getDate());
			
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		levee = lDAO.find(100);
		
		if(levee!=null)
		{
			System.out.println("levee100 : "+levee.getIdLevee()+" "+levee.getDate());
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		//******************************************************/
		
		TypeDechetDAO tDAO =new TypeDechetDAO();
		TypeDechet type = tDAO.find("pla");
		
		if(type!=null)
		{
			System.out.println("typeDechet : "+type.getCode()+" "+type.getLibelle());
			
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		type = tDAO.find("pap");
		
		if(type!=null)
		{
			System.out.println("typeDechet : "+type.getCode()+" "+type.getLibelle());
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		
		//******************************************************/
		
		PoubelleDAO pDAO =new PoubelleDAO();
		Poubelle poubelle = pDAO.find("pb1");
		
		if(poubelle!=null)
		{
			System.out.println("poubelle : "+poubelle.getIdPoubelle()+" "+poubelle.getNature());
			
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		poubelle = pDAO.find("pb5");
		
		if(poubelle!=null)
		{
			System.out.println("poubelle : "+poubelle.getIdPoubelle()+" "+poubelle.getNature());
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		//*****************************************************/
		
		UsagerDAO uDAO =new UsagerDAO();
		Usager usager = uDAO.find("usag1");
		
		if(usager!=null)
		{
			System.out.println("usager : "+usager.getNomUsager()+" "+usager.getPrenomUsager());
			
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		usager = uDAO.find("usag5");
		
		if(usager!=null)
		{
			System.out.println("usager : "+usager.getNomUsager()+" "+usager.getPrenomUsager());
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		//*****************************************************/
		
		HabitationDAO hDAO =new HabitationDAO();
		Habitation hab = hDAO.find("hab1");
		
		if(hab!=null)
		{
			System.out.println("habitation : "+hab.getIdHabitation()+" "+hab.getUsager().getIdUsager()+" "+hab.getLesPoubelles().get(0).getIdPoubelle());
			
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		usager = uDAO.find("zzz");
		
		if(usager!=null)
		{
			System.out.println("habitation : "+hab.getIdHabitation()+" "+hab.getUsager().getIdUsager()+" "+hab.getLesPoubelles().get(0).getIdPoubelle());
		}
		else
		{
			System.out.println("Pas de résultat");
		}
		
		//*****************************************************/
		
		HabitationDAO hDAO2 =new HabitationDAO();
		ArrayList<Habitation> listeHab = hDAO2.retrieve();
		
		if(listeHab.isEmpty())
		{
			System.out.println("Pas de résultat");
		}
		else
		{
			for(Habitation hab2 : listeHab)
			{
				if(hab!=null)
				{
					System.out.println("habitation : "+hab2.getIdHabitation()+" "+hab2.getUsager().getIdUsager()+" "+hab2.getLesPoubelles().get(0).getIdPoubelle());
					
				}
				else
				{
					System.out.println("Pas de résultat");
				}
			}
		}
	}

}
