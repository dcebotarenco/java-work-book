package ToolBarTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * Frame ce contine panel cu intrumente
 * @author Dan
 *
 */
public class ToolBarFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBarFrame()
	{
		setTitle("ToolBarTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		//Adaugarea panelului cu schimbarea culorii
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
	     panel.setBackground(Color.blue);
		
		//Crearea obiectelor Action
		
		Action blueAction = new ColorAction("Blue", new ImageIcon("images/blue-ball.gif"), Color.BLUE);
		Action yellowAction = new ColorAction("Yellow", new ImageIcon("images/yellow-ball.gif"), Color.YELLOW);
		Action redAction = new ColorAction("Red", new ImageIcon("images/red-ball.gif"), Color.RED);
		Action exitAction = new AbstractAction("Exit", new ImageIcon("images/exit.gif")) 
		{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);			
			}
		};
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");
		//Completarea penelului cu intrumente
		
		JToolBar bar  = new JToolBar();
		bar.add(blueAction);
		bar.add(yellowAction);
		bar.add(redAction);
		bar.addSeparator();
		bar.add(exitAction);
		add(bar, BorderLayout.NORTH);
		
		//Completarea menului
		JMenu menu = new JMenu("Color");
		menu.add(yellowAction);
		menu.add(blueAction);
		menu.add(redAction);
		menu.addSeparator();
		menu.add(exitAction);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 250;
	
	private JPanel panel;
	
	public class ColorAction extends AbstractAction
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ColorAction(String name,Icon icon, Color c)
		{
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON,icon);
			putValue(Action.SHORT_DESCRIPTION, name + " background");
			putValue("Color", c);
		}
		
		public void actionPerformed(ActionEvent event)
		{		
			Color c = (Color) getValue("Color");
			panel.setBackground(c);
		}
	}
}
