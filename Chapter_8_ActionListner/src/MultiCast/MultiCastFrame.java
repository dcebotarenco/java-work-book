package MultiCast;

import javax.swing.*;

public class MultiCastFrame extends JFrame
{
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	public MultiCastFrame()	
	{
		setTitle("Multi Cast Test");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//adaugarea panelului la frame
		MultiCastPanel panel = new MultiCastPanel();
		add(panel);
	}
}
