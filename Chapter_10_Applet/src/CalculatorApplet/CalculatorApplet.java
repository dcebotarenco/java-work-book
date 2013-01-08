package CalculatorApplet;

import javax.swing.JApplet;

public class CalculatorApplet extends JApplet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init()
	{
		CalculatorPanel panel = new CalculatorPanel();
		add(panel);
	}
}
