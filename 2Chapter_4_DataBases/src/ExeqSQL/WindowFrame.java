package ExeqSQL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class WindowFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WindowFrame()
	{
		setTitle("ExecSQL");
		setSize(WIDHT, HEIGHT);
		
		//Menu
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		//Componente Menu principal
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		
		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		openItem.addActionListener(new SQLOpenListner());
		
		JMenuItem exitItem = new JMenuItem();
		fileMenu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		textArea = new JTextArea();
		add(textArea);
		
		chooser = new JFileChooser();
		//Filtru
		final ExtensionFileFilter filter = new ExtensionFileFilter();
		filter.addExtension("sql");
		chooser.setFileFilter(filter);
		
	}
	
	private class SQLOpenListner implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			chooser.setCurrentDirectory(new File("."));
			
			int result = chooser.showOpenDialog(WindowFrame.this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				File f = new File(chooser.getSelectedFile().getPath());
				try 
				{
					@SuppressWarnings("unused")
					SQLCommands s = new SQLCommands(f);
					boolean hasLine = true;
					while(hasLine)
					{
											
							textArea.append("Done");												
							hasLine=false;					
					}
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	public static final int WIDHT = 300;
	public static final int HEIGHT = 300;
	private JFileChooser chooser;
	private JTextArea textArea;
}
