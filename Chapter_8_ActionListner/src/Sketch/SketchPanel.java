package Sketch;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.*;

public class SketchPanel extends JPanel
{
	
	public SketchPanel()
	{
		last = new Point2D.Double(100,100);
		lines = new ArrayList<Line2D>();
		KeyHandler listner = new KeyHandler();
		addKeyListener(listner);
		setFocusable(true);
	}
	
	public void add(int dx,int dy)
	{
		Point2D end = new Point2D.Double(last.getX() + dx,last.getY()+dy);
		Line2D line = new Line2D.Double(last,end);
		lines.add(line);
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(Line2D l:lines)
		{
			g2.draw(l);
		}
	}
	private Point2D last;
	private ArrayList<Line2D> lines;
	private static final int SMALL_INCREMENT = 1;
	private static final int LARGE_INCREMENT = 5;
	
	private class KeyHandler implements KeyListener
	{

		
		public void keyPressed(KeyEvent event) 
		{
			int keyCode = event.getKeyCode();
			
			int d;
			if(event.isShiftDown())
			{
				d=LARGE_INCREMENT;
			}
			else
			{
				d=SMALL_INCREMENT;
			}
			
			if(keyCode == KeyEvent.VK_LEFT) add(-d,0);
			else if(keyCode == KeyEvent.VK_RIGHT) add(d,0);
			else if(keyCode == KeyEvent.VK_UP) add(0,-d);
			else if(keyCode == KeyEvent.VK_DOWN) add(0,d);
			
		}

		
		public void keyReleased(KeyEvent event) {}

		
		public void keyTyped(KeyEvent event) 
		{
			char KeyChar = event.getKeyChar();
			
			int d;
			if(Character.isUpperCase(KeyChar))
			{
				d = LARGE_INCREMENT;
				KeyChar = Character.toLowerCase(KeyChar);
			}
			else
				d=SMALL_INCREMENT;
			
			if(KeyChar == 'h') add(-d,0);
			else if(KeyChar == 'l') add(d,0);
			else if(KeyChar == 'k') add(0,-d);
			else if(KeyChar == 'j') add(0,d);
		}
		
	}
}
