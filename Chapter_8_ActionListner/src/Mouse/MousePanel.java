package Mouse;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MousePanel extends JPanel
{
	public MousePanel()
	{
		squares = new ArrayList<Rectangle2D>();
		current = null;
		
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//desenarea tuturor patratelor
		for(Rectangle2D r: squares)
		{
			g2.draw(r);
		}
	}
	/**
	 * Gasirea primului patrat, care are punctul necesar
	 * @param p puntul
	 * @return primul patrat, ca ara puntul p
	 */
	public Rectangle2D find(Point2D p)
	{
		for(Rectangle2D r:squares)
		{
			if(r.contains(p)) return r;
		}
		return null;
	}
	/**
	 * Adaugarea patratutlui la centru
	 * @param p centru patratului
	 */
	public void add(Point2D p)
	{
		double x = p.getX();
		double y = p.getY();
		
		current = new Rectangle2D.Double(x-SIDELENGHT/2,y-SIDELENGHT/2,SIDELENGHT,SIDELENGHT);
		squares.add(current);
		repaint();
	}
	/**
	 * Stergetrea unui patrat din multime
	 * @param s Patratul care trenbue de sters
	 */
	public void remove(Rectangle2D s)
	{
		if(s == null) return;
		if(s == current) current = null;
		squares.remove(s);
		repaint();
	}
	
	private static final int SIDELENGHT = 10;
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;
	
	/**
	 * Patratutl in limitele caruia se afla cursorul.
	 */
	private class MouseHandler extends MouseAdapter
	{
		public void mousePressed(MouseEvent event)
		{
			//daca cursorul este peste toti patratii sa adauga un nou patrat
			current = find(event.getPoint());
			if(current == null)
				add(event.getPoint());
		}
		
		public void mouseClicked(MouseEvent event)
		{
			//dupa dublu click ..patratul curent se sterge
			current = find(event.getPoint());
			if(current != null && event.getClickCount() >=2 )
			{
				remove(current);
			}
		}
	}
	
	private class MouseMotionHandler implements MouseMotionListener
	{

	
		public void mouseDragged(MouseEvent event) 
		{
			if(current != null)
			{
				int x=event.getX();
				int y=event.getY();
				//Schimbarea prin apucare a patratului in punctul x,y
				current.setFrame(x-SIDELENGHT/2,y-SIDELENGHT/2,SIDELENGHT,SIDELENGHT);
				repaint();
			}
			
		}

		//Daca cursorul este in limita patratului , el ea forma de cruce
		public void mouseMoved(MouseEvent event )
		{
			
			if(find(event.getPoint()) == null)
				setCursor(Cursor.getDefaultCursor());
			else
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			
		}
		
	}
}
