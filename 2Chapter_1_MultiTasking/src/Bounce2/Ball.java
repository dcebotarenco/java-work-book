package Bounce2;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Miscarea Bilei la irmatoarea pozitie.
 * La atingerea marginilor dreptunghiului miscare se schimba
 * @author Dan
 *
 */
public class Ball 
{
	public void move(Rectangle2D bounds,ArrayList<Ball> balls)
	{
		x += dx;
		y += dy;
		
		if(balls.size() > 1)
		{
			
			DIST=getDistance(balls);	
			if(DIST < XSIZE)
			{
				dx = -dx;
				dy = -dy;
			}
		}
		
		
		if(x < bounds.getMinX())
		{
			x = bounds.getMinX();
			dx = -dx;
		}
		if(x+XSIZE >= bounds.getMaxX())
		{
			x = bounds.getMaxX()-XSIZE;
			dx = -dx;
		}
		if(y < bounds.getMinY())
		{
			y = bounds.getMinY();
			dy = -dy;
		}
		if(y+YSIZE >= bounds.getMaxY())
		{
			y =bounds.getMaxY()-YSIZE;
			dy = -dy;
		}
	}
	
	/**
	 * Primirea formei bilei
	 */
	public Ellipse2D getShape()
	{
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}
	
	public Double getDistance(ArrayList<Ball> balls)
	{
		Double distance;
			distance = Math.sqrt( Math.pow(
					(balls.get(1).x - balls.get(0).x), 2)    
					+ Math.pow(
					(balls.get(1).y - balls.get(0).y), 2)    
					);
		return distance;
	}

	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	private double DIST = 0;
			
}
