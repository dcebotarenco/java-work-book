package While_Statement;
import java.util.Scanner;

public class While1 
{
	public static void main (String[] args)
	{
		Scanner in  = new Scanner(System.in);
		
		System.out.println("Enter your balance: ");
		double balance = in.nextDouble();
		System.out.println("Enter your Goal: ");
		double goal = in.nextDouble();
		double payment = 1200;
		double interestRate = 12;
		int years=0;
		while (balance < goal)
		{
			balance = balance + payment;
			double interest = balance * interestRate/100;
			balance += interest;
			years++;
		}
		System.out.println(years + " years.");
		
		
	}
	
}
