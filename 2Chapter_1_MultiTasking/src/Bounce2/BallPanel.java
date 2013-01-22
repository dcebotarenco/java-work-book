package Bounce2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Panel, pe care va fi afisate bilele
 * @author Dan
 *
 */
public class BallPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Adaugarea bilei pe panel
	 * @param b Bila.
	 */
	public void add(Ball b)
	{
		balls.add(b);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		for(Ball b: balls)
		{
			g2.fill(b.getShape());
		}
	}
	
	public void makeZero()
	{
		balls.clear();
	}
	private static ArrayList<Ball> balls = new ArrayList<Ball>();
}
