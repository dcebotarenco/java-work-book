package Sketch;
import javax.swing.*;

public class SketchFrame extends JFrame
{
	public SketchFrame()
	{
		setTitle("Sketch");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		SketchPanel panel = new SketchPanel();
		add(panel);
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 400;
}
