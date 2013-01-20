package ObjectRefTest;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Employee() {}
	
	public Employee(String n,double s,int y,int m,int d)
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(y, m-1, d);
		hireday = calendar.getTime();
	}
	public String getName()
	{
		return name;
	}
	public double getSalary()
	{
		return salary;
	}
	public Date getHireday()
	{
		return hireday;
	}
	public String toString()
	{
		return getClass().getName()
				+"[name=" + name
				+",salary=" + salary
				+",hireday=" + hireday
				+"]";
	}
	public void raiseSalary(double byPercent)
	{
		double raise= salary * byPercent/100;
		salary += raise;
	}
	
	private String name;
	private double salary;
	private Date hireday;
}
