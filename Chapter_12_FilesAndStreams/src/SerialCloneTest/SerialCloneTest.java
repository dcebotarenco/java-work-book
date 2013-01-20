package SerialCloneTest;

public class SerialCloneTest 
{
	public static void main(String[] args)
	{
		Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);
		//Clonarea
		Employee harry2 = (Employee) harry.clone();
		
		//schimbarea obiectului harry
		harry.raiseSalary(10);
		
		//Acum obiectul harry se difera de clonul sau.
		System.out.println(harry);
		System.out.println(harry2);
	}
}
