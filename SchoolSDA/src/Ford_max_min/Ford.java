package Ford_max_min;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author Dan
 * Class that implements 2 algorithm Route Minim..Route Maxim
 */
public class Ford 
{
	Scanner in = new Scanner(System.in);
	int numberOfNodes = 0;
	int [] H;
	List<Arc> tree;
	List<Arc> finalTree = new ArrayList<Arc>();
	public Ford()
	{
		int choose=-1;
		menu();
		choose=in.nextInt();
		switch(choose)
		{
			case 1:	
			{
				enterList();			
				afisArcs();
				ford_min();
				solvef();
				break;
			}	
			case 2:
			{
				enterList();
				afisArcs();
				ford_max();
				solvef();
				break;
			}
			case 0:
			{
				break;
			}
		}
	}
	/**
	 * Print the result recursive
	 */
	public void solvef()
	{
		for(int i=finalTree.size()-1;i>=0;i--)
		{
			if(finalTree.get(i).getNodeFinish()==numberOfNodes)
			{
				recursAfis(finalTree.get(i));
				System.out.println();
			}
		}
	}
	/**
	 * Algorthm form minim
	 */
	public void ford_min()
	{
		int tmpRes = 0;
		boolean flag = false;
		initHmin();
		do
		{
			for(int i=0;i<tree.size();i++)
			{
				tmpRes = H[tree.get(i).getNodeFinish()]-H[tree.get(i).getNodeStart()];
				if(tmpRes > tree.get(i).getArcLength())
				{
					tree.get(i).setIsBig(true);	
					tree.get(i).setIsEqual(false);
					tree.get(i).setIsSmall(false);
					H[tree.get(i).getNodeFinish()]=tree.get(i).getArcLength() + H[tree.get(i).getNodeStart()];					
				}
				if(tmpRes == tree.get(i).getArcLength())
				{
					tree.get(i).setIsEqual(true);	
					tree.get(i).setIsSmall(false);
					tree.get(i).setIsBig(false);	
				}
				if(tmpRes < tree.get(i).getArcLength())
				{
					tree.get(i).setIsSmall(true);
					tree.get(i).setIsEqual(false);
					tree.get(i).setIsBig(false);	
				}
				
			}			
			flag=checkMin();
		}while(flag!=true);
		copyNodes();
	}
	 /**
	  * Algorithm ford maxim
	  */
	public void ford_max()
	{
		int tmpRes = 0;
		boolean flag = false;
		initHmax();
		do
		{
			for(int i=0;i<tree.size();i++)
			{
				tmpRes = H[tree.get(i).getNodeFinish()]-H[tree.get(i).getNodeStart()];
				if(tmpRes > tree.get(i).getArcLength())
				{
					tree.get(i).setIsBig(true);	
					tree.get(i).setIsEqual(false);
					tree.get(i).setIsSmall(false);
										
				}
				if(tmpRes == tree.get(i).getArcLength())
				{
					tree.get(i).setIsEqual(true);	
					tree.get(i).setIsSmall(false);
					tree.get(i).setIsBig(false);	
				}
				if(tmpRes < tree.get(i).getArcLength())
				{
					tree.get(i).setIsSmall(true);
					tree.get(i).setIsEqual(false);
					tree.get(i).setIsBig(false);
					H[tree.get(i).getNodeFinish()]=tree.get(i).getArcLength() + H[tree.get(i).getNodeStart()];
				}
				
			}			
			flag=checkMax();
		}while(flag!=true);
		copyNodes();
	}
	
	/**
	 * Method that check if node determined is Higher than Cij 
	 * @return
	 */
	public boolean checkMin()
	{		
		boolean tmp;
		tmp = true;
		for(int i = 0 ;i<tree.size();i++)
		{
			if(tree.get(i).getIsBig() == true)
			{
				tmp = false;
				break;
			}			
		}
		return tmp;
	}
	/**
	 * Method that check if node determined is Higher than Cij 
	 * @return
	 */
	public boolean checkMax()
	{		
		boolean tmp;
		tmp = true;
		for(int i = 0 ;i<tree.size();i++)
		{
			if(tree.get(i).getIsSmall() == true)
			{
				tmp = false;
				break;
			}			
		}
		return tmp;
	}
	/**
	 * Initialize  List of Nodes
	 */
	public void enterList()
	{
		System.out.println("How many Nodes do You Have? :");
		numberOfNodes = in.nextInt();
		H = new int[numberOfNodes+1];
		tree = new ArrayList<Arc>();
		System.out.println("Enter from what node to what node point and length (1 2 8) and 0 for next node else 1 to finish");
		int check = 0;
		while(check!=1)
		{
	label	:	{
				
				int start = in.nextInt();			
				int finish = in.nextInt();		
				int length = in.nextInt();
				while(length == 0)
				{
					System.out.println("lenght = 0");
					
					length = in.nextInt();
				}
				Arc tmp = new Arc();
				tmp.setNodeStart(start);
				tmp.setNodeFinish(finish);
				tmp.setArcLength(length);
				
				
				for(int i = 0;i<tree.size();i++)
				{
					if(tmp.equalsArc(tree.get(0)))
					{
						
						break label;
						
					}
				}
				tree.add(tmp);
				check = in.nextInt();
			}
		}	
	}
	/**
	 * Initialize array H with +inf
	 */
	public void initHmin()
	{
		H[1]=0;
		for(int i=2;i<H.length;i++)
		{
			H[i]=99999999; //inf
		}
	}
	/**
	 * Initialize array H with -inf
	 */
	public void initHmax()
	{
		H[1]=0;
		for(int i=2;i<H.length;i++)
		{
			H[i]=-99999999; //inf
		}
	}
	/**
	 * Print primitive Nodes
	 */
	public void afisArcs()
	{
		System.out.println("Nodes are :");
		for(int i=0;i<tree.size();i++)
		{
			System.out.println("Node"+(i+1)+":	"+tree.get(i).getNodeStart()+","+tree.get(i).getNodeFinish()+"="+tree.get(i).getArcLength());
		}
	}
	/**
	 * Nodes
	 */
	public void copyNodes()
	{
		
		for(int i=0;i<tree.size();i++)
		{
			if(tree.get(i).getIsEqual()==true)
			{
				finalTree.add(tree.get(i));
			}
		}
	}
	/**
	 * Recursive print solution
	 * @param e
	 */
	public void recursAfis(Arc e)
	{
		
		int x = 1;
		
		if(e.getNodeStart()==x)
		{
			System.out.print(e.getNodeStart());
		}
		else
		{			
				for(int i=0;i<finalTree.size();i++)
				{
					
					if(e.getNodeStart()==finalTree.get(i).getNodeFinish())
					{					
						recursAfis(finalTree.get(i));
					}
				}
		}
		System.out.print("-"+e.getNodeFinish());
	}
	/**
	 * Menu for user
	 */
	public void menu()
	{
		System.out.printf("Author: Cebotarenco Dan\n\n");
		System.out.printf("Choose an algorithm of Minim or Maxim Route:\n");
		System.out. printf(" \n 1 - Ford Minim \n 2 - Ford Maxim \n");
	}
}
