package DataExchangeTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DataExchangeFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataExchangeFrame()
	{
		setTitle("DataExchangeTest");
		setSize(WIDTH,HEIGHT);
		
		//Crearea Menu File
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		//Crearea Punctelor Connect si Exit
		
		JMenuItem connectItem = new JMenuItem("Connect");
		connectItem.addActionListener(new ConnectAction());
		fileMenu.add(connectItem);
		
		//La activarea puntului Exit programa se inchide
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		
		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public static final int WIDTH = 200;
	public static final int HEIGHT = 150;
	
	private PasswordChooser dialog = null;
	private JTextArea textArea;
	
	private class ConnectAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//La primul click se creaza fereastra de dialog
			
			if(dialog == null)
			{
				dialog = new PasswordChooser();
			}
			
			//Punearea valorilor inplicite
			dialog.setUser(new User("yourName",null));
			
			//Afisarea ferestrei de dialog
			if(dialog.showDialog(DataExchangeFrame.this, "Connect"))
			{
				//Daca utilizatorul a confirmat intratrile ele se folosesc in programa
				User u = dialog.getUser();
				textArea.append("username = " + u.getName() + ", password = "+ (new String(u.getPassword()))+ "\n");
			}
		}
		
	}
	
}
