package Introduction;
import java.util.*;

public class CalendarTest 
{
	public static void main(String[] args)
	{
		//Crearea obiectului d, ce reprezinta data curenta
		
		GregorianCalendar d = new GregorianCalendar();
		
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		
		//Punerea obiectului d pe prima data a lunii
		d.set(Calendar.DAY_OF_MONTH, 1);
		int weekday = d.get(Calendar.DAY_OF_WEEK);
		
		//Afisarea headerului tabelei
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		
		//In afisarea primului rind din calendar e posibli miscarea lui
		for (int i = Calendar.SUNDAY; i<weekday; i++)
		{
			System.out.print("    ");
		}
		do
		{
			// Afisarea zilei din luna
			int day = d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			
			//Simbolul * semneaza ziua curenta
			if(day==today) 
			{
				System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
			//Dupa fiecare Simbata se incepe un nou rind
			if(weekday == Calendar.SATURDAY)
			{
				System.out.println();
			}
			//Schimbarea d la urmatoarea zi
			d.add(Calendar.DAY_OF_MONTH,1);
			weekday=d.get(Calendar.DAY_OF_WEEK);
		}
		while (d.get(Calendar.MONTH) == month);
		//Ciclu se inchide cind d este pus la prima zi a lunii urmatoare
		//la necesitate sa schimba linia
		if(weekday!=Calendar.SUNDAY)
		{
			System.out.println();
		}
	}
	
}
