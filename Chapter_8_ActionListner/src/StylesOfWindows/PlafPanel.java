package StylesOfWindows;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlafPanel extends JPanel
{
	public PlafPanel()
	{
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info : infos)
		{
			makeButton(info.getName(),info.getClassName());
		}
	}
	
	/**
	 * Creaza buttoane,care schimba stilul
	 */
	void makeButton(String name,final String plafName)
	{
		//adaugarea buttoanelor in panel
		JButton button = new JButton(name);
		add(button);
		//Legarea buttonului cu Action
		button.addActionListener(new ActionListener() 
		{
			
			
			public void actionPerformed(ActionEvent event) 
			{
				try
				{
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlafPanel.this);
				}
				catch(Exception e) {e.printStackTrace();}
				
			}
		});
	}
}
