package Single_Linked_queue;

public class Simple_Linked_queue 
{
	private Node head;
	private int size =0 ;
	
	public Simple_Linked_queue()
	{
		head = null;
	}
	public int size()
	{
		return size;
	}
	public void enqueue(Object obj)
	{
		Node node = new Node();
		node.setElement(obj);
		node.setNext(null);
		if(head == null)
		{
			head = node;
		}
		else
			head.setNext(node);
		head = node;
		size++;
	}
	
	public void dequeue()
	{
		Node v = new Node();
		if(head==null)
		{
			System.out.println("Coada vida");
		}
		v = head.getNext();
		head = head.getNext();
		size--;
	}
	
	public void printfQ()
	{
		Node v  = new Node();
		while(v.getNext()!=null)
		{
			System.out.print(" " + v.getElement());
			//head = v.getNext();
		}
	}
}
