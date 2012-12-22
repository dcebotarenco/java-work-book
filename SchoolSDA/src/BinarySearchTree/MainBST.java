package BinarySearchTree;

import java.util.Scanner;

/**
 * Parcurgerea Arborelui in clasa TreeTraversal
 * 
 * @author Dan
 *
 */
public class MainBST
{
	public static void main(String[] args) throws Exception
	{
		Tree theTree = new Tree();
		theTree.insert(20);
		theTree.insert(18);
		theTree.insert(28);
		theTree.insert(15);
		theTree.insert(19);
		theTree.insert(23);
		theTree.insert(22);
		theTree.insert(16);
		theTree.insert(5);
		theTree.insert(37);
		theTree.insert(90);
		theTree.insert(3);
		theTree.insert(2);
		theTree.insert(75);
		theTree.insert(39);
		theTree.insert(25);
		
		System.out.println("Displaying the tree");
		theTree.displayTree();

		System.out.println("Traversare inordine");
		theTree.inOrder(theTree.returnRoot());
		System.out.println(" ");

		System.out.println("Traversarea preordine");
		theTree.preOrder(theTree.returnRoot());
		System.out.println(" ");
			
		System.out.println("Traversarea postordine");
		theTree.postOrder(theTree.returnRoot());
		System.out.println(" ");
		
		Scanner in =new Scanner(System.in);
		int n = in.nextInt();
	} 
} 
