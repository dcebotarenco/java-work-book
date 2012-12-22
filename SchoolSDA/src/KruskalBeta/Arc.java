package KruskalBeta;

/**
 * Class of Arc.
 * Contains Start node,Finish node and length between them.
 * @author Dan
 *
 */
public class Arc
{ 
	 private int node1, node2, length; 
	 
	 public Arc(int node1, int node2, int length)
	 { 
	    
	   this.node1 = node1; 
	   this.node2 = node2; 
	   this.length = length; 
	 } 
	 public int getNode1()
	 { 
	   return node1; 
	 } 
	 public int getNode2()
	 { 
	   return node2; 
	 } 
	 public int getCost()
	 { 
	   return length; 
	 } 
	 public void setCost(int length)
	 { 
	   this.length=length; 
	 } 
}