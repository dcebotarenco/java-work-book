package Employee_4;

import java.util.Random;

public class Employee 
{
	private String name = ""; //Initializarea Cimpului name
	private double salary;
	private int id;
	
	private static int nextId;
	//3 Constructori Overloaded
	public Employee(String n,double s)
	{
		name = n;
		salary = s;
	}
	
	public Employee(double s)
	{
		//Chemarea construcrotului Employee(String,double)
		this("Employee #" + nextId,s);
	}
	//Default Constructor
	public Employee()
	{
		//Cimpul name se initializeaza cu ""
		//Cimpul salary automat = 0
		//Cimpul id se da in blocul de initializare
	}
	
	public String getName()
	{
		return name;
	}
	public double getSalary()
	{
		return salary;
	}
	public int getId()
	{
		return id;
	}
	//Blocul de initializare Static
	static
	{
		Random generator = new Random();
		//Dam la nextId o cifra random de la 0 la 9999.
		nextId = generator.nextInt(10000);
	}
	//Bloc de initializare
	{
		id = nextId;
		nextId++;
	}
}
