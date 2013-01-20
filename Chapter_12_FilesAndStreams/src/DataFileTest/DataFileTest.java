package DataFileTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataFileTest 
{
	public static void main(String[] args)
	{
		Employee2[] staff = new Employee2[3];
		staff[0] = new Employee2("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee2("Hary Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee2("Tony Tester", 40000, 1990, 3, 15);
		
		try
		{
			//Salvarea informatiei despre lucratori in dile employee.bkvc
			PrintWriter out = new PrintWriter(new FileWriter("employee.bkvc"));
			writeData(staff,out);
			out.close();
			
			//Schimbarea tuturor inscrierilor intrun nou masiv.
			BufferedReader in = new BufferedReader(new FileReader("employee.bkvc"));
			Employee2[] newStaff = readData(in);
			in.close();
			
			//Afisarea din noi a datelor citite despre lucratori
			for(Employee2 e:newStaff)
			{
				System.out.println(e);
			}
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}
	}
	
	/**
	 * Inscrie tate obiectele Employee in masiv si le transmite obiectului PrintWriter.
	 * @param employees Massiv de obiecte Employee
	 * @param out Obiect PrintWriter
	 */
	public static void writeData(Employee2[] employees,PrintWriter out)
		throws IOException
	{
		//Inscrierea numarului de lucratori/
		out.println(employees.length);
		
		for(Employee2 e: employees)
		{
			e.writeData(out);
		}
	}
	
	/**
	 * Citirea masivului despre lucratori din obiectul BufferedReader.
	 * @param in Obiectul BufferedReader
	 * @return Massiv de lucratori
	 */
	public static Employee2[] readData(BufferedReader in)
	throws IOException
	{
		//Gasirea lungimii masivului
		int n = Integer.parseInt(in.readLine());
		
		Employee2[] employees = new Employee2[n];
		for(int i =0; i<n ; i++)
		{
			employees[i] = new Employee2();
			employees[i].readData(in);
		}
		return employees;
	}
	
}
