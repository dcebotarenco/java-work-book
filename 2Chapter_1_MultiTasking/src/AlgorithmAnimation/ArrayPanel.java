package AlgorithmAnimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

/**
 * Acest Panel afiseaza masivul, semalind 2 din elementele lui
 * @author Dan
 *
 */
public class ArrayPanel extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g)
	{
		if(values == null) return;
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		int width = getWidth() / values.length;
		for(int i=0; i<values.length;i++)
		{
			double height = values[i]*getHeight();
			Rectangle2D bar = new Rectangle2D.Double(width*i,0,width,height);
			if(values[i] == marked1 || values[i] == marked2)
			{
				g2.fill(bar);
			}
			else
				g2.draw(bar);
		}
	}
	
	/**
	 * Seteaza valorile pentru afisare
	 * @param values Masiv de valori pentru afisaer
	 * @param marked1 Primul element markat
	 * @param marked2 Al doilea element markat
	 */
	public void setValues(Double[] values,Double marked1,Double marked2)
	{
		this.values = values;
		this.marked1 = marked1;
		this.marked2 = marked2;
		repaint();
	}
	private Double[] values;
	private Double marked1;
	private Double marked2;
}
