package Bounce;

import javax.swing.JFrame;

/**
 * Imitarea miscarii bilei de biliard
 * @author Dan
 *
 */
public class Bounce 
{
	 public static void main(String[] args)
	 {
		 JFrame frame = new BounceFrame();
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
	 }
}
