package ObjectRefTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectRefTest 
{
	public static void main(String[] args)
	{
		Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setSecretary(harry);
		
		Employee[] staff = new Employee[3];
		staff[0] = boss;
		staff[1] = harry;
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		try
		{
			//Slavarea tuturor datelor despre lucratori in file staff.st
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("staff.st"));
			out.writeObject(staff);
			out.close();
			
			//Scoaterea tuturor datelor despre lucratori intru nou masiv
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("staff.st"));
			Employee[] newstaff = (Employee[]) in.readObject();
			in.close();
			
			//Ridicarea salariului secretarului
			newstaff[1].raiseSalary(10);
			
			//Afisarea datelor citite
			for(Employee e: newstaff)
			{
				System.out.println(e);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
