package RandomFileAccess;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RandomFileAccess
{
	public static void main(String[] args)
	{
		Employee[] staff =new Employee[3];
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Hary Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		try
		{
			//toate datele despre lucratori se salveaza in filu staff.jcc
			DataOutputStream out = new DataOutputStream(new FileOutputStream("staff.jcc"));
			for(Employee e: staff)
			{
				e.writeData(out);
			}
			out.close();
			
			//Scoaterea datelor si punerea intrun nou masiv
			RandomAccessFile in = new RandomAccessFile("staff.jcc","r");
			//Marimea masivului
			int n = (int)(in.length()/ Employee.RECORD_SIZE	);
			Employee[] newstaff = new Employee[n];
			
			//Citirea datelro invers
		
			for(int i =n-1;i>=0;i--)
			{
				newstaff[i]= new Employee();
				in.seek(i*Employee.RECORD_SIZE);
				newstaff[i].readData(in);
			}
			in.close();
			
			//Afisarea datelor citite
			for(Employee e: newstaff)
			{
				System.out.print(e);
				System.out.println();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
