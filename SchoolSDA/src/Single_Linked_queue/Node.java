package Single_Linked_queue;

public class Node 
{
	private Object element;
	private Node next;
	
	public Node()
	{
		this(null,null);
	}
	public Node(Object obj,Node n)
	{
		element = obj;
		next = n;
	}
	
	public Object getElement()
	{
		return element;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setElement(Object obj)
	{
		element = obj;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
}
