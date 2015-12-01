package com.persistance;


import java.sql.*;

//classe permettant l'ouverture, la fermeture de la base //mysql bd_trisel sur localhost 
public class AccesBd {
	
	// description des propriétés
	private  static Connection con=null;
	private static String url;
	
	public static Connection  getInstance() {
		
	// accès direct sans source de données odbc
	url="jdbc:mysql://localhost/bourgeois-e_trisel";
	if (con==null)
	{
		try
		{// chargement du driver, librairie mysql connector liée au projet
			Class.forName("com.mysql.jdbc.Driver");
			// connexion utilisateur root, pas de mdp
			con=DriverManager.getConnection(url,"root","root");
		}
		// ouverture de la connexion
		catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.out.println("échec driver");
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			System.out.println("échec de connexion bd ");
		}
	}

	return con;
}
	
//	 fermeture de la connexion
public static void close(){
	try { 
		con.close();
	}
	catch(Exception e) {e.printStackTrace();
	System.out.println("problème lors de la fermeture");}
}
}

