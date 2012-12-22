package Object_Equals_toString;


public class Manager extends Employee
{
	private double bonus;
	public Manager(String n,double s,int y,int m,int d)
	{
		super(n,s,y,m,d);
		bonus = 0;
	}
	
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary += bonus;
	}
	
	public void setBonus(double b)
	{
		bonus = b;
	}
	
	public boolean equals(Object otherObject)
	{
		if(!super.equals(otherObject)) return false;
		Manager other = (Manager)otherObject;
		//Metoda super.equals() controleaza, daca apartine obiectul this si other aceleiasi Clase
		return bonus == other.bonus;
	}
	
	public int hasCode()
	{
		return super.hashCode();
	}
	
	public String toString()
	{
		return super.toString() + "[bonus=" + bonus + "]";
	}
}
