package LoggingImageWindow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class ImageViewerFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ImageViewerFrame()
	{
		setLayout(new BorderLayout());
		logger.entering("ImageViewerFrame", "<init>");
		//Crearea menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new FileOpenListner());
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				logger.fine("Exiting.");
				System.exit(0);
			}
		});
		
		//Pentru afisarea desenului se foloseshte un label
		label = new JLabel();
		JPanel labelPanel = new JPanel();
		add(labelPanel, BorderLayout.CENTER);
		labelPanel.add(label);
		logger.exiting("ImageViewerFrame", "<init>");
	}
	
	private class FileOpenListner implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			logger.entering("ImageViewerFrame.FileOpenListner", "actionPerformed", e);
			
			//Crearea ferestrei pentru alegerea filului.
			JFileChooser chooser =new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			
			//Se citesc doar filurile cu extensia .gif
			chooser.setFileFilter(new FileFilter() {
				
				@Override
				public String getDescription() {
					// TODO Auto-generated method stub
					return "Gif Images";
				}
				
				@Override
				public boolean accept(File arg0) {
					// TODO Auto-generated method stub
					return arg0.getName().toLowerCase().endsWith(".gif") || arg0.isDirectory();
				}
			});
			
			//Afisarea ferestrei de dialog pentru alegerea file
			int r = chooser.showOpenDialog(ImageViewerFrame.this);
			
			//Daca FIle este ales, alegem pictograma
			if( r == JFileChooser.APPROVE_OPTION)
			{
				String name = chooser.getSelectedFile().getPath();
				logger.log(Level.FINE, "Reading file(0)", name);
				label.setIcon(new ImageIcon(name));
			}
			else
			{
				logger.fine("File open dialog canceled");
			}
			logger.exiting("ImageViewerFrame.FileOpenListner", "actionPerformed");		
		}
		
	}
	private JLabel label;
	private static Logger logger = Logger.getLogger("com.cebotarenco.java");
}
