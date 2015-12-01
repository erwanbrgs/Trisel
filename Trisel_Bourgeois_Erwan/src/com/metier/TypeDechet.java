package com.metier;

/**
 * 
 * @author bourgeois-e
 *
 */
public class TypeDechet {
	
	private String code;
	private String libelle;
	private Double tarif;

	//Constructeur
	
	/**
	 * Permet d'instancier un objet TypeDechet
	 * @param unCode
	 * @param unLibelle
	 * @param unTarif
	 */
	public TypeDechet(String unCode,String unLibelle, Double unTarif)
	{
		code = unCode;
		libelle = unLibelle;
		tarif = unTarif;

	}
	
	//Getters and Setters
	
	/**
	 * Permet de récupérer le code du type de déchet
	 * @return
	 */
	public String getCode() {
		return code;
	}

	
	/**
	 * Permet de modifier le code du type de déchet
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
	/**
	 * Permet de récupérer le libellé du type de déchet
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Permet de modifier le libellé du type de déchet
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	/**
	 * Permet de récupérer le tarif au kg du type de déchet
	 * @return
	 */
	public Double getTarif() {
		return tarif;
	}

	/**
	 * Permet de modifier le tarif au kg du type de déchet
	 * @param tarif
	 */
	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	
	//ToString
	
	/**
	 * Permettre de mettre en forme les infos d'un type de déchet en vue d'un affichage
	 */
	@Override
	public String toString() {
		return "TypeDechet [code=" + code + ", libelle=" + libelle + ", tarif=" + tarif + "]";
	}
	

}
