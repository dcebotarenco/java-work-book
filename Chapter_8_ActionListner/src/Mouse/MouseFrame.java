package Mouse;

import javax.swing.JFrame;

public class MouseFrame extends JFrame
{
	public MouseFrame()
	{
		setTitle("Mouse Test");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		//adaugarea panelului la frame
		MousePanel panel = new MousePanel();
		add(panel);
	}
	
	private static int DEFAULT_WIDTH = 300;
	private static int DEFAULT_HEIGHT = 200;
}
