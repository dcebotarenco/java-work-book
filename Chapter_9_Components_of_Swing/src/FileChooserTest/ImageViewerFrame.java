package FileChooserTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Frame contine menu pentru incarcarea filurilor grafice si zone de afisare afilurile ce se vor incarca
 * @author Dan
 *
 */
public class ImageViewerFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageViewerFrame()
	{
		setTitle("FileChooserTest");
		setSize(WIDTH,HEIGHT);
		
		//Crearea rindului Menu
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
				System.exit(0);
			}
		});
		
		//Pentru afisarea desenului se foloseste Label
		label = new JLabel();
		add(label);
		
		//Crearea ferestrei de dialog pentru alegerea filului
		chooser = new JFileChooser();
		
		//Sa admitem numai filuri cu extensie .jpg .jpeg .gif
		final ExtensionFileFilter filter = new ExtensionFileFilter();
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.setDescription("Image Files");
		chooser.setFileFilter(filter);
		
		chooser.setAccessory(new ImagePreviewer(chooser));
		
		chooser.setFileView(new FileIconView(filter,new ImageIcon("images/jack.gif")));
	}
	
	/**
	 * Listener activity, legat de menu File  > Open
	 */
	private class FileOpenListner implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			chooser.setCurrentDirectory(new File("."));
			
			//Afisarea ferestrei de dialog pentru alegerea filurilor
			int result = chooser.showOpenDialog(ImageViewerFrame.this);
			
			//Daca file este admis el este folosit in calitate de pictograma la Label
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				String name = chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		}
		
	}
	private JLabel label;
	private JFileChooser chooser;
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 400;
}
