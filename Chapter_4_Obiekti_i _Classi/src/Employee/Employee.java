package Employee;

import java.util.*;

public class Employee 
{
	
	Scanner in = new Scanner(System.in);
	public Employee(String n,double s,int year,int month,int day)
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);

		//In GregirianCalendar ianuarie = 0
		hireDay=calendar.getTime();
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	public Date getHireDay()
	{
		return hireDay;
	}
	public void raiseSalary()
	{
		double raise = in.nextDouble();
		//double raise=salary*byPercent /100;
		salary = salary +raise;
	}
	private String name;
	private double salary;
	private Date hireDay;
}
