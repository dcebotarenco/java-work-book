package Single_Linked_Stack;

public class Node 
{
	//variabilele Exemplului
	private Object element;
	private Node pback;
	//Constructori simpli

	public Node(Object e)
	{
		element = e;
		pback = null;
	}
	//Accesori
	Object getElement()
	{
		return element;
	}
	Node getBack()
	{
		return pback;
	}
	//Modificatori
	void setElement(Object newElem)
	{
		element = newElem;
	}
	void setBack(Node newBack)
	{
		pback = newBack;
	}
}
