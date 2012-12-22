package CenteredFrame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CenteredFrame extends JFrame
{
	public CenteredFrame()
	{
		//Gasirea marimii ecranului
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		//Aranjarea ferestrei pe centru
		setSize(screenWidth /2,screenHeight/2);
		setLocation(screenWidth/4, screenHeight/4);
		
		//Instalarea pictogramei Titlului
		Image img = kit.getImage("Image/icon.png");
		setIconImage(img);
		setTitle("CenteredFrame");
	}
}
