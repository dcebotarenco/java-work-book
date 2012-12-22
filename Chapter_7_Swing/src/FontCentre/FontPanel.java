package FontCentre;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class FontPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		String message = "Hello, World!";
		
		Font f = new Font("Serif",Font.BOLD,36);
		g2.setFont(f);
		//Gasirea dimensiunii mesajului
		
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(message, context);
		
		//Gasirea Coordonatelor unghiului sting de sus a mesajului
		double x = (getWidth() - bounds.getWidth())/2;
		double y = (getHeight() - bounds.getHeight())/2;
		
		//Pentru gasirea liniei de baza se foloseste inaltimea maximala
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		
		g2.drawString(message, (int)x, (int)y);
		g2.setPaint(Color.gray);
		
		//afisarea liniei de baza.
		g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));
		//Afisarea dreptunghiului de limita a textului
		Rectangle2D rect = new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
		g2.draw(rect);
	}
}
