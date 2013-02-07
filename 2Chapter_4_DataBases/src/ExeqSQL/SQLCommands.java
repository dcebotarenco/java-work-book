package ExeqSQL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLCommands 
{
	public SQLCommands(File f) throws IOException
	{
		try
		{
			Connection conn = getConnection();
			in = new Scanner(f);
			try
			{
				stat = conn.createStatement();
				
				while(true)
				{
					if(!in.hasNextLine())
					{
						return;
					}
					
					line = in.nextLine();
					if(line.equalsIgnoreCase("EXIT")) return;
					try
					{
						boolean hasResultSet = stat.execute(line);
						if(hasResultSet)
						{
							showResultSet(stat);
						}
						
					}
					catch(SQLException e)
					{
						
					}
				}
			}
			finally
			{
				conn.close();
			}
		} 
		catch (FileNotFoundException e) 
		{		
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	throws SQLException,IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		String url = "jdbc:mysql://localhost:3306/";
		String password = "qwerty";
		String user = "root";
		return DriverManager.getConnection(url+"test", user, password);
	}
	
	/**
	 * Afisarea resultaului
	 * @param Obiect Statement, resultatui caruai trebue de afisat
	 * @throws SQLException 
	 */
	public static void showResultSet(Statement stat) throws SQLException
	{
		ResultSet result = stat.getResultSet();
		java.sql.ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();
		for(int i =0; i<columnCount;i++)
		{
			if(i > 1)
			{
				System.out.print(", ");
				System.out.print(metaData.getColumnLabel(i));
			}
		}
		System.out.println();
		
		while(result.next())
		{
			for(int i = 0; i<= columnCount; i++)
			{
				if(i > 1) System.out.print(", ");
				System.out.println(result.getString(i));
			}
			result.close();
		}
		
	}
	
	public String getLine()
	{
		return line;
	}
	private static String line;
	private Scanner in ;
	private Statement stat;
}
