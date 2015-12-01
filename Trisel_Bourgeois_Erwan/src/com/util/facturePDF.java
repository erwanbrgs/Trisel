package com.util;
import java.text.DateFormat;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import com.itextpdf.text.Document;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.persistance.FactureDAO;
import com.persistance.HabitationDAO;

/**
 * 
 * @author bourgeois-e
 *
 */
public class facturePDF {
	
	private static final String  tabMois[]={"","janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre" };
	
	//*Variables pour récupérer la date du jour*//
	private	Date actuelle = new Date();
	private String month = "";
			
			
	private String filenameGenerator(Habitation hab,int mois,int an)
	{
		
		// fichier sur disque à créer
		Parametre param = new Parametre();
		String dossier = param.getCheminFacturePdf();
					
		String filename = dossier +hab.getIdHabitation()+"-"+hab.getUsager().getIdUsager()+"-Facture-"+mois+"-"+an+".pdf";
		
		return filename;
	}
	
	
	
	/**
	 * 
	 * Appelle les méthodes sur les factures pour chaque habitant
	 * @param methode
	 */
	public void testFacture(String methode){
		
		HabitationDAO hDAO =new HabitationDAO();
		ArrayList<Habitation> listeHab = hDAO.retrieve();
		
		if(listeHab.isEmpty())
		{
			System.out.println("Pas de résultat");
		}
		else
		{
			for(Habitation hab : listeHab)
			{
				switch(methode){
				
				case "editionElementFacture" :
					editionElementFacture(hab);
					break;
					
				case "genererPDF" :
					genererPDF(hab,11,2015);
					break;
				
				}
				
				
			}
			
		}
	}
	
	/**
	 * Permet l'affichage dans la console des factures des habitants
	 * @param hab
	 * @see Habitation
	 */
	public boolean editionElementFacture(Habitation hab){
		
		boolean res = false;
		double totalGeneralHT = 0;
		final double tva = 0.62;
		
		Calendar cal = null;
		cal = Calendar.getInstance();
		
		Date actuelle = new Date();
		
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//String dat = dateFormat.format(actuelle);
		
		cal.setTime(actuelle);
		
		int year = cal.get(Calendar.YEAR);
		// extraction du mois mettre + 1 car d�marre � 0 et non pas 1
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		String mois=tabMois[month];
		
		System.out.println("**************");
		System.out.println("Société Trisel");
		System.out.println("**************");
		
		System.out.println("Facture du mois de "+mois);
		System.out.println("Editée le lundi "+day+" "+mois+" "+year);
		System.out.println("");
		System.out.println(hab.getUsager().getNomUsager()+" "+hab.getUsager().getPrenomUsager());
		System.out.println(hab.getAdresseRue());
		System.out.println(hab.getCp()+" "+hab.getAdresseVille());
		System.out.println("");
		System.out.println("Code usager : "+hab.getUsager().getIdUsager());
		System.out.println("Récapitulatif des pesées des poubelles au mois de : "+mois);
		
		ArrayList<Poubelle> lespoubelles = hab.getLesPoubelles();
		
		
		
			
			for(Poubelle p : lespoubelles)
			{
				
				double totalPoubelleHT = 0;
				System.out.println("");
				System.out.println("Poubelle : "+p.getIdPoubelle()+" Nature des déchets : "+p.getNature().getLibelle());
				
				ArrayList<Levee> leslevees = p.getLesLevees(year,month);
				
				if(leslevees.size()==0)
				{
					System.out.println("Pas de levees pour cette poubelle");
				}
				
				else{
					
					for(Levee l : leslevees)
					{
						System.out.println("");
						System.out.println("Date de pesée : "+l.getDate());
						System.out.println("Nombre de kg : "+l.getPoids());
						System.out.println("Prix HT au kg : "+p.getNature().getTarif());
						System.out.println("Total HT - levee "+l.getIdLevee()+" : "+(p.getNature().getTarif())*(l.getPoids()));
					}
					
					totalPoubelleHT = p.getCout(year, month);
					totalGeneralHT = totalPoubelleHT + totalPoubelleHT ;
					
					System.out.println("Total HT - poubelle "+p.getIdPoubelle()+" : "+totalPoubelleHT);
				}
			}
			
			System.out.println("------------------");
			System.out.println("Total général HT : "+totalGeneralHT);
			System.out.println("Montant TVA : "+tva);
			System.out.println("Montant Total : "+(totalGeneralHT+tva)+" "+hab.getCout(year, month));
			System.out.println("------------------");
			System.out.println("");
			

		
		
		
		return res;
	
	}

	/**
	 * Permet la création d'une facture en PDF par habitant
	 * @param hab
	 * @see Habitation
	 */
	public boolean genererPDF(Habitation hab,int mois,int an){
		

		boolean res = false;
		
		double totalGeneralHT = 0;
		final double tva = 0.62;
		
		//Récupération des infos sur la date du jour
		String filename = filenameGenerator(hab,mois,an);
		month = tabMois[an];
		
		Document document = new Document();

		try {

			// création d'une instance pour associer le document avec le 
	
			
			System.out.println(filename);
			PdfWriter.getInstance (document,
					new FileOutputStream (filename));
	
			// ouverture du document
	
			document.open();
	
			
			//***** En-tete *****//
			Image logo = Image.getInstance("logo2.png");
			document.add(logo);
			logo.setAbsolutePosition(50, 50);
			
			Paragraph entete = enteteGenerator();
			
			// On ajoute le paragraphe au document
			document.add(entete);
			
			
			
			//***** Usager *****//
			Paragraph usager = usagerGenerator(hab);
			
			// On ajoute le paragraphe au document
			document.add(usager);
			
			
			
			//***** Intro Recap *****//
			Paragraph intro = recapGenerator(hab);
			
			// On ajoute le paragraphe au document
			document.add(intro);
	
			
			
			//*****Poubelles*****//
			ArrayList<Poubelle> lespoubelles = hab.getLesPoubelles();
					
			for(Poubelle p : lespoubelles)
			{
				
				double totalPoubelleHT = 0;
				
				PdfPTable table = tableStructureGenerator(p);
				
				ArrayList<Levee> leslevees = p.getLesLevees(an,mois);
				
				if(leslevees.size()==0)
				{
					//S'il n'y a pas de levee création d'une ligne pour informer
					PdfPCell cellL3C1 = new PdfPCell (new Phrase("Pas de levées pour cette poubelle"));
					cellL3C1.setColspan (4);
					cellL3C1.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
					
					// ajout des cellules à la table
					table.addCell (cellL3C1);
				}
				
				else{
					
					for(Levee l : leslevees)
					{
						
						//Récupération de la date de la levée
						Calendar calendar = null;
						calendar = Calendar.getInstance();
						
						calendar.setTime(l.getDate());
						
						int year2 = calendar.get(Calendar.YEAR);
						//extraction du mois mettre + 1 car d�marre � 0 et non pas 1
						int month2 = calendar.get(Calendar.MONTH) + 1;
						int day2 = calendar.get(Calendar.DAY_OF_MONTH);
						
						
						// instanciation de cellules contenant des paragraphes
						PdfPCell cellL3C1 = new PdfPCell (new Phrase(day2+"/"+month2+"/"+year2));
						cellL3C1.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
						
						PdfPCell cellL3C2 = new PdfPCell(new Phrase(Double.toString(l.getPoids())));
						cellL3C2.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
						
						PdfPCell cellL3C3 = new PdfPCell(new Phrase(Double.toString(p.getNature().getTarif())));
						cellL3C3.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
						
						PdfPCell cellL3C4 = new PdfPCell(new Phrase(Double.toString((p.getNature().getTarif())*(l.getPoids()))));
						cellL3C4.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
						
						// ajout des cellules à la table
						table.addCell (cellL3C1);
						table.addCell (cellL3C2);
						table.addCell (cellL3C3);
						table.addCell (cellL3C4);
						
					}
					
					totalPoubelleHT = p.getCout(an, mois);
					
					
					//***TotalHT***//
					// instanciation de cellules contenant des paragraphes
					PdfPCell cellL4C1 = new PdfPCell (new Phrase("TotalHT"));
					cellL4C1.setColspan (3);
					cellL4C1.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
					
					PdfPCell cellL4C2 = new PdfPCell(new Phrase(Double.toString(totalPoubelleHT)));
					cellL4C2.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
					
					// ajout des cellules à la table
					table.addCell (cellL4C1);
					table.addCell (cellL4C2);
					
					
				}
				
				document.add (table);
				
			}
			

			//***Résumé Général***//
			PdfPTable tableGeneral= new PdfPTable (4); // 4 colonnes.
			tableGeneral.setSpacingBefore (50);
			
			//*Total*//
			// instanciation de cellules contenant des paragraphes
			//Appel de la méthode getCout de Habitation pour connaitres le coût pour une habitation (total des poubelles)
			totalGeneralHT = hab.getCout(an, mois); 
			
			PdfPCell cellGL1C1 = new PdfPCell (new Phrase("Total général HT"));
			cellGL1C1.setColspan (3);
			cellGL1C1.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
			
			PdfPCell cellGL1C2 = new PdfPCell(new Phrase(Double.toString(totalGeneralHT)));
			cellGL1C2.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			
			tableGeneral.addCell (cellGL1C1);
			tableGeneral.addCell (cellGL1C2);
			
			//*TVA*//
			// instanciation de cellules contenant des paragraphes
			PdfPCell cellGL2C1 = new PdfPCell (new Phrase("Montant TVA"));
			cellGL2C1.setColspan (3);
			cellGL2C1.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
			
			PdfPCell cellGL2C2 = new PdfPCell(new Phrase(Double.toString(tva)));
			cellGL2C2.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			
			tableGeneral.addCell (cellGL2C1);
			tableGeneral.addCell (cellGL2C2);
			
			//*TTC*//
			// instanciation de cellules contenant des paragraphes
			double totalTTC = (double) Math.round((totalGeneralHT + tva)*100)/100 ; 
			
			PdfPCell cellGL3C1 = new PdfPCell (new Phrase("Total TTC"));
			cellGL3C1.setColspan (3);
			cellGL3C1.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
			
			PdfPCell cellGL3C2 = new PdfPCell(new Phrase(Double.toString(totalTTC)));
			cellGL3C2.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
			
			tableGeneral.addCell (cellGL3C1);
			tableGeneral.addCell (cellGL3C2);
			
			document.add (tableGeneral);
			
	
			// fermeture du document, important pour transférer les données // au 
	
			document.close ();
	
			// affichage sous adobe 
	
			Runtime.getRuntime().exec("explorer.exe " + filename);
			System.out.println(filename);
			
			//On ajoute la facture dans la base
			Facture f = new Facture(mois, an,filename,hab.getIdHabitation());
			FactureDAO fDAO = new FactureDAO();
			
			if(fDAO.create(f))
			{
				System.out.println("facture : enregistrée");
			}
			else
			{
				System.out.println("facture : échec de l'enregistrement");
			}
			
			res = true;
			

		} catch (DocumentException e) {

		e.printStackTrace ();

		} catch (FileNotFoundException e) {

			System.out.println("fichier déjà ouvert !");
		e.printStackTrace ();

		}

		catch (IOException ex) { 

		ex.printStackTrace();

		}
		
		return res;
	}
	
	public Paragraph enteteGenerator(){
		
		// Création d'un paragraphe
		Font font = new Font (Font.FontFamily.TIMES_ROMAN, 14);
		
		Paragraph entete = new Paragraph();
		entete.setAlignment(Element.ALIGN_RIGHT);
		entete.setSpacingBefore (-130);
		
		infoDay i = new infoDay();
		day = i.getDay();
		monthDay = i.getMonthDay();
		yearDay = i.getYearDay();
	    
		// Ajout de phrases au paragraphe
		entete.add(new Phrase("Facture du mois de "+month+"\n",font));
		entete.add(new Phrase("Editée le lundi "+day+" "+monthDay+" "+yearDay ,font));
		
		return entete;
	}
	
	
	public Paragraph usagerGenerator(Habitation hab){
		
		// Création d'un paragraphe
		Paragraph usager = new Paragraph();
		usager.setAlignment(Element.ALIGN_LEFT);
		usager.setSpacingBefore (50);
		usager.setIndentationLeft (340);
		
		// Ajout de phrases au paragraphe
		usager.add(new Phrase(hab.getUsager().getNomUsager()+" "+hab.getUsager().getPrenomUsager()+"\n"));
		usager.add(new Phrase(hab.getAdresseRue()+"\n"));
		usager.add(new Phrase(hab.getCp()+" "+hab.getAdresseVille()+"\n"));
		
		return usager;
	}
	
	public Paragraph recapGenerator(Habitation hab){
		
		// Création d'un paragraphe
		Paragraph intro = new Paragraph();
		intro.setAlignment(Element.ALIGN_LEFT);
		intro.setSpacingBefore (50);
		
		// Ajout de phrases au paragraphe
		intro.add(new Phrase("Code usager : "+hab.getUsager().getIdUsager()+"\n"));
		intro.add(new Phrase("Récapitulatif des pesées des poubelles au mois de : "+month));
					
		return intro;
	}
	
	public PdfPTable tableStructureGenerator(Poubelle p){
		
		PdfPTable table= new PdfPTable (4); // 4 colonnes.
		table.setSpacingBefore (50);
		
		// instanciation de cellules contenant des paragraphes
		PdfPCell cellL1C1 = new PdfPCell (new Phrase("Poubelle : "+p.getIdPoubelle()+"  Nature des déchets : "+p.getNature().getLibelle()));
		cellL1C1.setColspan (4);
		cellL1C1.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
		
		// ajout des cellules à la table
		table.addCell (cellL1C1);
		
		// instanciation de cellules contenant des paragraphes
		PdfPCell cellL2C1 = new PdfPCell (new Phrase("Date de pesée"));
		cellL2C1.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
		
		PdfPCell cellL2C2 = new PdfPCell(new Phrase("Nombre de kg"));
		cellL2C2.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
		
		PdfPCell cellL2C3 = new PdfPCell(new Phrase("Prix HT au kg"));
		cellL2C3.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
		
		PdfPCell cellL2C4 = new PdfPCell(new Phrase("Total HT"));
		cellL2C4.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
		
		// ajout des cellules à la table
		table.addCell (cellL2C1);
		table.addCell (cellL2C2);
		table.addCell (cellL2C3);
		table.addCell (cellL2C4);
		
		return table;
		
	}
	
}

