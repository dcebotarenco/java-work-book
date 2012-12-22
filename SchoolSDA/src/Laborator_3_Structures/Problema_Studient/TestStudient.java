package Laborator_3_Structures.Problema_Studient;


import java.util.Scanner;

/**
 * This Class impliments a Test Container, in where we create objects Studient.
 * There we have methos that will draw to user a simple menu.
 * @author Dan
 *
 */
public class TestStudient 
{
	/**
	 * This variable is changing in independes of User,in {@link #menu()} and {@link #menu2()}
	 * it is set on "Retry" that will be a flag for some methods.
	 */
	public static String answer = "";
	/**
	 * This variable is used on switchin user's choose in Menu.
	 * @see TestStudient#setChoose()
	 * @see TestStudient#setChoose2().
	 */
	public static int choose;
	/**
	 * Scanner will scan the input Stream from keyboard
	 */
	public static  Scanner in = new Scanner(System.in);
	/**
	 * Size of array of students.
	 */
	public static int NumberOfStudient=0;
	/**
	 * Array that will will contain Student objects.Not initialezed!
	 */
	static Studient[] Stud;
	/**
	 * In main are called methods
	 * @param args Console
	 */
	public static void main(String[] args)
	{
		 inputSizeOfStud();
		 //printStud();
		 menu();
	}
	/**
	 * Function that will print list of all Students inputed by User.
	 */
	public static void printStud()
	{
		String[][] table = new String[NumberOfStudient][4];
		for(int i=0;i<NumberOfStudient;i++)
		{
			System.out.print(++i+": ");--i;			
			for(int j=0;j<3;j++)
			{
				switch(j)
				{
					case 0: 
					{
						table[i][j] = (Stud[i].getPrenume() + " " + Stud[i].getNume());
						System.out.print(table[i][j]+"\t");
						break;
					}
					case 1:
					{
						table[i][j] = (Stud[i].getSpecialiatea());
						System.out.print(table[i][j]+"\t");
						break;
					}
					case 2:
					{
						table[i][j] = (Stud[i].getBirthDay());
						System.out.print(table[i][j]);
						System.out.println();
						break;
					}
				}
			}
		}
	}
	/**
	 * In this function is initialized array with {@link #NumberOfStudient}.First of all we create String
	 * an input it.After it we check this string if this is number with {@link #isNumber(String)}.If check is True
	 * String is parsed to integer and setted to {@link #NumberOfStudient}.After all this we input information of all students. 
	 */
	public static void inputSizeOfStud()
	{
		System.out.print("How many Studients? : ");		
		String number = in.next();
		while(isNumber(number)!=true)
		{
			number = in.next();
		}
		NumberOfStudient=Integer.parseInt(number);
		Stud = new Studient[NumberOfStudient];
		for(int i = 0; i < NumberOfStudient; i++)
		{				
			System.out.print("Surname and Name of Student : ");
			String Prenume = in.next();	
			String name = in.next();
		
			System.out.print("Specialisation : ");
			String Spec = in.next();
			System.out.print("Date Of Birthday :");
			int d = in.nextInt();
			System.out.print("Month :");
			int m = in.nextInt();
			System.out.print("Year :");
			int y = in.nextInt();
			Stud[i] =new Studient(Prenume,name, Spec,y,m,d);
		}
	}
	/**
	 * This function is checking that answer on user.
	 */
	public static void getAnswer()	
	{
		System.out.println("Go Back/Retry?");
		answer=in.next();
	
		while(!answer.equals("Back") || !answer.equals("Retry"))
		{
			if(answer.equals("Back")) 
				{
					menu();
				}
			else if(answer.equals("Retry")) 
				{
					setChoose();
				}
			
				System.out.println("Enter 'Back' or 'Retry' ");
				answer=in.next();		
		}
	
	}
	/**
	 * switching the choose of user in different cases.
	 */
	public static void setChoose()
	{
		switch(choose)
		{
		case 1: {printStud();menu();} break;
		case 2: changeElement(); break;
		case 3: {aboutProgram();menu();} break;
		case 4: System.exit(0);
		}
	}
	/**
	 * Draw a simple menu.Set by default {@link #answer} "Retry".Input the choose of user independence of menu.
	 * Call {@link #setChoose()}.
	 */
	public static void menu()
	{
		System.out.printf("\nMENU:\n1.Print List of Studients\n2.Change an Element from List\n3.About\n4.Exit\n");	
		answer="Retry";
		choose = in.nextInt();
		setChoose();
	}
	/**
	 * About Program for User.
	 */
	public static void aboutProgram()
	{
		System.out.println("Autor: Cebotarenco Dan, Infa-111");
	}
	/**
	 * In this function we call second {@link #menu2()}
	 */
	public static void changeElement()
	{
		printStud();
		if(answer.equals("Retry"))
		{
			System.out.println("What do you want to change? :");
			menu2();
		}
	}
	/**
	 * Second menu Draw another menu with options of changing some elements of each Object Student
	 */
	public static void menu2()
	{
		System.out.printf("\nMENU:\n1.Surname and Name\n2.Specialisation\n3.Birthday\n4.Back\n");	
		answer="Retry";
		choose = in.nextInt();
		setChoose2();
	}
	/**
	 *Switching the choose of user in dependence of second {@link #menu2()}.
	 */
	public static void setChoose2()
	{
		switch(choose)
		{
		case 1: 
		{
			
				System.out.println("What is the Student that you want to change Surname or Name");
				int index = in.nextInt();
				System.out.println("Enter new Surname and Name: ");
				Stud[index-1].setPrenume();
				Stud[index-1].setName();
				getAnswer();
				
			
		} break;
		case 2: 
			{
				System.out.println("What is the Student that you want to change Specialisation");
				int index = in.nextInt();
				System.out.println("Enter new Specialisation: ");
				Stud[index-1].setSpec();
				getAnswer();
			}break;
		case 3: 
			{
				System.out.println("What is the Student that you want to change Birthday");
				int index = in.nextInt();
				System.out.println("Enter new Date of Birth Day 'dd/MM/yyyy' : ");
				Stud[index-1].setBirthDay();
				getAnswer();
			} break;
		case 4: 
			{
				menu();
			}
		}
	}
	/**
	 * 
	 * @param s String that will checked that is number or not
	 * @return	true or false
	 */
	public static boolean isNumber(String s)
	{
		boolean valid = true;
		
			if(s.length()==0 )
			{
				System.out.println("There is no input");
				valid = false;
			}
			int i=0;
			while(i<s.length())
			{
				if(!Character.isDigit(s.charAt(i)))
				{
					System.out.println("That is NOT a number");
					valid = false;
				}
				i++;
			}
			
		return valid;
	}
}
