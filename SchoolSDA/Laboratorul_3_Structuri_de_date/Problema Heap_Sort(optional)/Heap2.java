package Heap_Sort;
/**
    This class implements a simple version 
    of the heapsort algorithm.
 
    Note that this algorithm assumes that
    the values to be sorted are in elements
 */
 public class Heap2
 {
	 /**
	  * Construnctor Impliments an Array Field
	  * @param anArray Array Of elements
	  */
    public Heap2(int[] anArray)
    {
       a = anArray;
    }
 
    /**
       Sorts the array managed by this sorter
    */
    public void sort()
    {
       sort( a.length - 1 );
    }
    /**
     * Overoalding mothod sort() with one argument
     * @param end
     */
    public void sort( int end )
    {
       // Establish the heap property.
       for ( int i = end / 2; i >= 1; i-- )
          fixHeap( i, end, a[i] );
       
       // Now place the largest element last,
       // 2nd largest 2nd last, etc.
       for ( int i = end; i > 1; i-- )
       {
          // a[1] is the next-biggest element.
          swap( 1, i );
 
          // Heap shrinks by 1 element.
          fixHeap( 1, i - 1, a[1] );
       }
    }
 
    /**
       Assuming that the partial order tree
       property holds for all descendants of
       the element at the root, make the
       property hold for the root also.
 
       @param root the index of the root
                    of the current subtree
       @param end  the highest index of the heap
    */
    private void fixHeap( int root, int end,
                          int key )
    {
       int child = 2 * root; // left child
       
       // Find the larger child.
       if ( child < end && a[child] < a[child + 1] )
          child++;  // right child is larger
 
       // If the larger child is larger than the
       // element at the root, move the larger child
       // to the root and filter the former root 
       // element down into the "larger" subtree.
       if ( child <= end && key < a[child] )
       {
          a[root] = a[child];
          fixHeap( child, end, key );
       }
       else
          a[root] = key;
    }
 
    /**
       Swaps two entries of the array.
       @param i the first position to swap
       @param j the second position to swap
    */
    private void swap(int i, int j)
    {
       int temp = a[i];
       a[i] = a[j];
       a[j] = temp;
    }
    /**
     * Array
     */
    private static int[] a;
}