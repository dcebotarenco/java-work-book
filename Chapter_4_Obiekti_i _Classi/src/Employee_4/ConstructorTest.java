package Employee_4;

public class ConstructorTest 
{
	public static void main(String[] args)
	{
		//Completam masivul staff cu 3 obiecte Employee.
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Harry",40000);
		staff[1] = new Employee(60000);
		staff[2] = new Employee();
		
		//Afisarea informatiei despre toti lucratorii.
		
		for(Employee e: staff)
		{
			System.out.println("name=" + e.getName() + ",id=" + e.getId()+ ",salary=" + e.getSalary());
		}
	}
}
