package JavaWebStart;

import javax.swing.JFrame;

/**
 * Frame cu panelul care contine calculatorul
 * @author Dan
 *
 */
public class CalculatorFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculatorFrame()
	{
		setTitle("Calculator");
		CalculatorPanel panel = new CalculatorPanel();
	
		add(panel);
		pack();
	}
}
