package Chart;
/**
   @version 1.31 2002-07-06
   @author Cay Horstmann
*/

import java.awt.*;
import javax.swing.*;

public class Chart extends JApplet 
{  
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void init() 
   {  
      String v = getParameter("values");
      if (v == null) return;
      int n = Integer.parseInt(v);
      double[] values = new double[n];
      String[] names = new String[n];
      int i;
      for (i = 0; i < n; i++)
      {  
         values[i] = Double.parseDouble
            (getParameter("value." + (i + 1)));
         names[i] = getParameter("name." + (i + 1));
      }
      
      Container contentPane = getContentPane();
      contentPane.add(new ChartPanel(values, names, 
         getParameter("title")));
   }      
}   





