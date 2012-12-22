package Object_Equals_toString;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee 
{
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String n,double s,int y,int m,int d)
	{
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(y,m-1,d);
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
	
	public void raiseSalary(double byPercent)
	{
		double raise= salary * byPercent/100;
		salary += raise;
	}
	
	public boolean equals(Object otherObject)
	{
		//Control daca sunt idectice obiectele
		if(this == otherObject) return true;
		//Daca introduce obiect = NUll , return false
		if(otherObject == null) return false;
		//Daca clasele nu sunt indentice, nu sunt egale
		if(getClass() != otherObject.getClass()) return false;
		
		//Dupa controale Stim ca otherObject este un obiect Employee nenull
		Employee other = (Employee)otherObject;
		
		//Controlul de indenticitate a datelor inscrise in cimpuei
		return name.equals(other.name)&& salary == other.salary && hireDay == other.hireDay;	
	}
	
	public int hashCode()
	{
		return 7*name.hashCode()+11 * new Double(salary).hashCode() + 13 * hireDay.hashCode();
	}
	
	public String toString()
	{
		return getClass().getName() + "[name=" + name + " ,salary=" + salary + ",hireDay=" + hireDay + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
