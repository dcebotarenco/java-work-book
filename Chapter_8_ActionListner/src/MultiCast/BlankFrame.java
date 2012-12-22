package MultiCast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BlankFrame extends JFrame
{
	private ActionListener closeListner;
	public static final int DEFAULT_WIDTH = 200;
	public static final int DEFAULT_HEIGHT= 150;
	public static final int SPACING = 40;
	private static int counter = 0;
	public BlankFrame(final JButton closeButton)
	{
		
		counter++;
		setTitle("Frame "+ counter);
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setLocation(SPACING * counter,SPACING*counter);
		
		closeListner = new ActionListener()
		{
			
			
			public void actionPerformed(ActionEvent e) 
			{
				closeButton.removeActionListener(closeListner);
				dispose();			
			}
		};
		closeButton.addActionListener(closeListner);
	}
}