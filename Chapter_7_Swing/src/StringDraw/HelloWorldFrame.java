package StringDraw;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
/**
 * Frame, ce contine panel cu mesaj
 * @author Dan Cebotarenco
 *
 */
public class HelloWorldFrame extends JFrame
{
	public HelloWorldFrame()
	{  	//Titlul
		setTitle("Hello World");
		//Gasirea marimii ecranului
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		//Aranjarea la centru
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth/4,screenHeight / 4);
		
		Image img = kit.getImage("Image/icon.png");
		setIconImage(img);
		HelloWorldPanel panel = new HelloWorldPanel();
		add(panel);
	}
	
}
