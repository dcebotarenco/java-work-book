package set_probleme_1;
import java.util.*;
/**
 *@author Dan Cebotarenco
 *<blockquote>This program is made for calculation permutations 
 *arrengements and combinations between 2 digits.
 *Program has 2 static variabiles : <b>n</b> and <b>m</b>.</blockquote>
 *This are numbers that must be inputed by Object <b>in</b> from <b>java.util.*</b> library.
 *@version Beta v 1.01
 *
 */
public class problema_1 
{
	/**
	 * Int variabile that indicates total number of elements inputed by user
	 */
	public static int n = 0;
	/**
	 * Int variabile that indicates a part of numbers to be used 
	 */
	public static int m = 0;
	/**
	 * Scanning Input Stream from KeyBoard
	 */
	public static Scanner in = new Scanner(System.in);
	/**
	 * <pre>In {@link #main(String[])} goes main calculations and declarations of next methods :</pre>
	 * <blockquote>{@link #factorial(int)},{@link #permutation(int)},{@link #combination(int, int)},
	 * {@link #arrangemention(int, int)},{@link #EnterM()}{@link #EnterN()}.</blockquote>
	 * @param args For console use
	 */
	public static void main(String[] args)
	{
		EnterN();	
		permutation(n);
		EnterM();
		arrangemention(n, m);
		combination(n, m);
	}	
	/**
	 * Function EnterN() - Input N with a check of condition (n <= 20)
	 */
	public static void EnterN()
	{
		System.out.print("n <= 20 Enter n:");
		n = in.nextInt();
		/**
		 * 
		 */
		while(n>20)
		{		
			if (n>20) 
			{
				System.out.println("n <= 20 Re_Enter n:");
				n = in.nextInt();
			}
		}		
	}
	/**
	 * Function EnterM() - Input M with a check of contiodion (m <= n )
	 */
	public static void EnterM()
	{
		System.out.println("m <= n Enter m:");
		m = in.nextInt();
		while(m>20)
		{		
			if (m>20) 
			{
				System.out.println("n <= 20 Re_Enter n:");
				m = in.nextInt();
			}
		}		
	}
	/**
	 * Function factorial(int n) - Formula of recursive calculation of factorial
	 * @param n number to be factorialized
	 * @return result of number {@link #n} factorialized
	 */
	public static int factorial(int n)
	{
	    if (n == 0) return 1;
	    return n * factorial(n-1);
	}
	/**
	 * Function permutarion(int n) - Formula of calculation permutations
	 * @param n number to be permuted
	 */
	public static void permutation(int n)
	{
		double res = factorial(n);
		System.out.printf("Permutari din %d = %.1f\n",n,res);
	}
	/**
	 * Function arrangemention(int n, int m) - Formula of calculation arrangements
	 * @param n total number o elements
	 * @param m number of elements to be arranged
	 */
	public static void arrangemention(int n, int m)
	{
		double res = factorial(n) /  factorial(n - m);
		System.out.printf("Aranjamente din %d a cite %d = %.1f",n,m,res);
	}
	/**
	 * Function combination(int n, int m) - Formula of calculation combinations
	 * @param n total number of elements
	 * @param m numbers of elements to bo combined
	 */
	public static void combination(int n, int m)
	{
		int res = factorial(n) / factorial(m) * factorial(n-m);
		System.out.printf("Combinari din %d a cite %d = %.1f",n,m,res);
	}
}
