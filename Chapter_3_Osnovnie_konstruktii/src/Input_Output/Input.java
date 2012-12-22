package Input_Output;

import java.util.*;

public class Input 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		//Get first line;
		System.out.print("What is your name? ");
		String name = in.nextLine();
		
		//Get first digit number;
		System.out.println("How old are you? ");
		int age = in.nextInt();
		
		//Output the information
		System.out.println(name + " next year you will have " + (age + 1));
	}
}
