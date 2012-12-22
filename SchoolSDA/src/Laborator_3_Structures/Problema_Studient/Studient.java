package Laborator_3_Structures.Problema_Studient;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * This class impliments Object Studient with setters in modificators
 * @author Dan
 *
 */
public class Studient 
{
	/**
	 * Scanning InputStream from keyboard
	 */
	public  Scanner in = new Scanner(System.in);
	/**
	 * Object that allow to formate date as programist want , in our case it is dd/MM/yyyy.
	 */
	public 	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	private  String Nume;
	private  String Prenume;
	private  String Specialitate;
	private  String BirthDay;
	
	/**
	 * In constructor we set parameters to private fields of Class {@link #getClass()}.Also we create a Claendar 
	 * Object and set the Year,Month and Day of week.Then we format this with {@link #df} and set it to private String field BirthDay.
	 * @param Surname Surname of Student
	 * @param Name Name of Student
	 * @param Specialisation Specialisation of Student
	 * @param y Year of birthday that corespont to Student
	 * @param m Month of birthday that corespont to Student
	 * @param d Day of birthday that corespont to Student
	 */
	public Studient(String Surname,String Name,String Specialisation,int y,int m,int d)
	{
		Nume = Name;
		Prenume = Surname;
		Specialitate = Specialisation;
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, y);
		calendar.set(Calendar.MONTH, m-1);
		calendar.set(Calendar.DAY_OF_MONTH,d);
		BirthDay = df.format(calendar.getTime());
	}
	/**
	 * Getter of Name
	 * @return Name of Student
	 */
	public  String getNume()
	{
		return Nume;
	}
	/**
	 * Getter of Surname
	 * @return Surname of Student
	 */
	public String getPrenume()
	{
		return Prenume;
	}
	/**
	 * Getter of Specialisation
	 * @return Specialisation of Student
	 */
	public  String getSpecialiatea()
	{
		return Specialitate;
	}
	/**
	 * Getter of Birthday
	 * @return BirthDay of Student
	 */
	public  String getBirthDay()
	{
		return BirthDay;
	}
	/**
	 * Setter a new name of Student.New input String is assigned to private field Nume
	 */
	public void setName()
	{	
		String name = in.next();
		Nume = name;
	}
	/**
	 * Setter a new Surname of Student.New input String is assigned to private field Prenume
	 */
	public void setPrenume()
	{	
		String prenume = in.next();
		Prenume = prenume;
	}
	/**
	 * Setter a new specialisation of Student.New input String is assigned to private field Specialitate
	 */
	public void setSpec()
	{
		String spec = in.next();
		Specialitate = spec;
	}
	/**
	 * Setter a new Birthday of Student.
	 * We create new object Calendar set new Year,Month and Date.Format it with {@link #df}
	 * New input String is assigned to private field Nume
	 */
	public void setBirthDay()
	{
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_MONTH,in.nextInt());
		calendar.set(Calendar.MONTH, in.nextInt()-1);
		calendar.set(Calendar.YEAR, in.nextInt());
		System.out.println("Done..");
		BirthDay = df.format(calendar.getTime());
		
	}
}
