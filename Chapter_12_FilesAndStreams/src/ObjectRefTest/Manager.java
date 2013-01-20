package ObjectRefTest;

public class Manager extends Employee
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param n Nume
	 * @param s salariu
	 * @param y anul
	 * @param m luna
	 * @param d ziua
	 */
	public Manager(String n,double s,int y,int m,int d)
	{
		super(n,s,y,m,d);
		secretary = null;
	}
	
	/**
	 * Denumira secretarului managerului
	 * @parma s Obiect , care descrie secretarul
	 */
	public void setSecretary(Employee s)
	{
		secretary = s;
	}
	public String toString()
	{
		return super.toString()
				+"[secretary=" + secretary
				+"]";
	}
	private Employee secretary;
}
