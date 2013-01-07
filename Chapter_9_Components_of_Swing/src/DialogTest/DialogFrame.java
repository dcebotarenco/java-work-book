package DialogTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Frame contine meniu, atunci cind alegem FILE=> About se afiseaza fereastra
 * @author Dan
 *
 */
public class DialogFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DialogFrame()
	{
		setTitle("DialogTest");
		setSize(WIDTH, HEIGHT);
		//Crearea menu FILE
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		//Adaugarea punctelor About si Exit
		//Cind alegem puntul About se afiseaza Fereastra de dialog
		
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(dialog == null) //prima data
				{
					dialog = new AboutDialog(DialogFrame.this);
				}
				dialog.setVisible(true);
			}
		});
		fileMenu.add(aboutItem);
		
		//La apasarea butonului EXIT programa se inchide
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
	}
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	
	private AboutDialog dialog;
}
