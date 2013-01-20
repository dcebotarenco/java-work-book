package ObjectFileTest;

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
	
	public Employee(String n , double s, int year, int month,int day)
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
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
		double raise = salary * byPercent /100;
		salary += raise;
	}
	public String toString()
	{
		return getClass().getName()
				+"[name=" + name
				+",salary" + salary
				+",hireday" + hireDay
				+"]";
	}
	private String name;
	private Double salary;
	private Date hireDay;
}
