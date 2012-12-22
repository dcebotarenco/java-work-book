package WhileStatement2;
import java.util.*;

public class Retirement 
{
	public static void main (String[] args)
	{
		//Input data
		Scanner in = new Scanner(System.in);
		
		System.out.print("What sum you need?");
		double goal = in.nextDouble();
		
		System.out.print("How much you can invest every year?");
		double payment = in.nextDouble();
		
		System.out.print("Your interestRate?");
		double interestRate = in.nextDouble();
		
		double balance = 0;
		int years = 0;
		
		//Balasul se fa reinoi pina cind nu va fi ajus la suma necesara
		while(balance < goal)
		{
			//Adaugarea investirii si procentului anual
			balance += payment;
			double interest = balance * interestRate/100;
			balance += interest;
			years++;
		}
		System.out.println("You can leave us after "+ years + "years.");
		
	}	
}
