package BuggyButtonTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BuggyButtonPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuggyButtonPanel()
	{
		ActionListener listner = new ButtonListner();
		
		JButton yellowButton = new JButton("Yellow");
		add(yellowButton);
		yellowButton.addActionListener(listner);
		
		JButton blueButton = new JButton("Blue");
		add(blueButton);
		blueButton.addActionListener(listner);
		
		JButton redButton = new JButton("Red");
		add(redButton);
		redButton.addActionListener(listner);
	}
	
	private class ButtonListner implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String arg = e.getActionCommand();
			if(arg.equals("Yellow"))
			{
				setBackground(Color.YELLOW);
			}
			else if(arg.equals("Blue"))
			{
				setBackground(Color.BLUE);
			}
			else if(arg.equals("Red"))
			{
				setBackground(Color.RED);
			}
		}
		
	}
}
