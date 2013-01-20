package DataFileTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Employee2 
{
	
	Scanner in = new Scanner(System.in);
	public Employee2() {}
	public Employee2(String n,double s,int year,int month,int day)
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
	public String toString()
	{
		return getClass().getName() 
				+"[name="+name
				+",salary="+salary
				+",hireDay="+hireDay
				+"]";
				
	}
	

	/**
	 * Inscrierea informatie despre lucratori in Obiectul PrintWriter
	 * @param out Obiect PrintWriter
	 */
	public void writeData(PrintWriter out)
	throws IOException
	{
		GregorianCalendar calendar =new GregorianCalendar();
		calendar.setTime(hireDay);
		out.println(name + "|" + salary + "|" 
				+ calendar.get(Calendar.YEAR)+"|"
				+ (calendar.get(Calendar.MONTH)+1) + "|"
				+ calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * Citirea inforamtie despre lucratori din obiectul BufferedReader
	 * @param in Obiect BufferedReader
	 */
	public void readData(BufferedReader in)
	throws IOException
	{
		String s = in.readLine();
		StringTokenizer t = new StringTokenizer(s,"|");
		name = t.nextToken();
		salary =Double.parseDouble(t.nextToken());
		int y = Integer.parseInt(t.nextToken());
		int m = Integer.parseInt(t.nextToken());
		int d = Integer.parseInt(t.nextToken());
		GregorianCalendar calendar =new GregorianCalendar(y,m-1,d);
		hireDay = calendar.getTime();
	}
	private String name;
	private double salary;
	private Date hireDay;
}
