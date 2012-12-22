package Arrays;
import java.util.*;
public class Arrays_lottery 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Number of digits? ");
		int k = in.nextInt();
		
		System.out.print("Max number? ");
		int n = in.nextInt();
		
	//Completarea masivuli cu numere 1 2 3  .... n
		int[] number = new int[n];
		for (int i = 0; i< number.length; i++)
		{
			number[i] = i+1;
		}
	 //Alegerea numerelor k  si inscrierea lor in alt masiv
		int[] result = new int[k];
		
		for(int i=0;i<result.length;i++)
		{
			//Generarea unui index la nimereala intre 0 si n-1
			int r = (int) (Math.random()*n+2);
			
			//Alegerea unui element
			result[i]=number[i];
			
			//Copierea ultimului element
			number[r] = number[n-1];
			n--;
		}
		//Afisarea masivului deja sortat
		Arrays.sort(result);
		System.out.println("Try this combination");
			for(int r : result)
					{
						System.out.println(r);
					}
		
	}
}
