package Chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 * Panel cu histograma
 * @author Dan
 *
 */
public class ChartPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor ChartPanel
	 * @param v masiv de valori a histogramei
	 * @param n masiv de labeluri a histogramei
	 * @param t titlu histogramei
	 */
	public ChartPanel(double[] v, String[] n, String t)
	{
		values = v;
		names = n;
		title = t;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//Gasirea valorii minime si maxime 
		if(values == null) return;
		double minValue = 0;
		double maxValue = 0;
		for(double v : values)
		{
			if(minValue > v) minValue = v;
			if(maxValue < v) maxValue = v;
		}
		if(maxValue==minValue) return;
		
		int panelWidth = getWidth();
		int panelHeight = getHeight();
		
		Font titleFont = new Font("SansSerif",Font.BOLD,20);
		Font labelFont = new Font("SansSerif",Font.PLAIN,10);
		
		//gasirea marimii titlului
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D titleBounds = titleFont.getStringBounds(title, context);
		
		double titleWidth = titleBounds.getWidth();
		double top = titleBounds.getHeight();
		
		//Afisarea titlului
		double y = -titleBounds.getY();
		double x = (panelWidth - titleWidth) /2;
		g2.setFont(titleFont);
		g2.drawString(title, (float)x, (float)y);
		
		//Gasirea marimilor labelurilor histogramei
		LineMetrics labelMetrics = labelFont.getLineMetrics("", context);
		double bottom = labelMetrics.getHeight();
		
		y = panelHeight - labelMetrics.getDescent();
		g2.setFont(labelFont);
		
		//Gasirea mastabului si latimii benzilor
		double scale = (panelHeight-top-bottom) / (maxValue - minValue);
		int barWidth = panelWidth/values.length;
		
		//Afisarea bbenzilor
		for(int i = 0; i<values.length;i++)
		{
			//gasirea coordonatelor dreptunghiurilor
			double x1 = i*barWidth + 1;
			double y1 = top;
			double height = values[i] * scale;
			if(values[i] >= 0)
			{
				y1 += (maxValue - values[i]) * scale;
			}
			else
			{
				y1 += maxValue * scale;
				height = -height;
			}
			
			//Umplerea cu culoare si desenarea conturului
			Rectangle2D rect = new Rectangle2D.Double(x1,y1,barWidth-2,height);
			g2.setPaint(Color.RED);
			g2.fill(rect);
			g2.setPaint(Color.BLACK);
			g2.draw(rect);
			
			//Desenarea labelurilor, aranjarea pe centru
			Rectangle2D labelBounds = labelFont.getStringBounds(names[i], context);
			
			double labelWidth = labelBounds.getWidth();
			x=x1+(barWidth - labelWidth) /2;
			g2.drawString(names[i], (float)x,(float)y);
		}
	}
	
	private double[] values;
	private String[] names;
	private String	title;
}
