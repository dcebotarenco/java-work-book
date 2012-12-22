package set_probleme_1;
import java.util.*;
	/**
	 * @author Dan Cebotarenco , INfa 111.
	 * @version V 1.01
	 */
public class problema_2
{
	/**
	 * In main goes declarations of function.There also is initialized new Scanner Object for scanning 
	 * Input Stream from keyboard.
	 * @param arrayOfNums Int vector of 4 * int bits , that can carry 4 numbers.
	 * @param i index on each vector cell , it is used on entering 4 numbers.
	 * @param combs number of combs or arrangements used in programs .. In our case combs equals 3.
	 * @param n length of Int vector.
	 */
	public static void main(String[] args)
	{
		/**
		 * Scanning Input Stream from KeyBoard
		 */
		Scanner in = new Scanner(System.in);
		
		int[] arrayOfNums = new int[4];
		System.out.print("Enter Array:");
        for(int i=0;i<arrayOfNums.length;i++)
        {	                
        	arrayOfNums[i]=in.nextInt();	                
        } 
	        
	 int combs=3;  
	 int n=arrayOfNums.length;
	 	System.out.print("Permutations of your Array:\n");
	    permutationFunction(arrayOfNums,0,n);
	    
	    System.out.print("Arrangements of your Array in "+"[" +combs+"]" +"\n");
	    arrangementFunction(arrayOfNums,0,n,combs);
	    
	    System.out.print("Combinations of your Array in "+"[" +combs+"]" +"\n");
	    combinationFunction(arrayOfNums,0,n,combs);
	 
	}
	
	/**
	 * Dedicated for printiing an array in case that array is not <b>null</b>.In id is made a cicle 
	 * <b>For</b> for printing each item of vector </blockquote>.
	 * @param arr Array that need to be inputed in function<b>arrayPrint</b>.
	 * @param len Length of array that is called by function.
	 * @param i In cicle <b>For</b> it is a counter set on 0 and incremented on each interation.
	 */
	public static void arrayPrint(int arr[],int len)
	{
	    if (arr!=null)
	    {
	        for (int i=0; i<len; i++)
	        {
	            System.out.print(arr[i]+" ");
	        }
	        System.out.println("");
	    }
	}

	/**
	 * <blockquote>Traditional funciton of swaping two elements in an array.
	 * Function <b>swapFucntion is based on simple principle.Is declared a temporary variable </b></blockquote>.
	 * @param arr Array that is called by function.
	 * @param iIndex Index for first element to be swapped.
	 * @param jIndex Index for second element to be swapped.
	 * @param temp temporary variable that will substitute one of 2 variabiles. 
	 */
	public static void swapFunction(int arr[],int iIndex,int jIndex)
	{
	    int temp;
	    temp = arr[iIndex];
	    arr[iIndex] = arr[jIndex];
	    arr[jIndex] = temp;
	}
	/**
	 * Function for mooving back position to the last state of array 
	 * if in calling of one <b>permutationFucntion</b> , <b>arrengementFunction</b> or <b>combinationFunction</b> i >= start is false.
	 * In functio we create a temporary variable <b>tmp</b> where we put the <b>go</b> element. In for , on i = go up to len - 1 ,
	 * we copy in current array next element , in final we return back <b>tmp</b> element.
	 * @param arr Array that is inputed by user
	 * @param go Element from where need to moove to the last array state
	 * @param len Length of array that is called by function.
	 */

	public static void moveBackPos(int arr[],int go,int len)
	{
	    int tmp = arr[go];
	    for (int i=go; i<len-1; i++)
	    {
	        arr[i] = arr[i+1];
	    }  
	    arr[len-1] = tmp;
	}
	
	/**
	 * Permute an array and print it.It is started with a print of array (made as a function) then goes a 
	 * check of logical sentence <b>if (start&lt;len). In 2 For's is ruled <b>swapFunction</b> and <b>permutationFunction</b>
	 * at the end fisrt cicle we moveback state of array. </b>
	 * @param arr Array that is called by function and introduced by user.
	 * @param start Is a counter from where function need to start to make permutations.
	 * @param len Length of array that is called by function.
	 */
	public static void permutationFunction(int arr[],int start, int len)
	{
	    arrayPrint(arr,len);
	    if (start<len)
	    {
	        int i,j;
	        for(i=len-2; i>=start; i--)
	        {
	            for(j=i+1; j<len; j++)
	            {
	                swapFunction(arr,i,j);
	                permutationFunction(arr,i+1,len);
	            }
	            moveBackPos(arr,i,len);
	        }
	    }
	}
	/**
	 * Also as <b>arrangementFunction</b>is started with a print of array (made as a function) then goes a 
	 * check of logical sentence <b>if (start&lt;len) </b>, but as <b>len</b> we use variable <b>combs</b>.
	 * @param arr Array that is called by function and introduced by user.
	 * @param start Is a counter from where function need to start to make arrangements.
	 * @param len Length of array that is called by function.
	 * @param combs Number of elements to arrange.
	 */
	public static void arrangementFunction(int arr[],int start, int len, int combs){ 
	    arrayPrint(arr,combs);
	     if (start<len)
	    {
	        int i,j;
	        for(i=len-2; i>=start; i--)
	        {
	            for(j=i+1; j<len; j++)
	            {
	                swapFunction(arr,i,j);
	                arrangementFunction(arr,i+1,len,combs);
	            }
	            moveBackPos(arr,i,len);
	        }
	    }
	}
	/**
	 * Also as <b>arrangementFunction</b>is started with a print of array in function <b>arrayPrint()</b>.Thefore goes 2 For's in where will be 
	 * applied recursive call of this function.
	 * @param arr Array that is called by function and introduced by user.
	 * @param start Is a counter from where function need to start to make arrangements.
	 * @param len Length of array that is called by function.
	 * @param combs Number of elements to arrange.
	 */
	public static void combinationFunction(int arr[],int start, int len, int combs){ 
	    arrayPrint(arr,combs);
	     if (start<combs-2)
	    {
	        int i,j;
	        for(i=len-2; i>=start; i--)
	        {
	            for(j=i+1; j<combs; j++)
	            {
	                
	                moveBackPos(arr,i,len);
	                combinationFunction(arr,i+1,len-1,combs);
	            }
	           
	        }
	    }
	}   
}	 
