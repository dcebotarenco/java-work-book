package RobotTest;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonPanel()
	{
		/*//Crearea Butoanelor		
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blur");
		JButton redButton = new JButton("Red");
		
		//Adaugarea buttoanelor in panel
		add(yellowButton);
		add(blueButton);
		add(redButton);
		
		//Crearea Action
		ColorAction yellowAction = new ColorAction(Color.yellow);
		ColorAction blueAction = new ColorAction(Color.blue);
		ColorAction redAction = new ColorAction(Color.red);
		
		//Legarea Action cu button		
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);*/
		makeButton("yellow",Color.yellow);
		makeButton("red", Color.red);
		makeButton("blue", Color.blue);
	}
	
	void makeButton (String name, final Color backGroundColor)
	{
		JButton button = new JButton(name);
		add(button);
		button.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent event) 
			{
				setBackground(backGroundColor);
				
			}
		});
		//ColorAction action = new ColorAction (backGroundColor);
	}
	/*private class ColorAction implements ActionListener 
	{
		private Color backgroundColor;
		public ColorAction(Color c)
		{
			backgroundColor = c;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			setBackground(backgroundColor);
		}
	}*/

}
