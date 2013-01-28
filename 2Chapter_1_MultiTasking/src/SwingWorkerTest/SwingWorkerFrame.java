package SwingWorkerTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * In acest frame se cintine TextArea, pentru afisarea continutului uni fisier,menu
 * - care permite sa deschizi fisier sau sai dai cancel la procesul de incarcare
 * ,si cimpului de statuc,in care se afiseaza procesul de incarcare.
 * @author Dan
 *
 */
public class SwingWorkerFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SwingWorkerFrame()
	{
		setTitle("SwingWorkerFrame");
		
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		textArea = new JTextArea();
		add(new JScrollPane(textArea));
		setSize(WIDTH, HEIGHT);
		
		statusLine = new JLabel();
		add(statusLine, BorderLayout.SOUTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//Fereastra de dialog pentru alegerea fisierului
				int result = chooser.showOpenDialog(null);
				
				//Daca fisierul este ales,se afiseaza pictograma
				if(result == JFileChooser.APPROVE_OPTION)
				{
					readFile(chooser.getSelectedFile());
				}
			}
		});
		
		cancelItem = new JMenuItem("Cancel");
		menu.add(cancelItem);
		cancelItem.setEnabled(false);
		cancelItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(workerThread != null) workerThread.interrupt();
			}
		});
	}
	
	/**
	 * Citirea fisierului in regim asihrin, in process citirea face refresh la interfata.
	 */
	public void readFile(final File file)
	{
		Runnable task = new 
				SwingWorkerTask()
				{
					public void init()
					{
						lineNumber = 0;
						openItem.setEnabled(false);
						cancelItem.setEnabled(true);
					}
					
					public void update()
					{
						statusLine.setText("" + lineNumber);
					}
					
					public void finish()
					{
						workerThread = null;
						openItem.setEnabled(true);
						cancelItem.setEnabled(false);
					}
					
					public void work()
					{
						try
						{
							Scanner in = new Scanner(new FileInputStream(file));
							textArea.setText("");
							while(!Thread.currentThread().isInterrupted() && in.hasNextLine())
							{
								lineNumber++;
								line = in.nextLine();
								textArea.append(line);
								textArea.append("\n");
								doUpdate();
							}
						}
						catch(IOException e)
						{
							JOptionPane.showMessageDialog(null, "" + e);
						}
					}
					private String line;
					private int lineNumber;
				};
		workerThread = new Thread(task);
		workerThread.start();
		
	}
	public static final int WIDTH = 400;
	public static final int HEIGHT = 200;
	
	private Thread workerThread;
	private JFileChooser chooser;
	private JTextArea textArea;
	private JLabel statusLine;
	private JMenuItem openItem;
	private JMenuItem cancelItem;
}
