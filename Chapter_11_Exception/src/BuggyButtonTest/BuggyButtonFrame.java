package BuggyButtonTest;

import javax.swing.JFrame;

public class BuggyButtonFrame extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BuggyButtonFrame()
	{
		setTitle("BuggyButtonFrame");
		setSize(width, height);
		
		//Adaugarea panelului la Frame
		BuggyButtonPanel panel = new BuggyButtonPanel();
		add(panel);
	}
	
	public static final int width = 300;
	public static final int height = 200;
}
