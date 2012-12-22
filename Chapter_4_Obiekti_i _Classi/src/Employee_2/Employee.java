package Employee_2;

public class Employee
{
	private String name;
	private double salary;
	private int id;
	private static int nextId = 1;
	
	public Employee(String n, double s)
	{
		name = n;
		salary =s;
		id = 0;
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
	
	public void setId()
	{
		id=nextId;//Setarea indentificatorului
		nextId++;
	}
	public static int getNextId()
	{
		return nextId;//returneaza cimpul static
	}
	
	public static void main(String[] args)//Testare
	{
		Employee e = new Employee("Harry", 50000);
		System.out.println(e.getName()+" "+e.getSalary());
	}
}
