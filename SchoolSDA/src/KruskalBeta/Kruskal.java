package KruskalBeta;

/**
 * Kruskal algorithm is an algoritm in graph theory that finds a minimum spanning tree
 * for a connected weighted graph.This means it finds a subset of the edges that forms a tree
 * that inlcudes every vertex where the total weight of all the edges in the tree in minimized.
 * 		The algorithm consists in arranging by order of weight all of edges of the graph, then to withdraw
 * one by one, test if the last arc does not form a cycle, and add this to the final tree.
 * @author Dan
 *
 */
public class Kruskal 
{ 
	  public int numberOfNodes = 50; 
	  
	  public int numberOfEdges = numberOfNodes * numberOfNodes; 
	  public Arc[] tree = new Arc[numberOfNodes]; 
	  public int[] parent = new int[numberOfNodes];  
	  
	  /*
	   * In the constructor, we just do a call to the kruskal method with the missing parameters.
	   * Then we initialize the parent array at -1 for all the array of integer.
	   * This array will be used for testing if there cycles or not.
	   * Now we do a sort of the tree to have smallest arc in the beginning of the array.
	   * Then we do a loop going of 0 to a number of arcs or to number of nodes.We test if there is not a cycle, and if
	   * it is true we enter the arc on the final tree.
	   * When it finishes,we return if the temporary integer numberOfNodes - 1;
	   */
	  public Kruskal(Arc[] leaveTree ,int numberOfNodes,int numberOfArcs)
	  { 	  
		  kruskal(leaveTree,numberOfNodes,numberOfArcs,parent,tree); 
	  } 
	  
	  public void init(int[] t)
	  {  
		for (int i = 0; i < t.length; i++)
		{  
		     t[i] = -1; 
		} 
	  } 
	 public void triGraph(Arc[] t, int numbersOfArcs)
	 {  
		int j; 
		int k; 
		Arc a; 
		for (int i = 0; i < numbersOfArcs; i++)
		{ 
		    j = i; 
		    for (k = j; k < numbersOfArcs; k++)
		    { 
				if (t[k].getCost() < t[j].getCost())
					{ 
					    j = k; 
					} 
		    } 
		    a = t[j]; 
		    t[j] = t[i]; 
		    t[i] = a; 
		   } 
		   return; 
	} 
	  /*
	   * To test if there is a cycle on the tree, we use an integer array initialized with -1 for all of value.
	   * We call the cyclep method with this array and with the two vertices of the arc. We look on the array if the value stock
	   * on the array at the position of the first number is higher that 0, if yes we stock the number and start again with this
	   * new number for index array.When the value stock on the array at the position oof the first number is not higher that 0,
	   * we do same things with the second number.Whe the second loop is finish we test if the two new numbers are equals, if not we
	   * stock the second new number on the array ar the index of the first new number.We return Boolean corresponding at 
	   * first new number equals to second new number.If this Boolean is false, there do not have a cycle on the tree.
	   */
	public boolean cyclep(int[] t, int a, int b)
	{ 
		int i = a; 
		int j = b; 
		while (t[i] > 0) 
		{ 
		    i = t[i]; 
		}   
		while (t[j] > 0) 
		{ 
		    j = t[j]; 
		} 
		   
		if (i != j)
		{ 
		    t[i] = j; 
		} 
		return i != j; 
	} 
	  
	public boolean kruskal(Arc[] g, int numberOfNodes, int numberOfArcs,int[] parent,Arc[] tree) 
	{ 
	  init(parent); 
	  int numOfArcs = 0; 
	  int numOfNodes = 0; 
	  triGraph(g,numberOfArcs); 
	  while (numOfArcs < numberOfArcs && numOfNodes < numberOfNodes) 
	  { 
		if(cyclep(parent, g[numOfArcs].getNode1(), g[numOfArcs].getNode2())) 
		 { 
		    tree[numOfNodes] = g[numOfArcs]; 
		    numOfNodes++; 
		        
		 } 
		 numOfArcs++; 
	  } 
	  return numOfNodes == numberOfNodes - 1; 
	 } 
	} 