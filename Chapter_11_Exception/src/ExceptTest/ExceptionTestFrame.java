package ExceptTest;

import javax.swing.JFrame;

/**
 * Frame cu panel pentru testarea diferitor exceptii
 * @author Dan
 *
 */
public class ExceptionTestFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionTestFrame()
	{
		setTitle("ExceptionTest");
		ExceptionTestPanel panel = new ExceptionTestPanel();
		add(panel);
		pack();
	}
}
