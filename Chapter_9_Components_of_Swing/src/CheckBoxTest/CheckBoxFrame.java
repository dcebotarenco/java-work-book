package CheckBoxTest;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class CheckBoxFrame extends JFrame
{
	public CheckBoxFrame()
	{
		setTitle("Check Box Test");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		CheckBoxPanel panel = new CheckBoxPanel();
		add(panel);
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
}
