package StringDraw;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;

/**
 * Panel in care se afisaza mesajul
 * @author Dan Cebotarenco
 *
 */
public class HelloWorldPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		g.drawString("Hello World", screenHeight/8,screenWidth/8 );
	}
}
