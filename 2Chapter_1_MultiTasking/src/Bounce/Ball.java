package Bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Bila se misca si se respinge de granitza dreptunghiului
 * @author Dan
 *
 */
public class Ball 
{
	/**
	 * Miscarea bilei in urmatoarea pozitie.
	 * La atingerea de granitza isi schimba miscarea
	 */
	public void move(Rectangle2D bounds)
	{
		x = x + dx;
		y = y + dy;
		
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
	 * Obtinerea formei bilei in miscare
	 */
	public Ellipse2D getShape()
	{
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}
	
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
}
