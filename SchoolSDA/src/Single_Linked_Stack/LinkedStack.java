package Single_Linked_Stack;

public class LinkedStack
{
	private Node first; //chemarea nodului principal
	private int size=0;
	public LinkedStack() //initializarea unui stack gol
	{
		first =null;
		size = 0;
	}

	public boolean isEmpty()
	{
		boolean b = true;
		if(first==null)
		{
			System.out.println("Stiva este goala");
			return b;
		}
		b = false;
		return b;
		
	}
	//adugarea
	public void push(Object elem)
	{
		Node v = new Node(elem); //crearea unui nou nod
		
		if(first == null) //daca firts  == null atuci schimbat first la I obiect
		{
			first = v; 
		}
		else //obiectul nou creat il punem in fata la first
		{
			v.setBack(first);
			first = v;  //Obiectul nou define first
		}
		
		
		 //legarea noului nod
		
		size++;
	}
	public int size()
	{
		return size;
	}
	
	public Object getFirstElem()
	{
		return first.getElement();
	}
	
	//Stergere
	public Object pop()
	{
		
		if(first==null)
		{
			System.out.println("Stiva este goala");
			return 0;
		} 
		
		Object temp = first.getElement();
		first = first.getBack();
		size --;
		return temp;
	}
	
	public void printL()
	{
		 
		
		while(first!=null)
		{
			{
	            System.out.print(" "+first.getElement());
	            first=first.getBack();
	        }
		}
	}
}
