package Bounce;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Frame cu panel pentru afisarea bilei si butoanelor Start si Close
 * @author Dan
 *
 */
public class BounceFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BounceFrame()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Bounce");
		
		panel = new BallPanel();
		add(panel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel,"Start",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addBall();
			}
		});
		
		addButton(buttonPanel,"Cancel",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Adaugarea butonului la container
	 * @param c Container
	 * @param title Titlu
	 * @param listner Listner
	 */
	public void addButton(Container c,String title,ActionListener listner)
	{
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listner);
	}
	
	/**
	 * Pornirea Bilei in continutul panelului si organizarea lui in 1000 de miscari
	 */
	public void addBall()
	{
		try
		{
			Ball ball = new Ball();
			panel.add(ball);
			
			for(int i = 1; i<=STEPS;i++)
			{
				ball.move(panel.getBounds());
				panel.paint(panel.getGraphics());
				Thread.sleep(DELAY);
			}
			
			
		}
		catch (InterruptedException e)
		{
			
		}
	}
	
	private BallPanel panel;
	
	public static final int WIDTH = 450;
	public static final int HEIGHT = 350;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
}
