package Ford_max_min;

public class Arc 
{
	private int nodeStart=0;
	private int nodeFinish=0;
	private int length=0;
	private boolean isBig = false;
	private boolean isEqual = false;
	private boolean isSmall = false;

	public Arc()
	{
		
	}
	public Arc(int nodeStart,int nodeFinish,int length)
	{
		this.nodeStart=nodeStart;
		this.nodeFinish=nodeFinish;
		this.length=length;
	}
	public int getNodeStart()
	{
		return nodeStart;
	}
	public int getNodeFinish()
	{
		return nodeFinish;
	}
	public int getArcLength()
	{
		return length;
	}
	public boolean getIsBig()
	{
		return isBig;
	}
	public boolean getIsEqual()
	{
		return isEqual;
	}
	public boolean getIsSmall()
	{
		return isSmall;
	}
	public void setNodeStart(int start)
	{
		this.nodeStart=start;
	}
	public void setNodeFinish(int finish)
	{
		this.nodeFinish=finish;
	}
	public void setArcLength(int length)
	{
		this.length=length;
	}
	public void setIsBig(boolean f)
	{
		this.isBig = f;
	}
	public void setIsEqual(boolean f)
	{
		this.isEqual = f;
	}
	public void setIsSmall(boolean f)
	{
		this.isSmall = f;
	}
	public boolean equalsArc(Arc e)
	{
		boolean flag = false;
		if(this.nodeStart == e.getNodeStart() && this.nodeFinish==e.getNodeFinish() && this.length==e.getArcLength())
		{
			flag = true;
		}
		return flag; 
	}
	
}
