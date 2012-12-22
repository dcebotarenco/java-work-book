package Fill_2D_Draw;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
/**
 * Panel in care este desenat Dtreptunhiul
 * @author Dan
 *
 */
public class FillPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//Desenarea Dreptunchiului
		
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		
		Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
		g2.setPaint(Color.RED);
		g2.fill(rect);
		
		//Desenarea Elipsei, Inclusa in Dreptunghi
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		//albastru-verde
		g2.setPaint(new Color(0,128,128));
		g2.fill(ellipse);
	}
}
