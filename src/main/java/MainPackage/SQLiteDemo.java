package MainPackage;

import java.sql.*;
import java.util.ArrayList;

public class SQLiteDemo {
	/*
	public static void main(String[] args) throws SQLException{
		String jdbcUrl = "jdbc:sqlite:Articole.db";
		Connection connection = DriverManager.getConnection(jdbcUrl); 
		
		
		String sq1 = "select rowid, * from Articole";
		//String sq2 = "DELETE FROM Articole";
		String sq3 = "insert into Articole values ('Tricou', 'Alb', 45, 60)";
		Statement statement = connection.createStatement();
		int rows = statement.executeUpdate(sq3);
		ResultSet result = statement.executeQuery(sq1);
		//statement.executeUpdate(sq2);
 		while (result.next())
		{
 			int rowId = result.getInt("rowid");
			String Articol = result.getString("Articol");
			String Culoare = result.getString("Culoare");
			int Pret =  result.getInt("Pret");
			System.out.println(rowId + " |Articol: " + Articol + " |Culoare: " + Culoare + " |Pret: " + Pret);
		}
		*/
	
	public SQLiteDemo()
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
	
	public void UpdateSql(ArrayList<Haina> haine, ArrayList<Incaltaminte> incaltaminte)
	{
		try 
		{
		String jdbcUrl = "jdbc:sqlite:Articole.db";
		String clr = "DELETE FROM Articole";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		String row = "N";
		Statement statement = connection.createStatement();
		statement.executeUpdate(clr);
		//String sq3 = "insert into Articole values ('Tricou', 'Alb', 45, 60)";
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
	{
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
