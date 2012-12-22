package Kruskal;
/**
 * Class that implemets Object Edge with values start from node,finish at node , with some length
 * @author Dan
 *
 */
public class Edge
{
	private int start = 0;
	private int finish = 0;
	private int lenght = 0;
	
	/**
	 * 
	 * @param start start node
	 * @param finish finish node
	 * @param lenght lenght between these 2 nodes
	 */
	public Edge(int start,int finish,int lenght)
	{
		this.start = start;
		this.finish = finish;	
		this.lenght = lenght;
	}
	/**
	 * get start node
	 * @return start int
	 */
	public int getStart()
	{
		return this.start;
	}
	/**
	 * get finish node
	 * @return finish int
	 */
	public int getFinish()
	{
		return this.finish;
	}
	/**
	 * get length between nodes
	 * @return length int
	 */
	public int getLenght()
	{
		return this.lenght;
	}
	/**
	 * set finish
	 * @param finish
	 */
	public void setFinish(int finish)
	{
		this.finish = finish;
	}
	/**
	 * set start
	 * @param start
	 */
	public void setStart(int start)
	{
		this.start = start;
	}
	/**
	 * set lenght
	 * @param lenght
	 */
	public void setLenght(int lenght)
	{
		this.lenght = lenght;
	}
	/**
	 * Print one Edge
	 */
	public void printEdge()
	{
		System.out.printf("(%d,%d)=%d\n",start,finish,lenght);
	}
	/**
	 * Copy and edge to another
	 * @param e edge
	 */
	public void copyEdge(Edge e)
	{ 
		
		this.finish = e.getFinish();
		this.lenght = e.getLenght();
		this.start = e.getStart();

	}
	/**
	 * Check if 2 edges are equal
	 * @param e edge
	 * @return true or false
	 */
	public boolean equalEdge(Edge e)
	{
		boolean flag = false;
			if(this.start == e.getStart() && this.finish==e.getFinish() && this.lenght == e.getLenght())
			{
				flag = true;
			}
		return flag;
	}
}
