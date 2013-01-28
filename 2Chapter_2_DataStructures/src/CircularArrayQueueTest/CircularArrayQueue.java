package CircularArrayQueueTest;

import java.util.AbstractQueue;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArrayQueue<E> extends AbstractQueue<E>
{

	/**
	 * Creaza o coada goala
	 * @param capacity Volumul Maxim
	 */
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int capacity)
	{
		elements = (E[]) new Object[capacity];
		count = 0;
		head = 0;
		tail = 0;
	}
	
	@Override
	public boolean offer(E newElement) {
		// TODO Auto-generated method stub
		
		assert newElement != null;
		if(count < elements.length)
		{
			elements[tail] = newElement;
			tail = (tail+1)% elements.length;
			count++;
			modCount++;
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(count == 0) return null;
		E r = elements[head];
		head = (head+1) % elements.length;
		count--;
		modCount--;
		return r;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		if(count == 0) return null;
		E r = elements[head];
		head = (head + 1) % elements.length;
		count --;
		modCount --;
		return r;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	private E[] elements;
	private int head;
	private int tail;
	private int count;
	private int modCount;
	
	private class QueueIterator implements Iterator<E>
	{

		public QueueIterator()
		{
			modcountAtConstruction = modCount;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(modCount != modcountAtConstruction)
			{
				throw new ConcurrentModificationException();
			}
			return offset < elements.length;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(!hasNext()) throw new NoSuchElementException();
			E r = elements[(head + offset) % elements.length];
			offset++;
			return r;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
		private int offset;
		private int modcountAtConstruction;
	}
}
