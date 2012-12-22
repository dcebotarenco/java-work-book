package Single_Linked_Queue2;

import java.util.NoSuchElementException;

/**
 * Coada - Lista
 * orice obiect poate fi implimentat in aceasta lista
 */
public class QueueLinkedList
{
	
	private Node head; //se refera la primul node din lista
	private Node tail; // se refera la ultimul nod din lista
	private int size=0; // numarul de elemente din lista
	/**
	 * Acest constructor initializeaza coada cu statutul de null.
	 * head = null
	 * tail = null
	 * size = 0;
	 */
	public QueueLinkedList() //initializarea unui stack gol
	{
		head=null;
		tail=null;
		size =0 ;
	}

	/**
	 * Returneaza numarul de elemente din lista
	 * @return numarul de elemente din lista
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * Adauga un elemet in lista 
	 * @return
	 */
	public void addToListToTail(Object obj)
	{
		//Creaem un nou nod 
		//Acest node va fi legat in lista la sfirsit
		Node n = new Node(obj);
		//daca lista e goala,doar legam noul node dupa coada
		if(tail != null)
		{
			tail.setNext(n);
		}
		//Tail(coada) listei i se schimba  la nou nod
		tail = n;
		
		//Daca lista a fost goala, head tot trebue sa fie referinta la acest node.
		if(head == null)
		{
			head = n;
		}
		
		//Lista are un nod - marim size();
		size++;
	}
	
	/**
	 * Sterge un element de la inceputul listei
	 * @return returnneaza Obiectele 
	 */
	public Object deleteFromListFromFront()
	{
		//daca coada este goala, se arunca exceptia
		if(size == 0)
		{
			throw new NoSuchElementException("Cant remove an element from an empty queue.");
		}
		//Gasim elementul dela nodul din fata(head)
		//Noi stim ca Head-ul va fi nenull, coada are elemente daca am ajuns aici
		
		Object temp = head.getElement();
		//Trecem Head-ul la urmatorul node din lista.acaesta face ca Headu-ul sa fie nereferit si va fi 
		//colectat de garbadge collector.
		head=head.getNext();
		//lista sa micsorat
		size--;
		//Daca lista e goala atunci ambele head si tail trebue sa fie null.
		//Head-ul deja va fi null si nu e nevoie sa le modificam
		if(size == 0)
		{
			tail = null;
		}
		return temp;
	}
	
	public void printL()
	{
		while(head!=null)
		{
			{
	            System.out.print(" "+head.getElement());
	            head=head.getNext();
	        }
		}
		
	}
}
