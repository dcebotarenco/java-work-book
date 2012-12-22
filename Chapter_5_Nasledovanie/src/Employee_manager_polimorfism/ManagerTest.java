package Employee_manager_polimorfism;



public class ManagerTest 
{
	public static void main(String[] args)
	{
		//Crearea obiectului Manager.
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		
		Employee[] staff = new Employee[3];
		//Completarea masivului staff cu obiectele Employee si Manager
		
		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
		
		//Afisarea informatie despre toate obiectele Employee
		
		for(Employee e: staff)
		{
			System.out.println("name="+e.getName()+ ", salary=" + e.getSalary());
		}
	}
}
