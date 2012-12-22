package BinarySearchTree;
/**
 * Clasa Node : 
 * Obiectul ce va fi generat esteelementul principal al arborelui
 * @author Dan
 *
 */
public class Node
{
	public int item;
	public Node leftChild;
	public Node rightChild;
	public void displayNode()
	{
		System.out.print("[");
		System.out.print(item);
		System.out.print("]");
	}
}
