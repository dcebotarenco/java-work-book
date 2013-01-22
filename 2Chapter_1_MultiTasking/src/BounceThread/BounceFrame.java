package BounceThread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
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
		setTitle("BounceThread");
		setSize(WIDTH, HEIGHT);
		
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
		addButton(buttonPanel, "Close", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Adaugarea Buttoanelor la container
	 */
	public void addButton(Container c, String title,ActionListener listner)
	{
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listner);
	}
	/**
	 * Adaugarea bilei pe panel si startarea Thread, ce contine miscarea si respingerea
	 */
	public void addBall()
	{
		Ball b = new Ball();
		panel.add(b);
		Runnable r = new BallRunnable(b,panel);
		Thread t = new Thread(r);
		t.start();
	}
	private BallPanel panel;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
}
