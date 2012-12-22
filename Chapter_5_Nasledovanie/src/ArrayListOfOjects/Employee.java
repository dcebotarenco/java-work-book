package ArrayListOfOjects;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee 
{
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String n,double s,int y,int m, int d)
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(y, m-1, d);
		hireDay = calendar.getTime();
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
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
