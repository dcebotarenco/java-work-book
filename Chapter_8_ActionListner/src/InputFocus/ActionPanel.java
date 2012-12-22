package InputFocus;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ActionPanel extends JPanel
{
	public ActionPanel()
	{
		//Gasirea Actiunilor
		Action yellowAction = new ColorAction("Yellow",new ImageIcon("yellow-ball.gif"),Color.YELLOW);
		Action blueAction = new ColorAction("Blue",new ImageIcon(".gif"),Color.BLUE);
		Action redAction = new ColorAction("Red",new ImageIcon(".gif"),Color.RED);
		
		//Butoanele ce sunt pt executarea operatiilor
		add(new JButton(yellowAction));
		add(new JButton(blueAction));
		add(new JButton(redAction));
		
		//Legarea butoanelor Y,B,R cu numele
		InputMap imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		
		imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		//Legarea NUmelelor cu actiunele
		ActionMap amap= getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue",blueAction);
		amap.put("panel.red",redAction);
	}
	public class ColorAction extends AbstractAction
	{
		/**
		 * Crearea actiuniei pentru a schimba culoarea
		 */
		public ColorAction(String name,Icon icon,Color c)
		{
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON,icon);
			putValue(Action.SHORT_DESCRIPTION,"Set panel to color "+ name.toLowerCase());
			putValue("color",c);
		}
		public void actionPerformed(ActionEvent event) 
		{
			Color c = (Color) getValue("color");
			setBackground(c);
			
		}

		
	}
	
}
