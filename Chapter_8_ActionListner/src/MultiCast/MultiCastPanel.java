package MultiCast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Panel cu butoane pentru adaugarea si stergerea altor frame
 * @author Dan
 *
 */
public class MultiCastPanel extends JPanel
{
	public MultiCastPanel()
	{
		//Adaugarea butonului NEW
		JButton newButton = new JButton("New");
		add(newButton);
		final JButton closeAllButton = new JButton("Close all");
		add(closeAllButton);
		
		ActionListener newListner = new ActionListener() 
		{
			
			
			public void actionPerformed(ActionEvent event) 
			{
				BlankFrame frame = new BlankFrame(closeAllButton);
				frame.setVisible(true);
				
			}
		};
		
		newButton.addActionListener(newListner);
	}
}


