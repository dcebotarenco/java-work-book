package InterruptibleSocketTest;

import javax.swing.JFrame;

/**
 * Aceasta programa demostreaza posibiliatea de a bloca socketul  in chanal
 * @author Dan
 *
 */
public class InterruptibleSocketTest 
{
	public static void main(String[] args)
	{
		JFrame frame = new InterruptibleSocketFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
