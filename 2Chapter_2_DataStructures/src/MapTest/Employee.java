package MapTest;

/**
 * Varianta minima a clasei Employee, ce descrie lucratorul
 * Acest Class se foloseste ca exemplu
 * @author Dan
 *
 */
public class Employee 
{
	/**
	 * Constructor, ce descrie lucratorul cu salariu de 0$
	 * @param n Nume
	 */
	public Employee(String n)
	{
		name = n;
		salary = 0;
	}
	
	public String toString()
	{
		return "[name="+name+", salary=" +salary+"]";
	}
	private String name;
	private double salary;
}
