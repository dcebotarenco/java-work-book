package ExceptionalTest;

import java.util.Date;
import java.util.EmptyStackException;
import java.util.Stack;

public class ExceptionalTest 
{
	public static void main(String[] args)
	{
		int i = 0;
		int ntry = 10;
		Stack<Object> s = new Stack<Object>();
		long s1;
		long s2;
		
		// ntry ori se executa controlul, e gol staku sau nu
		System.out.println("Testing for empty stack");
		s1 = new Date().getTime();
		for(i = 0; i<=ntry; i++)
		{
			if(!s.empty())
			{
				s.pop();
			}
		}
		s2 = new Date().getTime();
		System.out.println((s2 - s1)+ "miliseconds");
		
		//ntry ori se scote un element din stack gol si se genereaza exceptie
		System.out.println("Catchin EmptyStackException");
		s1 = new Date().getTime();
		for(i = 0; i<ntry; i++)
		{
			try
			{
				s.pop();
			}
			catch(EmptyStackException e)
			{
				e.printStackTrace();
			}
		}
		s2 = new Date().getTime();
		System.out.println((s2-s1) + "milliseconds");
	}
}
