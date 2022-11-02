package MainPackage;

import java.sql.*;
import java.util.ArrayList;

public class SQLiteDemo {  //Functie ce gestioneaza O baza de date Sql
	
	public SQLiteDemo() //Constructor ce sterge datele ramase de la rularea anterioara a programului
	{
		try 
		{
		String jdbcUrl = "jdbc:sqlite:Articole.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		String clr = "DELETE FROM Articole";
		Statement statement = connection.createStatement();
		statement.executeUpdate(clr);
		}
		catch(SQLException e)
		{
			System.out.println("Oopsie");
		}
	}
																	
	public void UpdateSql(ArrayList<Haina> haine, ArrayList<Incaltaminte> incaltaminte) //Metoda ce trece prin ambele ArrayList-uri si
	{        																			//Actualizeaza baza de date
		try 
		{
		String jdbcUrl = "jdbc:sqlite:Articole.db";
		String clr = "DELETE FROM Articole";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		String row = "N";
		Statement statement = connection.createStatement();
		statement.executeUpdate(clr);
		for(int i = 0; i < haine.size() ;i++)
		{
			row =  "insert into Articole values ('"+ haine.get(i).getNume() +"', '"+haine.get(i).getCuloare()+"', "+haine.get(i).getPret()+", 0)";
			
			int rows = statement.executeUpdate(row);
		}
		for(int i = 0; i < incaltaminte.size() ;i++)
		{
			row =  "insert into Articole values ('"+ incaltaminte.get(i).getNume() +"', '"+incaltaminte.get(i).getCuloare()+"', "+incaltaminte.get(i).getPret()+", "+incaltaminte.get(i).getMarime()+")";
		
			int rows = statement.executeUpdate(row);
		}
		
		}
		catch(SQLException e)
		{
			System.out.println("Oopsie");
		}
	}
	
	
	public void PrintList()
	{                       //Metoda ce afiseaza datele curente din baza de date
		try 
		{
		String jdbcUrl = "jdbc:sqlite:Articole.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		String printer = "select rowid, * from Articole";
		
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(printer);

		System.out.println("|");
		System.out.println("|");
 		while (result.next())
		{
 			int rowId = result.getInt("rowid");
			String Articol = result.getString("Articol");
			String Culoare = result.getString("Culoare");
			int Pret =  result.getInt("Pret");
			System.out.println(rowId + " |Articol: " + Articol + " |Culoare: " + Culoare + " |Pret: " + Pret);
		}
		}
		catch(SQLException e)
		{
			System.out.println("Oopsie");
		}
	}
}
