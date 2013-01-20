package ObjectFileTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectFileTest 
{
	public static void main(String[] arga)
	{
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		
		Employee[] staff = new Employee[3];
		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		try
		{
			//inscrierea datelor in file empl.rt
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("empl.rt"));
			out.writeObject(staff);
			out.close();
			
			//Scoaterea tuturor datelor intrun nou masiv
			ObjectInputStream in  = new ObjectInputStream(
					new FileInputStream("empl.rt"));
			Employee[] newStaff = (Employee[]) in.readObject();
			in.close();
			//Afisarea informatiei despre lucratori citite din empl.rt
			for(Employee e: newStaff)
			{
				System.out.println(e);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
