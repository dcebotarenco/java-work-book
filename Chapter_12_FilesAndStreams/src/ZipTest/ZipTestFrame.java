package ZipTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.Extension;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Frame cu textarea, pentru afisarea cintinutului a unui zipArhiv, cu o lista de alege un file 
 * si menu pentru a alege alt zipArhiv.
 * @author Dan
 *
 */
public class ZipTestFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ZipTestFrame()
	{
		setTitle("ZipTest");
		setSize(WIDTH, HEIGHT);
		
		//Adaugarea cimpului MEnu si puntelor Open,Exit
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new OpenAction());
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		//Adaugarea TextArea si listei
		fileText = new JTextArea();
		fileCombo = new JComboBox<String>();
		
		fileCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				loadZipFile((String) fileCombo.getSelectedItem());
			}
		});
		
		add(fileCombo, BorderLayout.SOUTH);
		add(new JScrollPane(fileText),BorderLayout.CENTER);
	}
	public static final int WIDTH = 400;
	public static final int HEIGHT=300;
	
	private JTextArea fileText;
	private JComboBox<String> fileCombo;
	private String zipname;
	
	/**
	 * Listner pentru punctul FIle>Open
	 */
	private class OpenAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Fereastra pentru alegerea arhivului
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			
			ExtensionFileFilter filter = new ExtensionFileFilter();
			filter.addExtension(".zip");
			filter.addExtension(".jar");
			filter.setDescription("ZIP archives");
			chooser.setFileFilter(filter);
			int r = chooser.showOpenDialog(ZipTestFrame.this);
			if( r == JFileChooser.APPROVE_OPTION)
			{
				zipname = chooser.getSelectedFile().getPath();
				scanZipFile();
			}
		}
		
	}
	
	/**
	 * Metoda pentru a vedea continutul din lista
	 */
	public void scanZipFile()
	{
		fileCombo.removeAllItems();
		try
		{
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
			ZipEntry entry;
			while((entry = zin.getNextEntry()) != null)
			{
				fileCombo.addItem(entry.getName());
				zin.closeEntry();
			}
			zin.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Afisarea filului din arhic in textarea
	 * @param name Numele din arhiv
	 */
	public void loadZipFile(String name)
	{
		try
		{
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
			ZipEntry entry;
			fileText.setText("");
			//Gasirea elemenutului care egal cu numele
			while((entry = zin.getNextEntry()) !=null)
			{
				if(entry.getName().equals(name))
				{
					//Citirea filului si afisarea cintinutului in TextArea
					BufferedReader in = new BufferedReader(new InputStreamReader(zin));
					String line;
					while((line = in.readLine()) != null)
					{
						fileText.append(line);
						fileText.append("\n");
					}
				}
				zin.closeEntry();
			}
			zin.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
