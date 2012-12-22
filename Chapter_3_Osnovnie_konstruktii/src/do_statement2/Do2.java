package do_statement2;
import java.util.*;

public class Do2 
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("How much you can invest in a year? ");
		double payment = in.nextDouble();
		
		System.out.print("Interest Rate? ");
		double interestRate = in.nextDouble();
		
		double balance = 0;
		int year = 0;
		String answer;
		
		//Reinoirea Balansului pina cind utilizatorul nu va spune N
		
		do
		{
			//adaugarea investirii si prcentului anual
			balance+=payment;
			double interest = balance + interestRate/100;
			balance+=interest;
			year++;
			
			//Aratarea balansului
			System.out.printf("After %d, you will have %.2f",year,balance);
			//Intrebarea daca utilzatorul doreste sa incheie lucrul
			System.out.print("Go in vacation? (Y/N)");
			answer=in.next();
		}
		while(answer.equals("N"));
	}
}
