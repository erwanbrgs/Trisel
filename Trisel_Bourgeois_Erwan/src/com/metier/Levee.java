package com.metier;
import java.util.Date;

/**
 * 
 * @author bourgeois-e
 *
 */
public class Levee {
	
	private int idLevee;
	private Date laDate;
	private Double poids;
	private String idPoubelle;
	
	//Constructeurs
	
	/**
	 * Permet d'instancier un objet Levee
	 * @param uneDate
	 * @param unPoids
	 * @param unIdPoubelle
	 */
	public Levee(Date uneDate, Double unPoids, String unIdPoubelle)
	{
		laDate = uneDate;
		poids = unPoids;
		idPoubelle = unIdPoubelle;
		
	}
	
	/**
	 * Permet d'instancier un objet Levee
	 * @param id
	 * @param uneDate
	 * @param unPoids
	 * @param unIdPoubelle
	 */
	public Levee(int id, Date uneDate, Double unPoids, String unIdPoubelle)
	{
		idLevee = id;
		laDate = uneDate;
		poids = unPoids;
		idPoubelle = unIdPoubelle;
		
	}
	
	//Getters and Setters
	
	/**
	 * Permet de récupérer l'idLevee
	 * @return
	 */
	public int getIdLevee() {
		return idLevee;
	}

	
	/**
	 * Permet de modifier l'id de la levee
	 * @param idLevee
	 */
	public void setIdLevee(int idLevee) {
		this.idLevee = idLevee;
	}
	
	
	/**
	 * Permet de récupérer la date
	 * @return
	 */
	public Date getDate() {
		return laDate;
	}

	/**
	 * Permet de modifier la date
	 * @param laDate
	 */
	public void setDate(Date laDate) {
		this.laDate = laDate;
	}

	
	/**
	 * Permet de récupérer le poids
	 * @return
	 */
	public Double getPoids() {
		return poids;
	}

	
	/**
	 * Permet de modifier le poids
	 * @param poids
	 */
	public void setPoids(Double poids) {
		this.poids = poids;
	}

	
	/**
	 * Permet de récupérer l'idPoubelle
	 * @return
	 */
	public String getIdPoubelle() {
		return idPoubelle;
	}
	
	
	/**
	 * Permet de modifier l'idPoubelle
	 * @param idPoubelle
	 */
	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}
	
	//ToString
	
	/**
	 * Permet de mettre en forme les infos d'une levee en vue d'un affichage
	 */
	@Override
	public String toString() {
		return "Levee [idLevee=" + idLevee + ", laDate=" + laDate + ", poids=" + poids + ", idPoubelle=" + idPoubelle
				+ "]";
	}
	
	

	
	
	
}
