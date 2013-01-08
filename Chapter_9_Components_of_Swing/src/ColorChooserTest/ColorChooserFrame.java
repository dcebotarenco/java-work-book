package ColorChooserTest;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ColorChooserFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ColorChooserFrame()
	{
		setTitle("ColorChooserTest");
		setSize(WIDTH,HEIGHT);
		
		//Adaugarea panelului pentru a alege culoarea
		ColorChooserPanel panel = new ColorChooserPanel();
		add(panel, BorderLayout.CENTER);
	}
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	
	
}
