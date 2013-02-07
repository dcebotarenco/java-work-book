package TestDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Aceasta programa controleza daca e corect setata baza de date
 * @author Dan
 *
 */
public class TestDB 
{
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		try
		{
			runTest();
		}
		catch(SQLException e)
		{
			while(e != null)
			{
				e.printStackTrace();
				e = e.getNextException();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Testarea , includerea unuei tabele , adaugarea unei valori, afisarea continutului tabelei si stergerea
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void runTest()
	throws SQLException,IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Connection conn = getConnection();
		try
		{
			java.sql.Statement stat = conn.createStatement();
			stat.execute("CREATE TABLE Greetings (" +
					"id INT NOT NULL AUTO_INCREMENT," +
					"PRIMARY KEY (id)," +
					"Nume VARCHAR(50)," +
					"Prenume VARCHAR(50)" +
					");");
			stat.execute("INSERT INTO Greetings (Nume,Prenume) VALUES ('Dan','Cebotarenco')");
			stat.execute("INSERT INTO Greetings (Nume,Prenume) VALUES ('Dan','Motreac')");
			stat.execute("INSERT INTO Greetings (Nume,Prenume) VALUES ('Nicolae','Tasca')");
			ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
		
			result.next();
			System.out.print(result.getInt(1) + " " + result.getString(2) + " " + result.getString(3));
			
			
			//stat.execute("DROP TABLE Greetings");
		}
		finally
		{
			conn.close();
		}
	}
	
	/**
	 * Settarea conectiunii cu baza de date
	 * @return conectiunea
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Connection getConnection()
	throws SQLException,IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		String url = "jdbc:mysql://localhost:3306/";
		String password = "qwerty";
		String user = "root";
		return DriverManager.getConnection(url+"test", user, password);
	}
}
