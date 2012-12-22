package Laborator_2_sort;

import java.util.Scanner;
/**
 * Program that insert an element in an array and sort it.
 * @author Dan Cebotarenco
 *
 */
public class problema_2a_sort 
{
	/**
	 * Length
	 */
	public static int N = 0;
	/**
	 * First Array
	 */
	public static int arr1[];
	/**
	 * Second Array with N+1 reserved memory
	 */
	public static int arr2[];
	/**
	 * Element to be inserted
	 */
	public static int element = 0;
	/**
	 * Scanner that scan inputStream from keyboard
	 */
	public static Scanner in = new Scanner(System.in);
	/**
	 * In main are called Funcitions
	 * @param args
	 */
	public static void main(String[] args)
	{
		Input();
	}
	/**
	 * Function where we creating 2 array . First {@link #arr1} with N length and second {@link #arr2} with N+1 length.
	 * 1.Create First array, then we copy first array in second ..where remaing on cell on memory free. the {@link #element} that we will input we place
	 * in this cell and sort second array. Garbage collector will clear unused objects like {@link #arr1}.
	 */
	public static void Input()
	{
		System.out.printf("Array Length : ");
		N = in.nextInt();
		arr1 = new int[N];
		arr2 = new int[N+1];
		System.out.printf("Input Elements: ");
		for(int i=0; i<N;i++)
		{
			arr1[i] = in.nextInt();
		}
		//copy
		for(int i=0; i<N;i++)
		{
			arr2[i]=arr1[i];
		}
		System.out.printf("Array :");
		for(int i=0; i<N;i++)
		{
			System.out.printf("%d ",arr1[i]);
		}
		System.out.printf("\nEnter element: ");
		element = in.nextInt();
		arr2[N]=element;
		bubbleSort(arr2);
		System.out.printf("Array :\n");
		for(int i=0; i<arr2.length;i++)
		{
			System.out.printf("%d ",arr2[i]);
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
		System.out.printf("BubbleSort of array:\n");
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
}
