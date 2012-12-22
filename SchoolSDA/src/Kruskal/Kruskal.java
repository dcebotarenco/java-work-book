package Kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Class that cointains methods and for examening the Kruskal Algorith
 * @author Dan
 *
 */
public class Kruskal 
{
	/**
	 * Matrix where will be set values of Edges
	 */
	public static int[][] matrix;
	/**
	 * Scanner that scan Inputstream from keyboard
	 */
	public static Scanner in = new Scanner(System.in);
	/**
	 * Numbers of Nodes in Graph.
	 * Default it is set 0
	 */
	public static int Nodes = 0;
	/**
	 * Answer that enter user when he finish to enter Edges in Graph.
	 */
	public static String answer = "";
	/**
	 * Answer that enter user when he made a mistake on enternig edge under main diagonal
	 */
	public static String answer2 = "";
	/**
	 * Array where will be set all the objects
	 */
	public static Edge[] edge;
	/**
	 * List in where will be copied object from array edge
	 */
	public static List<Edge> edge2 = new ArrayList<Edge>();
	/**
	 * List from where will be removed unnecessary egdes
	 */
	public static List<Edge> edge4 = new ArrayList<Edge>();
	/**
	 * Array of edges temporary , set on 100
	 */
	public static Edge[] tempEdge = new Edge [100];
	/**
	 * Array where will be putted minim Edges for Graph
	 */
	public static List<Edge> MinimRoute = new ArrayList<Edge>();
	/**
	 * This variable count number of edges introduced in graph
	 */
	static int count = 0;
	/**
	 * In main are calles methods
	 * @param args
	 */
	public static void main(String[] args)
	{
		input();
		inputEdges();
		copyArray();
		printMatrix();
		printListEdge();
		
		processEdges();
		printRouteMin();
	}
	/**
	 * Input numbers of Nodes.
	 * Here is inicialized matrix [Node]x[Node], and completed with 0;
	 */
	public static void input()
	{
		System.out.println("How many nodes do you have?");
		Nodes = in.nextInt();

		matrix = new int[Nodes][Nodes];
		for(int i =0 ;i<Nodes;i++)
		{
			for(int j=0;j<Nodes;j++)
			{				
				matrix[i][j]=0;
			}
		}
	}
	/**
	 * Input Edges.What Node to What Node is pointed and the lenght between them
	 */
	public static void inputEdges()
	{
		int index =0 ; 
		System.out.println("What Node to what Node point and what is the lenght between Them");
		while(!answer.equals("No"))
		{		
			System.out.print("Node ");
			int i = in.nextInt();
			System.out.print("to Node ");
			int j = in.nextInt();
			System.out.print("Lenght between = ");
			int tmp = in.nextInt();
			tempEdge[index] = new Edge(i, j, tmp); //After introdusing values, is created object Edge and set it in array		
			validateEdge(i, j, tmp, index);
						
			count++;
			index++;
			
			System.out.print("Add new Node Yes/No ");
			answer = in.next();
			if(answer.equals("No")||answer.equals("no"))
			{
				break;
			}
		}		
	}
	public static void insertionSort(List<Edge> e) 
	{
		System.out.printf("Straight insertion Sort of array:\n ");
	    int i, j; 
	    Edge newValue = new Edge(0, 0, 0);
	    for (i = 1; i < e.size(); i++) 
	    {
	          newValue.copyEdge(e.get(i));
	          j = i;
	          while (j > 0 && e.get(j-1).getLenght() > newValue.getLenght())
	          {
	                e.get(j).copyEdge(e.get(j-1));
	                j--;
	          }
	          e.get(j).copyEdge(newValue);
	    }
	}
	public static void findCopyEdge(List<Edge> e)
	{
		
	}
	/**
	 * Method that on edge by edge call checkCycle method
	 */
	public static void processEdges()
	{
		insertionSort(edge2);
		for(int i=0;i<count;i++)
		{		
			checkCycle(edge2.get(i));		
		}
	}
	/**
	 * Method that control if node are under main diagonal
	 * @param i Start Node.
	 * @param j Finish Node.
	 * @param length Edge Length.
	 * @param index Index in array {@ #edge}.
	 */
	public static void validateEdge(int i,int j,int length,int index)
	{
		
		while(j<=i)
		{
			if(j<=i)
			{
				
				System.out.println("Node is Under de Diagonal of matrix..retry or type Done");
				System.out.print("Add new Node Yes or Done");
				answer2 = in.next();
				if(answer2.equals("Done"))
				{
					length=0;
					break;
				}
				System.out.print("Node ");
				i = in.nextInt();
				System.out.print("to Node ");
				j = in.nextInt();
				System.out.print("Lenght between = ");
				length = in.nextInt();
				while(length<=0)
				{
					System.out.println("Lenght must be >0!! retry\n");
					System.out.print("Lenght between = ");
					length=in.nextInt();
				}
				tempEdge[index].setStart(i);
				tempEdge[index].setFinish(j);
				tempEdge[index].setLenght(length);
				
			}
		}
		while(length<=0)
		{
			System.out.println("Lenght must be >0!! retry\n");
			System.out.print("Lenght between = ");
			length=in.nextInt();
		}
		
		matrix[i-1][j-1]=length;
	}
	/**
	 * Print Matrix with values of Edges
	 */
	public static void printMatrix()
	{
		System.out.print("\t");
		for(int i = 1;i<Nodes;i++)
		{
			System.out.printf("x%d\t",i);
		}
		System.out.printf("\n");
		
		
			for(int j = 0;j<Nodes;j++)
			{				
				System.out.printf("x%d\t",(j+1));
				for(int k =0 ;k<Nodes;k++)
				{
					System.out.print(matrix[j][k]+("\t"));
				}
				System.out.printf("\n");
			}
	}
	/**
	 * Method where array {@link #edge} if fulled with object by count.
	 * Here is creted list edge2 that copy elements from array edge.
	 * Also in edge4 are copyed elements from edge2
	 */
	public static void copyArray()
	{
		edge = new Edge[count];		
			for(int i = 0;i<count;i++)
			{
				edge[i]=new Edge(0, 0, 0);
			}
		
		for(int i=0;i<count;i++)
		{
			edge[i].copyEdge(tempEdge[i]);
		}
		edge2 = Arrays.asList(edge);
		
		for(int j=0;j<count;j++)
		{
			edge4.add(edge[j]);
		}
	}
	/**
	 * Print List of Edges (x,y)= lenght
	 */
	public static void printListEdge()
	{
		for(int i = 0;i<count;i++)
		{
			edge[i].printEdge();
		}
	}
	/**
	 * Fiind minimum lenght form Edge masive
	 */
	public static Edge findMinLenghtFromEdges()
	{
		Edge temporary = new Edge(0, 0, 0);

		
		
		for(int i=0;i<count;i++)
		{			
			temporary.copyEdge(edge2.get(i));				
		}

		
		return temporary;
		
	}
	
	/**
	 * Method where is creeted temp list. 2 boolean flags.We take from edge2 fist element and check if start and finish of edge
	 * is repeating somewhere in other finish of other objects also in same List.For exemple we have [(1,2=2)(1,3=3)(2,3=4)] 
	 * so here we have 2,3 where 2 is start and it is repeated in 1,2 , and 3 in 1,3. We take these 3 object find max by length 
	 * delete from edge4
	 * @param v Edge from edge2
	 */
	public static void checkCycle(Edge v)
	{

		List<Edge>temp = new ArrayList<Edge>();
		boolean foundStartflag = false;
		boolean foundFinishflag = false;
		Edge foundStart = new Edge(0, 0, 0);
		Edge foundFinish = new Edge(0, 0, 0);
	
		temp.add(v);
		
		

		System.out.println();
		
		for(int i=0; i<count;i++)
		{
		if(v.equalEdge(tempEdge[i]))
			{
				continue;
			}
			else
			{
				int vgetStart = v.getStart();
				int vgetFinish = v.getFinish();			
				int tgetStart = tempEdge[i].getStart();
				if(vgetStart == tgetStart)
				{
					foundStart.copyEdge(tempEdge[i]);					
					foundStartflag = true;
				}
				else if(vgetFinish == tgetStart)
				{
					foundFinish.copyEdge(tempEdge[i]);					
					foundFinishflag = true;
				}	
				
				if(foundStartflag && foundFinishflag)
				{
					
					temp.add(foundStart);
					temp.add(foundFinish);
					
					Edge tmp2 = new Edge(0, 0, 0);
					
					tmp2.copyEdge(sortByLengthMax(temp));
					System.out.println("tmp");tmp2.printEdge();
		
					/* for (Iterator<Edge> iter = edge4.iterator(); iter.hasNext();) 
					 {
					      Edge s = iter.next();
					      if (s.equalEdge(tmp2)) 
					      {
					        iter.remove();
					        break;
					      }					      
					 }	*/	
					for(int j=0;j<edge4.size();j++)
					{
						if (edge4.get(j).equalEdge(tmp2)) 
					      {
					        edge4.remove(j);
					        continue;
					      }	
					}
				}
			}
		}		
	}
/**
 * Method that return max element by lenght form 3 objects
 * @param temp List of 3 objects
 * @return Max element by lenght
 */
	public static Edge sortByLengthMax(List<Edge> temp)
	{
		int max=0;
		Edge temporary = new Edge(0, 0, 0);
		
		max = temp.get(0).getLenght();	
		temporary.copyEdge(temp.get(0));
		for(int i=0;i<temp.size()-1;i++)
		{
			
			if(temp.get(i+1).getLenght() > max)
			{
				max=temp.get(i+1).getLenght();
				temporary.copyEdge(temp.get(i+1));
			}
			
		}				
		return temporary;
	}
	/**
	 * Get Edge by lenght
	 * @param v minimum length getted in {@link #findMinLenghtFromEdges()}
	 * @return Edge by length
	 */
	public static Edge getEdge(int v)
	{
		Edge tmp = new Edge(0, 0, 0);
		for(int i=0;i<count;i++)
		{
			if(edge[i].getLenght()==v)
			{
				return edge[i];
			}
		}
		return tmp;
	}
/**
 * Print Edge remained in edge4.That is solution
 */
	public static void printRouteMin()
	{
		System.out.println("Mininal Tree");
		for(int i = 0;i<edge4.size();i++)
		{
			edge4.get(i).printEdge();
		}
	}
}
