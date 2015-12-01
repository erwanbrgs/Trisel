package com.metier;

/**
 * 
 * @author bourgeois-e
 *
 */
public class Usager {
	
	private String idUsager;
	private String nomUsager;
	private String prenomUsager;
	private String adresseRueUsager;
	private String adresseVilleUsager;
	private String cpUsager;
	private String nomUser;
	private String motDePasse;
	
	//Constructeur
	/**
	 * Permet d'instancier un objet Usager
	 * @param unIdUsager
	 * @param unNomUsager
	 * @param unPrenomUsager
	 * @param uneAdresseRue
	 * @param uneAdresseVille
	 * @param unCpUsager
	 */
	public Usager(String unIdUsager, String unNomUsager, String unPrenomUsager, String uneAdresseRue, String uneAdresseVille, String unCpUsager)
	{
		idUsager = unIdUsager;
		nomUsager = unNomUsager;
		prenomUsager = unPrenomUsager;
		adresseRueUsager = uneAdresseRue;
		adresseVilleUsager = uneAdresseVille;
		cpUsager = unCpUsager;

	}
	
	//Constructeur
	/**
	 * Permet d'instancier un objet Usager
	 * @param unIdUsager
	 * @param unNomUsager
	 * @param unPrenomUsager
	 * @param uneAdresseRue
	 * @param uneAdresseVille
	 * @param unCpUsager
	 * @param unNomUser
	 * @param unMotDePasse
	 */
	public Usager(String unIdUsager, String unNomUsager, String unPrenomUsager, String uneAdresseRue, String uneAdresseVille, String unCpUsager,String unNomUser,String unMotDePasse)
	{
		idUsager = unIdUsager;
		nomUsager = unNomUsager;
		prenomUsager = unPrenomUsager;
		adresseRueUsager = uneAdresseRue;
		adresseVilleUsager = uneAdresseVille;
		cpUsager = unCpUsager;
		nomUser = unNomUser;
	    motDePasse = unMotDePasse;
	}
	
	
	
	//Getters and Setters
	/**
	 * Permet de récupérer l'id de l'usager
	 * @return
	 */
	public String getIdUsager() {
		return idUsager;
	}

	/**
	 * Permet de modifier l'id de l'usager
	 * @param idUsager
	 */
	public void setIdUsager(String idUsager) {
		this.idUsager = idUsager;
	}

	/**
	 * Permet de récupérer le nom de l'usager
	 * @return
	 */
	public String getNomUsager() {
		return nomUsager;
	}

	/**
	 * Permet de modifier le nom de l'usager
	 * @param nomUsager
	 */
	public void setNomUsager(String nomUsager) {
		this.nomUsager = nomUsager;
	}

	/**
	 * Permet de récupérer le pr�nom de l'usager
	 * @return
	 */
	public String getPrenomUsager() {
		return prenomUsager;
	}

	/**
	 Permet de modifier le pr�nom de l'usager
	 * @param prenomUsager
	 */
	public void setPrenomUsager(String prenomUsager) {
		this.prenomUsager = prenomUsager;
	}

	/**
	 * Permet de récupérer l'adresse de rue de l'usager
	 * @return
	 */
	public String getAdresseRueUsager() {
		return adresseRueUsager;
	}

	/**
	 * Permet de modifier l'adresse de rue de l'usager 
	 * @param adresseRueUsager
	 */
	public void setAdresseRueUsager(String adresseRueUsager) {
		this.adresseRueUsager = adresseRueUsager;
	}

	/**
	 * Permet de récupérer l'adresse de ville de l'usager
	 * @return
	 */
	public String getAdresseVilleUsager() {
		return adresseVilleUsager;
	}

	/**
	 * Permet de modifier l'adressse de ville de l'usager
	 * @param adresseVilleUsager
	 */
	public void setAdresseVilleUsager(String adresseVilleUsager) {
		this.adresseVilleUsager = adresseVilleUsager;
	}

	/**
	 * Permet de récupérer le code postal d'un usager
	 * @return
	 */
	public String getCpUsager() {
		return cpUsager;
	}

	/**
	 * Permet de modifier le code postal d'un usager
	 * @param cpUsager
	 */
	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}

	/**
	 * Permet de récupérer le nom d'utilisateur d'un usager
	 * @return
	 */
	public String getNomUser() {
		return nomUser;
	}

	/**
	 * Permet de modifier le nom d'utilisateur d'un usager
	 * @param nomUser
	 */
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	/**
	 * Permet de récupérer le mot de passe d'un usager
	 * @return
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * Permet de modifier le mot de passe d'un usager
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	//ToString
	/**
	 * Permet de mettre en forme les infos d'un usager en vue d'un affichage
	 */
	@Override
	public String toString() {
		return "Usager [idUsager=" + idUsager + ", nomUsager=" + nomUsager + ", prenomUsager=" + prenomUsager
				+ ", adresseRueUsager=" + adresseRueUsager + ", adresseVilleUsager=" + adresseVilleUsager
				+ ", cpUsager=" + cpUsager + ", nomUser=" + nomUser + ", motDePasse=" + motDePasse + "]";
	}

}
