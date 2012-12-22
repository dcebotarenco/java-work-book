package Laborator_2_sort;

import java.util.Scanner;
/**
 * 
 * @author Dan Cebotarenco
 *<blockquote>Program with 2 variants of Deleting an element from an array<blockquote>
 */
public class problema_2b_sort
{
	/**
	 * Array length
	 */
	public static int N = 0;
	/**
	 * Array where first elements will be stored
	 */
	public static int[] arr;
	/**
	 * Final Array 
	 */
	public static int[] arr2;
	/**
	 * Variants for menu of deleting variants
	 */
	public static int choice =0;
	/**
	 * Scanner that scan inputStream from keyboard
	 */
	public static Scanner in = new Scanner(System.in);
	/**
	 * Main contains a swith of choices depending of user. Here are also called other funcitons.
	 * @param args Console
	 */
	public static void main(String[] args)
	{
		String answer = "Da";
		while(answer.equals("Da"))
		{
			inputArray();
			printArray(arr);
			menu();
			choice = in.nextInt();
			switch(choice)
			{
			case 1: {deleteByIndex(getIndex());printArray(arr2);break;}
			case 2: {deleteByValue(getValue());printArray(arr2);break;}
			default : {deleteByIndex(getIndex());printArray(arr2);break;}
			}
			System.out.printf("\nRetry? (Da/Nu)");
			answer = in.next();
		}
	}
	/**
	 * Compose an Array.Input length {@link #N} and elements.
	 */
	public static void inputArray()
	{
		System.out.printf("Compose an Array\nEnter length of Array:");
		N=in.nextInt();
		arr= new int[N];
		arr2=new int[N-1];
		System.out.printf("Enter Elements:");
		for(int i =0;i<N;i++)
		{
			arr[i] = in.nextInt();
		}
		
	}
	/**
	 * Print Elements of an Array.
	 * @param arr1 Array to be Printed.
	 */
	public static void printArray(int[] arr1)
	{
		System.out.printf("Array:");
		for(int i=0; i<arr1.length;i++)
		{
			System.out.printf("%d ",arr1[i]);
		}
	}
	/**
	 * Function that delete an element from an array by index.
	 * @param index variable inputed by user
	 */
	public static void deleteByIndex(int index)
	{
		
		for(int i=index; i<arr.length-1;i++)
		{
				arr[i]=arr[i+1];	
		}

		for(int i=0; i<arr2.length;i++)
		{
			arr2[i] = arr[i];
		}
	}
	/**
	 * Function that delete an element from an array by value.
	 * @param value variable inputed by user
	 */
	public static void deleteByValue(int value)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==value)
			{
				deleteByIndex(i);
			}			
		}
		for(int i=0; i<arr2.length;i++)
		{
			arr2[i] = arr[i];
		}
	}
	/**
	 * Printig variants for deleting
	 */
	public static void menu()
	{
		System.out.printf("\nChoose Type of deleting an element:\n1.By index.\n2.By value");
	}
	/**
	 * Input an index for deleting from array.
	 * @return index of element inputed.
	 */
	public static int getIndex()
	{
		System.out.println("Enter Index :");
		int index = in.nextInt();
		return index;
	}
	/**
	 * Input a value for deleting from array.
	 * @return value on element inputed.
	 */
	public static int getValue()
	{
		System.out.println("Enter Value :");
		int value = in.nextInt();
		return value;
	}
}
