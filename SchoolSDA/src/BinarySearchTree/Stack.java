package BinarySearchTree;
/**
 * Stiva ce contine  Lista inlantuta
 * @author Dan
 *
 */
public class Stack
{
	private LinkedListStack listObj;
	public Stack()
	{
		listObj = new LinkedListStack();
	}
	public void push(Node num)
	{
		listObj.insert(num);
	}
	public Node pop()
	{
		return listObj.delete();
	}
	public boolean isEmpty()
	{
		return listObj.isEmpty();
	}
}
/**
 * Node de stiva cotine referinta la urmatorul
 * @author Dan
 *
 */
class StackNode
{
	public Node item;
	public StackNode next;
	public StackNode(Node val)
	{
		item = val;
	}

}
/**
 * Lista inlantuita
 * @author Dan
 *
 */
class LinkedListStack
{
	private StackNode first;
	public LinkedListStack()
	{
		first = null;
	}
	public boolean isEmpty()
	{
		return (first==null);
	}
	public void insert(Node key)//inserts at beginning of list
	{
		StackNode newLLNode = new StackNode(key);
		newLLNode.next = first;
		first = newLLNode;
	}
	public Node delete()//deletes at beginning of list
	{
		StackNode temp = first;
		first = first.next;
		return temp.item;
	}
}