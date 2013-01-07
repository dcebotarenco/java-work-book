package FileChooserTest;

import java.awt.Dimension;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class ImagePreviewer extends JLabel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor ImagePreviewer
	 * @param chooser Fereastra de dialog pentru alegrea filurilor
	 * Schimbarea valorii aduce la schmabrea viziunii 
	 */
	public ImagePreviewer(JFileChooser chooser)
	{
		setPreferredSize(new Dimension(100, 100));
		setBorder(BorderFactory.createEtchedBorder());
		
		chooser.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
				{
					//Userul a ales unnou FIle
					File f = (File) arg0.getNewValue();
					if(f == null) {setIcon(null); return;}
					
					//Citirea desenului pentru a ol folosi ca vizunea
					ImageIcon icon = new ImageIcon(f.getPath());
					
					//Daca pizcotgrama este prea mare se face masabizarea
					if(icon.getIconWidth() > getWidth())
						icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
					setIcon(icon);
				}
			}
		});
	}

}
