package Person_abstract_class;

public class Student extends Person
{
	/**
	 * @param n Numele Studientului
	 * @param m specialitatea Studientului
	 */
	private String major;
	
	public Student(String n,String m)
	{
		super(n);
		major = m;
	}
	
	public String getDescription()
	{
		return String.format("a student majoring in %s", major);
	}
}
