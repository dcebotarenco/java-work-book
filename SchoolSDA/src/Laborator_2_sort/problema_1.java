package Laborator_2_sort;

import java.util.Scanner;
/**
 * 
 * @author Dan Cebotarenco
 *<blockquote>Program with 4 variants of Sorting Algorithms<blockquote>
 */
public class problema_1 
{
	/**
	 * Array inputed by User
	 */
	public static int array[];
	public static int arr[];
	/**
	 * Variants for Menu of Sorting
	 */
	public static int choice=1;
	/**
	 * Length of Array
	 */
	public static int N;
	/**
	 * Scan inputStream for Keyboard
	 */
	public static Scanner in = new Scanner(System.in);
	/**
	 * In main are called functions of sorting.
	 * @param args Console
	 */
	public static void main(String[] args)
	{
		String answer = "Da";
		while(answer.equals("Da"))
		{
			
			Input();
			System.out.printf("\n");
			menu();
			choice=in.nextInt();
			switch(choice)
			{
			case 1: {bubbleSort(arr);printArray(arr);break;}
			case 2: {selectionSort(arr);printArray(arr);break;}
			case 3: {insertionSort(arr);printArray(arr);break;}
			case 4: {shakersort(arr);printArray(arr);break;}
			default: {bubbleSort(arr);printArray(arr);break;}
			}
			System.out.printf("\nRetry? (Da/Nu)");
			answer = in.next();
		}
	}
	/**
	 * Function for inputing length of Array , and Array elements.
	 */
	public static void Input()
	{
		System.out.printf("Input length of array: ");
		N = in.nextInt();
		arr = new int[N];
		array = new int[N];
		System.out.printf("Input elements of array: ");
		for(int i=0; i<N;i++)
		{
			arr[i]=in.nextInt();
			array[i]=arr[i];
		}
	}
	/**
	 * Bubble sort is a simple and well-known sorting algorithm.
	 * Compare each pair of adjacent elements from the beginning of an array and, if they are in reversed order, swap them.
	 * If at least one swap has been done, repeat step 1.
	 * @param arr Array inputed by user.
	 */
	public static void bubbleSort(int[] arr)
	{
		System.out.printf("BubbleSort of array:\n ");
	      boolean swapped = true;
	      int j = 0;
	      int tmp;
	      while (swapped)
	      {
	            swapped = false;
	            j++;
	            for (int i = 0; i < arr.length - j; i++) 
	            {                                       
	                  if (arr[i] > arr[i + 1]) 
	                  {                          
	                        tmp = arr[i];
	                        arr[i] = arr[i + 1];
	                        arr[i + 1] = tmp;
	                        swapped = true;
	                  }
	            }                
	      }
	}
	/**
	 * The idea of algorithm is quite simple. Array is imaginary divided into two parts - sorted one and unsorted one. 
	 * At the beginning, sorted part is empty, while unsorted one contains whole array. 
	 * At every step, algorithm finds minimal element in the unsorted part and adds it to the end of the sorted one.
	 * When unsorted part becomes empty, algorithm stops.
	 * When algorithm sorts an array, it swaps first element of unsorted part with minimal element 
	 * and then it is included to the sorted part. 
	 * This implementation of selection sort in not stable. In case of linked list is sorted, and, instead of swaps, 
	 * minimal element is linked to the unsorted part, selection sort is stable.
	 * @param arr Array inputed by user.
	 */
	public static void selectionSort(int[] arr) 
	{
		System.out.printf("Straight selection Sort of array:\n ");
	      int i, j, minIndex, tmp;
	      int n = arr.length;
	      for (i = 0; i < n - 1; i++) 
	      {
	            minIndex = i;
	            for (j = i + 1; j < n; j++)
	                  if (arr[j] < arr[minIndex])
	                        minIndex = j;
	            if (minIndex != i) 
	            {
	                  tmp = arr[i];
	                  arr[i] = arr[minIndex];
	                  arr[minIndex] = tmp;
	            }
	      }
	}
	/**
	 * Insertion sort algorithm somewhat resembles selection sort. 
	 * Array is imaginary divided into two parts - sorted one and unsorted one. 
	 * At the beginning, sorted part contains first element of the array and unsorted one contains the rest. 
	 * At every step, algorithm takes first element in the unsorted part and inserts it to the right place of the sorted one.
	 * When unsorted part becomes empty, algorithm stops.
	 * @param arr Array inputed by user.
	 */
	public static void insertionSort(int[] arr) 
	{
		System.out.printf("Straight insertion Sort of array:\n ");
	    int i, j, newValue;
	    for (i = 1; i < arr.length; i++) 
	    {
	          newValue = arr[i];
	          j = i;
	          while (j > 0 && arr[j - 1] > newValue)
	          {
	                arr[j] = arr[j - 1];
	                j--;
	          }
	          arr[j] = newValue;
	    }
	}
	/**
	 * Cocktail sort, also known as bidirectional bubble sort, cocktail shaker sort, shaker sort,
	 * is a variation of bubble sort that is both a stable sorting algorithm and a comparison sort. 
	 * The algorithm differs from a bubble sort in that it sorts in both directions on each pass through the list. 
	 * This sorting algorithm is only marginally more difficult to implement than a bubble sort.
	 * @param arr Array inputed by user.
	 */
	public static void shakersort(int[] arr)
	{
		System.out.printf("Shakersort Sort of array:\n ");
		boolean swapped = true;
		int tmp = 0;
		do
		{
			swapped = false;
			
			for(int i=0; i<arr.length - 2;i++)
			{
				if (arr[i] > arr[i+1])
				{
					tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
				}
			}
			if(swapped == false)
			{
				for(int i=arr.length - 2; i>0;i--)
				{
					if(arr[i] > arr[i+1])
					{
						tmp = arr[i];
	                    arr[i] = arr[i + 1];
	                    arr[i + 1] = tmp;
	                    swapped = true;
					}
				}
			}
		}while (swapped);
	}
	/**
	 * Menu of choices in Sorting.
	 */
	public static void menu()
	{
		System.out.printf("Inputed Array:");
		printArray(array);
		
		System.out.printf("\nMenu\n1.Bubble Sort.\n2.Straight selection.\n3.Straight insertion.\n4.Shaker Sort.");
		
		System.out.printf("Select your choice");
		
	}
	/**
	 * Printing Array
	 * @param arr Array inputed by User
	 */
	public static void printArray(int []arr)
	{
		for(int i= 0 ; i<N;i++)
		{
			System.out.printf("%d ", arr[i]);
		}
	}
}

