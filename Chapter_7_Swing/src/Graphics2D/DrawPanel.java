package Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;


/**
 * 
 * @author Dan
 *Panelul in care for fi afisate Dreptunghiul si eclipsa
 */
public class DrawPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		//Desenarea Dreptunghiului
		
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		
		Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
		 g2.draw(rect);
		 
		 //Desenarea Elipsei inscrisa in dreptunghi
		 Ellipse2D ellipse = new Ellipse2D.Double();
		 ellipse.setFrame(rect);
		 g2.draw(ellipse);
		 //Desenarea Diagonalei
		 g2.draw(new Line2D.Double(leftX, topY, leftX+width,topY+height));
		 
		//Desenarea Cercului, centru caruia egal cu centru dreptungiului
		 double centerX = rect.getCenterX();
		 double centerY = rect.getCenterY();
		 double radius = 150;
		 
		 Ellipse2D circle = new Ellipse2D.Double();
		 circle.setFrameFromCenter(centerX, centerY,centerX+radius,centerY+radius);
		 g2.draw(circle);
		 
	}
}
