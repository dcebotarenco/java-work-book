package MailTest;

import javax.swing.JFrame;

/**
 * Aceasta programa demostreaza dolosirea soketurilor pentru trimiteerea emailurilo
 * @author Dan
 *
 */
public class MailTest
{
	public static void main(String[] args)
	{
		JFrame frame = new MailTestFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
