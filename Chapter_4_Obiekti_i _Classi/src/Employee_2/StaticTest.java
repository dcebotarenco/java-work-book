package Employee_2;
//import Employee_2.*;

public class StaticTest 
{
	public static void main(String[] args)
	{
		//Completarea masivului staff cu obiectele Employee.
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Tom",40000);
		staff[1] = new Employee("Dick",60000);
		staff[2] = new Employee("Haryy", 50000);
		
		//afisarea informatie despre obiectele Employee
		for (Employee e : staff)
		{
			e.setId();
			System.out.println("name = " + e.getName()+ ", id = "+e.getId()+", salary = "+e.getSalary());
		}
		int n = Employee.getNextId();//Chemarea cimpului static
		System.out.println("Next available id = "+ n);
	}
}
