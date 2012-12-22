package TextTest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class ClockPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double minutes = 0;
	private int RADIUS = 100;
	private double MINUTE_HAND_LENGTH = 0.8*RADIUS;
	private double HOUR_HAND_LENGHT = 0.6*RADIUS;
	public ClockPanel()
	{
		setPreferredSize(new Dimension(2*RADIUS+1 , 2*RADIUS+1));
	}
	
	public void paintComponent(Graphics g)
	{
		//desenarea marginii in forma de cerc
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(0, 0, 2*RADIUS, 2*RADIUS);
		g2.draw(circle);
		
		//desenarea sagetii a orei
		double hourAngle = Math.toRadians(90-360 * minutes / (12*60));
		drawHand(g2,hourAngle,HOUR_HAND_LENGHT);
		
		//desenarea sageteii a minutelor
		double minuteAngle = Math.toRadians(90-360 * minutes/60);
		drawHand(g2,minuteAngle,MINUTE_HAND_LENGTH);
	}
	
	public void drawHand(Graphics2D g2, double angle,double handLenght)
	{
		Point2D end = new Point2D.Double(RADIUS+handLenght*Math.cos(angle), RADIUS-handLenght*Math.sin(angle));
		Point2D center = new Point2D.Double(RADIUS,RADIUS);
		g2.draw(new Line2D.Double(center,end));
	}
	
	/**
	 * Adaugarea timpului.
	 * @param h ora
	 * @param m minute
	 */
	public void setTime(int h,int m)
	{
		minutes = h*60+m;
		repaint();
	}
}
