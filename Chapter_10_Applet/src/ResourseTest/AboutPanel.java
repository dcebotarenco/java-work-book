package ResourseTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Panel cu Text Area si butotn About.Dupa click pe button text Area se unple cu text luat din resursa
 * @author Dan
 *
 */
public class AboutPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AboutPanel()
	{
		setLayout(new BorderLayout());
		//Adaugarea Text Area
		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		//Adaugarea buttonului About
		URL aboutURL = AboutPanel.class.getResource("image/about.gif");
		JButton aboutButton = new JButton("About",new ImageIcon(aboutURL));
		aboutButton.addActionListener(new AboutAction());
		add(aboutButton, BorderLayout.SOUTH);
	}
	
	private JTextArea textArea;
	
	private class AboutAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			InputStream stream = AboutPanel.class.getResourceAsStream("data/about.txt");
			Scanner in = new Scanner(stream);
			while(in.hasNext())
			{
				textArea.append(in.nextLine() + "\n");
			}
		}
		
	}

}
