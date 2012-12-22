package Employee_manager_polimorfism;

import Employee_manager_polimorfism.Employee;


public class Manager extends Employee
{
	/**
	 * @param n Numele Lucratorului
	 * @param s Salariu
	 * @param year Anul agajamentului
	 * @param month Luna angajamentului
	 * @param day Ziua angajmentului
	 */
	
	private double bonus;
	
	public Manager(String n,double s, int year,int month,int day )
	{
		super(n,s,year,month,day);
		bonus = 0;
	}
	
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double b)
	{
		bonus = b;
	}
}
