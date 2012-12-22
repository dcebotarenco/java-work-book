package InputFocus;

import javax.swing.JFrame;

/**
 * Frame cu panel ce schimba culoarea
 * @author Dan
 *
 */
public class ActionFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	public ActionFrame()
	{
		setTitle("ActionTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		ActionPanel panel = new ActionPanel();
		add(panel);
	}
}
