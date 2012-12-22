package do_Statement;
import java.util.*;
public class Do 

{
	public static void main(String[] arg)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What is your balance: ");
		Double balance = in.nextDouble();
		System.out.println("What is the interestRate");
		Double interestRate = in.nextDouble();
		int payment = 1200; 
		
		String answer = "";
		do
		{
			balance += payment;
			double interest = balance + interestRate/100;
			balance += interest;
			System.out.printf("Your Balance equals %.2f !\nDou you want to be fired?\n",balance);
			answer = in.next();
		}
		while (answer.equals("N"));
	}	
}
