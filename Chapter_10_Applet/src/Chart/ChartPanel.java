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
Panel ce deseneaza histograma
*/
public class ChartPanel extends JPanel
{ 
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/** 
    Constructor ChartPanel.
    @param v masivul de valori a histogramei
    @param n masivul de nume a valorilor din histograma
    @param t titlul
*/
public ChartPanel(double[] v, String[] n, String t)
{  
   names = n;
   values = v;
   title = t;
}

public void paintComponent(Graphics g)
{  
	   super.paintComponent(g);
	   Graphics2D g2 = (Graphics2D)g;
	
	   // gasirea valorilor mminim maxim
	   if (values == null) return;
	   double minValue = 0;
	   double maxValue = 0;
	   for (int i = 0; i < values.length; i++)
	   {  
	      if (minValue > values[i]) minValue = values[i];
	      if (maxValue < values[i]) maxValue = values[i];
	   }
	   if (maxValue == minValue) return;
	         
	   int panelWidth = getWidth();
	   int panelHeight = getHeight();
	   
	   Font titleFont = new Font("SansSerif", Font.BOLD, 20);
	   Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
	      
	   // gasirea latimii titlului
	   FontRenderContext context = g2.getFontRenderContext();
	   Rectangle2D titleBounds 
	      = titleFont.getStringBounds(title, context);
	   double titleWidth = titleBounds.getWidth();
	   double top = titleBounds.getHeight();
	
	   // desenarea titlului
	   double y = -titleBounds.getY();
	   double x = (panelWidth - titleWidth) / 2;
	   g2.setFont(titleFont);
	   g2.drawString(title, (float)x, (float)y);
	   
	   // latimea labelurilor
	   LineMetrics labelMetrics 
	      = labelFont.getLineMetrics("", context);
	   double bottom = labelMetrics.getHeight();
	
	   y = panelHeight - labelMetrics.getDescent();
	   g2.setFont(labelFont);
	
	   // mastabul si latimea benzilor
	   double scale = (panelHeight - top - bottom) 
	      / (maxValue - minValue);
	   int barWidth = panelWidth / values.length;
	
	   // desenarea benzilir
	   for (int i = 0; i < values.length; i++)
	   {  
	      // coordonatele dreprughiului
	      double x1 = i * barWidth + 1;
	      double y1 = top;
	      double height = values[i] * scale;
	      if (values[i] >= 0)
	         y1 += (maxValue - values[i]) * scale;
	      else
	      {  
	         y1 += maxValue * scale;
	         height = -height;
	      }
	
	      // implerea si desenarea conturului
	      Rectangle2D rect = new Rectangle2D.Double(x1, y1, 
	         barWidth - 2, height);
	      g2.setPaint(Color.RED);
	      g2.fill(rect);
	      g2.setPaint(Color.BLACK);
	      g2.draw(rect);
	      
	      // draw the centered label below the bar
	      Rectangle2D labelBounds 
	         = labelFont.getStringBounds(names[i], context);
	
	      double labelWidth = labelBounds.getWidth();
	      x = i * barWidth + (barWidth - labelWidth) / 2;
	      g2.drawString(names[i], (float)x, (float)y);
	   }
	}
	
	private double[] values;
	private String[] names;
	private String title;
}
