package Employee;
//import Employee.*;
public class EmployeeTest 
{
	public static void main(String[] args)
	{
		//Completarea masivului cu 3 Employee
		Employee[] staff = new Employee[3];
		
		staff[0]=new Employee("Carl Cracker", 45000, 1998, 11, 23);
		staff[1]=new Employee("Joe Hore",30000,1995,12,25);
		staff[2]=new Employee("Blass Groee", 80000, 1994, 12, 31);
		
		//Ridicarea Salariului cu 5 %
		for(Employee e: staff)
		{
			e.raiseSalary();
		}
		//Afisarea informatiei despre Obiectele Employee
		for(Employee e: staff)
		{
			System.out.println("Name: "+e.getName()+", Salary: "+e.getSalary()+", Hireday: "+ e.getHireDay());
		}
	}
}
