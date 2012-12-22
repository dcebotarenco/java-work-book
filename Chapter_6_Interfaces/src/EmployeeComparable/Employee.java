package EmployeeComparable;

public class Employee implements Comparable<Employee>
{
	private String name;
	private double salary;
	
	public Employee(String n,double s)
	{
		name = n;
		salary = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	/**
	 * Comparam salariu Lucratorilor
	 * @param otherObject alt obiect a clasei Employee
	 * @return numar negativ daca salariul este mai mic de cit otherObject,0 daca sunt egale, si pozitiva daqa salariul
	 * este mai mare decit otherObject
	 */
	public int compareTo(Employee other)
	{
		if(salary < other.salary) return -1;
		if(salary > other.salary) return 1;
		return 0;
	}
}
