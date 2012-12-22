package Training;

import java.util.Scanner;

public class saf 
{
	public static void main(String[] args)
	{
	
		Scanner	in  = new Scanner (System.in);
		long[] s = new long [101000];
		final int mod = 1000000007;
		final double eps = 1e-8;
		int T;
		int i;
		for (i = 0; i < 100; ++i)
		{
		   s[i] = 1;
		}
		s[100] = 1;
		for (i = 101; i <101000; ++i) 
		{
			
		   if ( i < 314) 
		   {
		    s[i] = s[i - 100] % mod;
		   } 
		   else 
		   {
		    s[i] = (s[i-100] + s[i-314])% mod;
		   }
		}
		T = in.nextInt();
		while (T--!=0) {
		   double ss;
		   ss= in.nextDouble();
		   
		   if (ss < 0) 
		   {
		    System.out.print("0");
		    continue;
		   }
		   int t = (int)((ss + eps) * 100);
		   System.out.printf("%lld\n", s[t]);
		}
	
	}


}


