package Laborator_3_Structures;

import java.util.Scanner;

/**
 * This Class impliments a simple Program that allow you to choose what element to rewrite from a matrix
 * entered by User.
 * @author Dan
 *
 */
public class Matrix_Choose 
{
	/**
	 * Number that is a mirror of option Menu.
	 */
	public static int choose;
	/**
	 * Size of Array Rows
	 */
	public static int n = 0;
	/**
	 * Size of Array Columns
	 */
	public static int m = 0;
	/**
	 * String that will get answer of User.
	 */
	public static String answer = "";
	/**
	 * Bidimensional Matrix unalocated with memory.
	 */
	public static int[][] matrix;
	/**
	 * Scanner Object - Scans Stream from Keyboard.
	 */
	public static Scanner in = new Scanner(System.in);
	/**
	 * In main will be called methods of Program.
	 * @param args Console
	 */
	public static void main(String[] args)
	{
		inputNumbers();
		printMatrix();
		menu();
	}
	/**
	 * Function that alloc memory for matrix and fill it with numbers.
	 * Numbers are entered by Object {@link #in} and and placed in {@link #matrix}.
	 */
	public static void inputNumbers()
	{
		System.out.print("Enter the dimension of matrix Rows x Columns : ");
		n=in.nextInt();
		System.out.print(" X ");
		m=in.nextInt();
		matrix = new int[n][m];
		System.out.println("Enter elements in Rows :");
		//Filling Up Matrix
		for(int Row = 0; Row<matrix.length ; Row++)
		{
			System.out.println("Row " + (Row+1));
			for(int Column = 0 ;Column < matrix[Row].length;Column++)
			{
				System.out.println("Element "+ (Column+1));
				matrix[Row][Column]=in.nextInt();
			}
		}
	}
	/**
	 * Print the elements of matrix 
	 */
	public static void printMatrix()
	{		
			System.out.println();
			System.out.println("Matrix contains:");
			for(int Row = 0; Row < matrix.length; Row++)
			{
				for(int Column = 0; Column < matrix[Row].length; Column++)
				{
					System.out.print(matrix[Row][Column]+" ");
				}
				System.out.println();
			}
	}
	/**
	 * Draw in Console an interface of simple menu for user.
	 */
	public static void menu()
	{
		System.out.printf("\nMENU:\n1.Print Matrix\n2.Change an Element from matrix\n3.About\n4.Exit");	
		answer="Retry";
		choose = in.nextInt();
		setChoose();
	}
	/**
	 * Change an element from matrix.
	 * First of all Input indexes then value of element.
	 * @param choose The choose from menu.
	 */
	public static void changeElement()
	{		printMatrix();
			//if answer of user is Retry
			if(answer.equals("Retry"))
			{
				System.out.println("What are the indexes Row x Column element?: ");
				int fn = in.nextInt();
				int fm = in.nextInt();
				
					//if indexes are in range of matrix
					if(fn<n && fm <m)
					{
						System.out.println();
						System.out.printf("What is the new value of element[%d][%d]? :",fn,fm);
						int value = in.nextInt();
						String tmp = Integer.toString(matrix[fn][fm]);
						if(tmp != null)
						{
							matrix[fn][fm]=value;
						}
						System.out.println("Done..");
						getAnswer();
					}else
					{
						System.out.printf("\nNot In Range Of Matrix\n");
						getAnswer();
					}
			}else
				menu();
	}
	/**
	 * Function that is used to ask user for Retrying last operation or get back in Menu.
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
		case 1: {printMatrix();menu();} break;
		case 2: changeElement(); break;
		case 3: {aboutProgram();menu();} break;
		case 4: System.exit(0);
		}
	}
	/**
	 * About Program for User
	 */
	public static void aboutProgram()
	{
		System.out.println("Autor: Cebotarenco Dan, Infa-111");
	}
	
}
