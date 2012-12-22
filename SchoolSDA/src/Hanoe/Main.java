package Hanoe;

import java.util.Scanner;
/**
 * Class implements Hanoe solving problem
 * @author Dan
 *
 */
public class Main 
{
	/**
	 * In main is called {@link #Hanoe(int, char, char, char)}
	 * @param args Console
	 */
	public static void main(String[] args)
	{
		//Scan inputStream from keyboard
		Scanner in = new Scanner(System.in);
		int n;
		System.out.println("Introdu nr. de tije ");
		n=in.nextInt();
		System.out.println("Mutarile sunt urmatoarele: ");
		Hanoe(n,'A','B','C');
	}

	/**
	 * 
	 * @param n Numbers of Circles
	 * @param A Letter 'A'
	 * @param B	Letter 'B'
	 * @param C	Letter 'C'
	 */
	public static void Hanoe (int n,char A,char B,char C)
	{
		if (n==1)
		{
			System.out.println(A+" -> "+ B);
		}
		else
		{
			Hanoe(n-1,A,C,B);
				System.out.println(A+" -> "+ B);
				Hanoe(n-1,C,B,A);
		}
			
				
	}
}
