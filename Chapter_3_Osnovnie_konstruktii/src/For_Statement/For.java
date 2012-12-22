package For_Statement;
import java.util.*;

public class For 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("How much numbers? ");
		int k = in.nextInt();
		
		System.out.print("The biggst number? ");
		int n = in.nextInt();
		
		int lotteryOdds = 1;
		for(int i=1; i <=k; i++)
		{
			lotteryOdds = (lotteryOdds * (n - i + 1)) / i;
		}
		
		System.out.println("Your Chance is 1 from " + lotteryOdds + ". Good Luck!");
	}
}
