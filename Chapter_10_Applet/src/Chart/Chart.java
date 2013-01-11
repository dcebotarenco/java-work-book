package Chart;

import javax.swing.JApplet;

public class Chart extends JApplet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init()
	{
		String v = getParameter("values");
		String title = getParameter("title");
		if(v == null) 
		{
			return;
		}
		int n = Integer.parseInt(v);
		double[] values = new double[n];
		String[] names = new String[n];
		
		for(int i=0; i<n; i++)
		{
			values[i] = Double.parseDouble(getParameter("value." + (i+1)));
			names[i] = getParameter("name." + (i+1));
		}
		
		add(new ChartPanel(values, names,title));
	}
}
