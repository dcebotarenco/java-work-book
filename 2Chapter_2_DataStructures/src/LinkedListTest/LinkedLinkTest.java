package LinkedListTest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Aceasta programa demonstreaza lucru cu lista inlantuita
 * @author Dan
 *
 */
public class LinkedLinkTest
{
	public static void main(String[] args)
	{
		LinkedList<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		
		LinkedList<String> b = new LinkedList<String>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		
		//Adaugarea cuvintelor din b in a
		ListIterator<String> aIterator = a.listIterator();
		Iterator<String> bIterator = b.listIterator();
		
		while(bIterator.hasNext())
		{
			if(aIterator.hasNext())
			{
				aIterator.next();
			}
			aIterator.add(bIterator.next());
		}
		System.out.println(a);
		
		//stergerea fiecare al doilea element din b;
		
		bIterator = b.iterator();
		while(bIterator.hasNext())
		{
			bIterator.next();//sarim peste un element
			if(bIterator.hasNext())
			{
				bIterator.next();//sarim al doilea
				bIterator.remove();//il stergem
			}
		}
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
	}
}
