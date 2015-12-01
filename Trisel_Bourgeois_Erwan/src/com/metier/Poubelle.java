package com.metier;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * @author bourgeois-e
 *
 */
public class Poubelle {

	private String idPoubelle;
	
	/**
	 * @see TypeDechet
	 */
	private TypeDechet nature;
	
	/**
	 * @see Levee
	 */
	private ArrayList<Levee> lesLevees;
	private String idHabitation;
	
	//Constructeurs
	
	/**
	 * Permet d'instancier un objet Poubelle
	 * @param unIdPoubelle
	 * @param uneNature
	 * @param unIdHabitation
	 */
	public Poubelle(String unIdPoubelle, TypeDechet uneNature, String unIdHabitation)
	{
		idPoubelle = unIdPoubelle;
		nature = uneNature;
		idHabitation = unIdHabitation;
		lesLevees = new ArrayList<Levee>();
		
		
	}

	/**
	 * Permet d'instancier un objet Poubelle
	 * @param unIdPoubelle
	 * @param uneNature
	 */
	public Poubelle(String unIdPoubelle, TypeDechet uneNature)
	{
		idPoubelle = unIdPoubelle;
		nature = uneNature;
		idHabitation = "";
		lesLevees = new ArrayList<Levee>();
		
	}
	
	//Getters and Setters
	
	/**
	 * Permet de récupérer l'id d'une poubelle
	 * @return
	 */
	public String getIdPoubelle() {
		return idPoubelle;
	}
	
	
	/**
	 * Permet de modifier l'id d'une poubelle
	 * @param idPoubelle
	 */
	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}

	/**
	 * Permet de récupérer le type de déchet d'une poubelle
	 * @return
	 */
	public TypeDechet getNature() {
		return nature;
	}

	/**
	 * Permet de modifier le type de déchet d'une poubelle
	 * @param nature
	 */
	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}

	/**
	 * Permet de récupérer la liste des levées d'un poubelle
	 * @return
	 */
	public ArrayList<Levee> getLesLevees() {
		return lesLevees;
	}

	/**
	 * Permet de modifier la liste des levées d'une poubelle
	 * @param lesLevees
	 */
	public void setLesLevees(ArrayList<Levee> lesLevees) {
		this.lesLevees = lesLevees;
	}

	/**
	 * Permet de récupérer l'id de l'habitation de la poubelle
	 * @return
	 */
	public String getIdHabitation() {
		return idHabitation;
	}

	
	/**
	 * Permet de modifier l'id habitation de la poubelle
	 * @param idHabitation
	 */
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	
	//ToString
	
	/**
	 * Permet de mettre en forme les infos d'une poubelle en vue d'un affichage
	 */
	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", nature=" + nature + ", lesLevees=" + lesLevees
				+ ", idHabitation=" + idHabitation + "]";
	}
	
	//M�thodes
	
	/**
	 * Permet l'ajout d'une levee pour une poubelle
	 * @param uneLevee
	 */
	public void ajoutLevee(Levee uneLevee)
	{
		lesLevees.add(uneLevee);
	}
	
	/**
	 * Permet de récupérer la liste des levées d'une poubelle suivant le mois et l'année
	 * @param an
	 * @param mois
	 * @return
	 */
	public ArrayList<Levee> getLesLevees(int an, int mois){
		
		ArrayList<Levee> listeLevees = new ArrayList<Levee>();
		Calendar cal = null;
		cal = Calendar.getInstance();
		
			for(Levee l : lesLevees)
			{
				cal.setTime(l.getDate());
				
				int year = cal.get(Calendar.YEAR);
				// extraction du mois mettre + 1 car d�marre � 0 et non pas 1
				int month = cal.get(Calendar.MONTH) + 1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				
				if((year == an) && (month == mois))
				{
					listeLevees.add(l);
					
				}
				
				
			}
			//System.out.println(listeLevees.size());
			return listeLevees;
	}
	
	/**
	 * Permet de récupérer le coût d'une poubelle suivant le mois et l'année
	 * @param an
	 * @param mois
	 * @return
	 */
	public double getCout(int an, int mois){
			
			ArrayList<Levee> lesLeveesDate = this.getLesLevees(an,mois);
			double poids = 0;
			double cout = 0;
			
			TypeDechet type = this.getNature();
			cout = type.getTarif();
			
				for(Levee l : lesLeveesDate)
				{
						poids = poids + l.getPoids();

				}

				return (double) Math.round(cout*poids*100)/100;
		}
		
		

}
