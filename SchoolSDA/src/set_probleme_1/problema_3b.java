package set_probleme_1;
import java.util.*;
import java.io.*;
/**
 * Program for detecting all solutions posible for putting on nxn table n shifts, but these to not attack each other.
 * @author Dan
 *
 */
public class problema_3b 
{
	public static Scanner in = new Scanner(System.in);
	public static String n;
	public static String a = "1";
	public static void main(String[] args) throws IOException
	{		
			Input();
			perm1("",a);
	}	
	/**
	 * Input a number from keyboard
	 */
	private static void Input()
	{
		
		int[] array = new int[10];
		int z,fact;
		
		System.out.print("Introduceti n x n dimesiunea a mesei de Sah: ");
		n=in.next();
		z=Integer.parseInt(n);
		fact=factorial(z);
		System.out.printf("Cazuri posibile sunt :%d \n",fact);
		
		for(int i=0;i<z;i++)
		{
			array[i]=i+1;
		}
		
		for(int i=2;i<=z;i++)
		{
			a = a + Integer.toString(i);
		}
	}
	/**
	 * Permutation alorithm
	 * @param prefix Prefix on each printing of solutions 
	 * @param s String what characters will be permuted
	 */
	 private static void perm1(String prefix, String s) 
	 {	
		    int i =0;
	        int N = s.length();
	        if (N == 0) System.out.println(prefix);
	        else 
	        {		
		            for (i = 0; i < N; i++)
		            {	
		            	perm1(prefix + s.charAt(i), (s.substring(0, i) + s.substring(i+1, N)));
		            }   	
	        }
	 }	
	 /**
	  * Function for calculating factorial of number
	  * @param n number to be factorialized
	  * @return number already factorialized
	  */
	public static int factorial(int n)
	{
	    if (n == 0) return 1;
	    return n * factorial(n-1);
	}
}

