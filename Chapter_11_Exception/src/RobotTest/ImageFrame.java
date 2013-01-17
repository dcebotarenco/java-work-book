package RobotTest;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param Imaginea de afisare
	 */
	public ImageFrame(Image image)
	{
		setTitle("Capture");
		setSize(width, height);
		
		JLabel label =  new JLabel(new ImageIcon(image));
		add(label);
	}
	public static final int width = 450;
	public static final int height = 350;
}
