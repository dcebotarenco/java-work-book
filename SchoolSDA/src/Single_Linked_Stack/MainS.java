package Single_Linked_Stack;

import java.util.Scanner;


public class MainS 
{
	public static void main(String[] args)
	{
		LinkedStack stack = new LinkedStack();
		stack.push(4);
		stack.push(4);
		stack.push(7);
		stack.pop();
		stack.pop();
		stack.push(5);
		stack.printL();
		System.out.println("\nSize :"+stack.size());
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	}
}
