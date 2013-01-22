package Bounce2;

import javax.swing.JFrame;

/**
 * Afiseaza bila in miscare, ce deriva de la marginea dreptunghiului
 * @author Dan
 *
 */
public class BounceThread 
{
	public static void main(String[] args)
	{
		BounceFrame frame= new BounceFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
