package com.metier;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * @author bourgeois-e
 *
 */
public class Habitation {

	
	private String idHabitation;
	private String adresseRue;
	private String adresseVille;
	private String cp;
	
	/**
	 * @see Usager
	 */
	private Usager usager;
	
	/**
	 * @see Poubelle
	 */
	private ArrayList<Poubelle> lesPoubelles;
	
	//Constructeur
	/**
	 	 * Permet d'instancier un objet Habitation
	 	 * 
		 * @param unIdHabitation
		 * @param uneAdresseRue
		 * @param uneAdresseVille
		 * @param unCp
		 * @param unUsager
	
	 */
	public Habitation(String unIdHabitation, String uneAdresseRue, String uneAdresseVille, String unCp, Usager unUsager) {
		
		super();
		this.idHabitation = unIdHabitation;
		this.adresseRue = uneAdresseRue;
		this.adresseVille = uneAdresseVille;
		this.cp = unCp;
		this.usager = unUsager;
		this.lesPoubelles = new ArrayList<Poubelle>();
		
	}

	
	
	//Getters and Setters
	
	
	/**
	 * Permet de retourner l'id de l'habitation
	 * 
	 * @return
	 */
	public String getIdHabitation() {
		return idHabitation;
	}

	
	/**
	 * Permet de modifier l'id de l'habitation
	 * @param idHabitation
	 */
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	
	/**
	 * Permet de retourner l'adresse de la rue
	 * @return
	 */
	public String getAdresseRue() {
		return adresseRue;
	}
	
	/**
	 * Permet de modifier l'adresse de la rue
	 * @param adresseRue
	 */
	public void setAdresseRue(String adresseRue) {
		this.adresseRue = adresseRue;
	}

	/**
	 * Permet de retourner l'adresse de la ville
	 * @return
	 */
	public String getAdresseVille() {
		return adresseVille;
	}

	
	/**
	 * Permet de modifier l'adresse de la ville
	 * @param adresseVille
	 */
	public void setAdresseVille(String adresseVille) {
		this.adresseVille = adresseVille;
	}

	
	/**
	 * Permet de retourner le code postal
	 * @return
	 */
	public String getCp() {
		return cp;
	}

	
	/**
	 * Permet de modifier le code postal
	 * @param cp
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	
	/**
	 * Permet de retourner un objet Usager
	 * @return
	 */
	public Usager getUsager() {
		return usager;
	}

	
	/**
	 * Permet de modifier l'objet Usager
	 * @param usager
	 */
	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	
	/**
	 * Permet de retourner la liste de poubelles
	 * @return
	 */
	public ArrayList<Poubelle> getLesPoubelles() {
		return lesPoubelles;
	}

	
	/**
	 * Permet de modifier de la liste de Poubelles
	 * @param lesPoubelles
	 */
	public void setLesPoubelles(ArrayList<Poubelle> lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}


	//ToString
	
	/**
	 * Permet de mettre en forme les infos de l'habitation en vue d'un affichage
	 */
	@Override
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adresseRue=" + adresseRue + ", adresseVille="
				+ adresseVille + ", cp=" + cp + ", usager=" + usager + ", lesPoubelles=" + lesPoubelles + "]";
	}
	

	//Méthodes
	
	/**
	 * Permet d'ajouter une poubelle à l'ArrayList de poubelles
	 * @param unePoubelle
	 */
	public void ajoutPoubelle(Poubelle unePoubelle)
	{
		lesPoubelles.add(unePoubelle);
	}
		
	
	/**
	 * Permet de récupérer le coût d'une habitation 
	 * en fonction d'une année et d'un mois
	 * 
	 * @param an
	 * @param mois
	 * @return
	 */
	public double getCout(int an, int mois){
		
		ArrayList<Poubelle> lesPoubelles = this.getLesPoubelles();
		double cout = 0;
		
			for(Poubelle p : lesPoubelles)
			{
				
				cout = cout + p.getCout(an, mois);
				
				
			}
			
			return cout;
		
	}
	
	
		
	}
