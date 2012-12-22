package Single_Linked_Queue2;

public class Node 
{
	//variabilele Exemplului
	private Object element;
	private Node pnext;
	private Node pprev;
	//Constructori simpli
	
	public Node(Object e)
	{
		element = e;
		pnext = null;
		pprev = null;

	}
	//Accesori
	Object getElement()
	{
		return element;
	}
	
	Node getNext()
	{
		return pnext;
	}
	//Modificatori
	void setElement(Object newElem)
	{
		element = newElem;
	}
	void setNext(Node newNext)
	{
		pnext = newNext;
	}
	
}
