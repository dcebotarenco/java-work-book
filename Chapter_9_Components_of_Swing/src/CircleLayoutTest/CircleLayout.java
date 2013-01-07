package CircleLayoutTest;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

public class CircleLayout implements LayoutManager
{

	public void addLayoutComponent(String name, Component comp) {}
	public void removeLayoutComponent(Component comp) {}
	
	public void setSizes(Container parent)
	{
		if(sizesSet) return;
		
		int n = parent.getComponentCount();
		
		prefferedWidth = 0;
		prefferedHeight = 0;
		minWidth = 0;
		minHeight = 0;
		maxComponentWidth = 0;
		maxComponentHeight = 0;
		
		//Gasirea latimii si inaltimii componetului maxima
		//Marimea recomandata se pune ca suma marimilor
		
		for(int i =0; i<n;i++)
		{
			Component c = parent.getComponent(i);
			if(c.isVisible())
			{
				Dimension d = c.getPreferredSize();
				maxComponentWidth = Math.max(maxComponentWidth, d.width);
				maxComponentHeight = Math.max(maxComponentHeight, d.height);
				prefferedWidth += d.width;
				prefferedHeight += d.height;				
			}
		}
		minWidth = prefferedWidth/2;
		minHeight = prefferedHeight/2;
		sizesSet = true;
		
		
	}
	public Dimension preferredLayoutSize(Container parent) 
	{			
		setSizes(parent);
		Insets insets = parent.getInsets();
		int width = prefferedWidth + insets.left + insets.right;
		int height = prefferedHeight + insets.top + insets.bottom;
		return new Dimension(width,height);
	}
	
	public Dimension minimumLayoutSize(Container parent) 
	{
		setSizes(parent);
		Insets insets = parent.getInsets();
		int width = minWidth + insets.left + insets.right;
		int height = minHeight + insets.top + insets.bottom;
		return new Dimension(width,height);
	}
	
	public void layoutContainer(Container parent) 
	{
		setSizes(parent);
		
		//Gasirea centrului cercului
		
		Insets insets = parent.getInsets();
		int containerWidth = parent.getSize().width - insets.left - insets.right;
		int containerHeight = parent.getSize().height-insets.top - insets.bottom;
		
		int xCenter = insets.left + containerWidth/2;
		int yCenter = insets.top + containerHeight/2;
		
		//Gasirea radius cercului
		
		int xRadius = (containerWidth - maxComponentWidth) / 2;
		int yRadius = (containerHeight- maxComponentHeight)/2;
		int radius = Math.min(xRadius, yRadius);
		
		//Aplicarea componentelor pe cerc
		int n = parent.getComponentCount();
		
		for(int i = 0 ; i <n; i++)
		{
			Component c = parent.getComponent(i);
			if(c.isVisible())
			{
				double angle = 2*Math.PI * i / n;
				
				//Centrul componentului
				int x = xCenter + (int)(Math.cos(angle) * radius);			
				int y = yCenter + (int)(Math.sin(angle) * radius);
				
				//Componentele se asaza asa incit centrul sa fie in punctul x,y si marimile sa fie recomandabile
				Dimension d = c.getPreferredSize();
				c.setBounds(x-d.width/2, y-d.height/2, d.width, d.height);
			}
		}
	}


	

	

	
	
	private boolean sizesSet = false;
	private int minWidth = 0;
	private int minHeight = 0;
	private int prefferedWidth = 0;
	private int prefferedHeight = 0;
	private int maxComponentWidth = 0;
	private int maxComponentHeight = 0;
}
