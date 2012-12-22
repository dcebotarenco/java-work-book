package StylesOfWindows;
import javax.swing.*;

public class PlafFrame extends JFrame
{
	public static final int DEFAULT_WIGHT = 300;
	public static final int DEFAULT_HEIGHT = 200;
	public PlafFrame()
	{
		setTitle("PlafTest");
		setSize(DEFAULT_WIGHT,DEFAULT_HEIGHT);
		PlafPanel panel = new PlafPanel();
		add(panel);
	}
}
