package set_probleme_1;

import java.util.Scanner;

/**
  * @author Dan Cebotarenco
  * @version V 0.1.01
  */
public class problema_3a
{
	/**
	 * Parameter for exiting from cicle
	 */
	public static boolean finished = false;
	/**
	 * Maximum numbers that are permutations of a number
	 */
	public static final int MAXCANDIDATES = 10;
	/**
	 * Maximum number of Numbers
	 */
	public static final int NMAX = 10;
	/**
	 * Number entered by user
	 */
	public static int N = 0;
	/**
	 * Scanning Input Stream from KeyBoard
	 */
	public static Scanner in = new Scanner(System.in);
	
	/**
	 * Function for finding all the solutions .Backtracking, fundamental algorithm for optimized problems.
	 * @param a Array of solutions
	 * @param k an index on element
	 * @param input number that is took by user
	 */
	static void backtrack(int a[], int k, int input)
	{
		int c[] = new int [MAXCANDIDATES];
		int ncandidates, i;
		if (is_a_solution(a,k,input))
			process_solution(a,k,input);
		else
		{
			k++;
			ncandidates = construct_candidates(a,k,input,c);
			for (i=0; i<ncandidates; i++) {
				a[k] = c[i];
			
				backtrack(a,k,input);
				if (finished) return;
			
			}
		}
	}
	/**
	 * Printing solution for array fo solutions
	 * @param a Array of solutions 
	 * @param k index on element
	 * @param n	number inputed by user
	 */
	static void process_solution(int a[],int k, int n)
	{
		for(int i=1;i<=k;i++)
			System.out.printf(" %d",a[i]);
		System.out.printf("\n");
	}
	/**
	 * 
	 * @param a Array of solutions
	 * @param k index on element
	 * @param n number inputed by user
	 * @return true if is a index on element is equal with number choosed by user
	 */
	static boolean is_a_solution(int a[],int k,int n)
	{
		return k==n;
	}
	/**
	 * 
	 * @param a Array of solutions
	 * @param k index on element
	 * @param n number inputed by user
	 * @param c array where will be putted elemets for making a solution
	 * @return limit for copying from array of all elements  
	 */
	static int construct_candidates(int a[],int k,int n, int c[])
	{
		boolean in_perm[] = new boolean[NMAX];
		for(int i=1;i<NMAX;i++)
			in_perm[i] = false;
		for(int i=1;i<k;i++)
			in_perm[a[i]] = true;
		int ncandidates = 0;
		for(int i=1;i<=n;i++)
			if(!in_perm[i])
			{
				c[ncandidates] = i;
				ncandidates++;
			}
		return ncandidates;
	}
	/**
	 * Input a number from keyboard
	 */
	static public void Input()
	{
		N = in.nextInt();
		while(N>10)
		{
			System.out.println("Numbers is to high, ReEnter:");
			N = in.nextInt();
		}
	}
	/**
	 * In main is called main function <b>backtrack</b>
	 * @param args Console
	 */
	static public void main(String[] args)
	{
		int a[] = new int[NMAX];
		Input();
		backtrack(a,0,N);
	}
}