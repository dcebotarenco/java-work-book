package Single_Linked_Queue2;

import java.util.Scanner;


public class MainQ 
{
	public static void main(String[] args)
	{
		QueueLinkedList stack = new QueueLinkedList();
		stack.addToListToTail(4);
		stack.addToListToTail(5);
		
		
		stack.printL();
		System.out.println("\nSize :"+stack.size());
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	}
}
