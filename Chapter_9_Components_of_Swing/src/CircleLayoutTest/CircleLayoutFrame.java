package CircleLayoutTest;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Clasa in care butoanele se for aranja in forma de cerc
 * @author Dan
 *
 */
public class CircleLayoutFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CircleLayoutFrame()
	{
		setTitle("Circle_Frame");
		Container contentPane = getContentPane();
	      contentPane.setLayout(new CircleLayout());
	      contentPane.add(new JButton("Yellow"));
	      contentPane.add(new JButton("Blue"));
	      contentPane.add(new JButton("Red"));
	      contentPane.add(new JButton("Green"));
	      contentPane.add(new JButton("Orange"));
	      contentPane.add(new JButton("Fuchsia"));
	      contentPane.add(new JButton("Indigo"));
	}
}	
	

