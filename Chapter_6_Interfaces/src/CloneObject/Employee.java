package CloneObject;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable
{
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String n, double s)
	{
		name = n;
		salary = s;
	}
	
	public Employee clone() throws CloneNotSupportedException
	{
		//Chemarea Object.clone()
		Employee cloned = (Employee)super.clone();
		
		//Copierea cimpurilor schimbate
		cloned.hireDay = (Date)hireDay.clone();
		
		return cloned;
	}
	
	public void setHireDay(int year,int month , int day)
	{
		hireDay=new GregorianCalendar(year,month-1,day).getTime();
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent/100;
		salary += raise;
	}
	
	public String toString()
	{
		return "Employee[name="+name+",salary"+salary+",hireDay=" + hireDay + "]";
	}
}
