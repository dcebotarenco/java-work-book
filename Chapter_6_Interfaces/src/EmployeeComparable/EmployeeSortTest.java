package EmployeeComparable;

import java.util.Arrays;

public class EmployeeSortTest 
{
	public static void main(String[] args)
	{
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 75000);
		staff[2] = new Employee("Tony Tester", 38000);
		
		Arrays.sort(staff);
		System.out.println(staff[0].compareTo(staff[1]));
		
		//Afisarea informatiei despre toate obiectele Employee
		for(Employee e :staff)
		{
			System.out.println("name=" + e.getName() +",salary=" + e.getSalary());
		}
	}
}
