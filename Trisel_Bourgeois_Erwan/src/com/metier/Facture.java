package com.metier;

import java.util.ArrayList;

public class Facture {

	private int idFacture;
	private int moisFacture;
	private int anFacture;
	private String nomFacture;
	private String idHabitation;
	
	//Constructeurs

	public Facture(int unidFacture, int unmoisFacture, int uneanLevee, String unnomFacture,String unidHabitation)
	{
		idFacture = unidFacture;
		moisFacture = unmoisFacture;
		anFacture = uneanLevee;
		nomFacture = unnomFacture ;
		idHabitation = unidHabitation;
		
	}

	public Facture(int unmoisFacture, int uneanLevee, String unnomFacture,String unidHabitation)
	{
		moisFacture = unmoisFacture;
		anFacture = uneanLevee;
		nomFacture = unnomFacture ;
		idHabitation = unidHabitation;
		
	}
	
	//Getters/Setters
	
	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public int getMoisFacture() {
		return moisFacture;
	}

	public void setMoisFacture(int moisFacture) {
		this.moisFacture = moisFacture;
	}

	public int getAnFacture() {
		return anFacture;
	}

	public void setAnFacture(int anFacture) {
		this.anFacture = anFacture;
	}

	public String getNomFacture() {
		return nomFacture;
	}

	public void setNomFacture(String nomFacture) {
		this.nomFacture = nomFacture;
	}

	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	
	
	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", moisFacture=" + moisFacture + ", anFacture=" + anFacture
				+ ", nomFacture=" + nomFacture + ", idHabitation=" + idHabitation + "]";
	}
	
}
