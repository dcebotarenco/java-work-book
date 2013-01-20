package ObjectFileTest;

public class Manager extends Employee
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param n Nume
	 * @param s Salariu
	 * @param year Anu
	 * @param month Luna
	 * @param day Ziua
	 */
	public Manager(String n, double s, int year,int month,int day)
	{
		super(n,s,year,month,day);
		bonus = 0;
	}
	
	public double getSalary()
	{
		double baseSalary  = super.getSalary();
		return baseSalary + bonus;
	}
	
	public void setBonus(double b)
	{
		bonus = b;
	}
	
	public String toString()
	{
		return super.toString() 
				+"[bonus=" + bonus
				+"]";
	}
	private double bonus;

}
