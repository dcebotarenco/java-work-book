package If_Statement;
import java.util.*;

public class If_statement 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.printf("%s","Enter your Sales in $: ");
		int yourSales = in.nextInt();
		System.out.printf("%s", "Enter Target sales in $: ");
		int target = in.nextInt();
		String performance = "";
		double bonus = 0;
		if (yourSales >= target)
		{
			performance = "Good";
			bonus = (double)(100 + 0.01 * (yourSales - target));
		}
		else 
		{
			performance = "Bad";
			bonus = 0;
		}
		
		System.out.printf("%s%s%s%.2f", "Performance = ",performance,"\nBonus = ",bonus);
		
	}
}
