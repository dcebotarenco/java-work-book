package Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.*;

public class DrawFrame extends JFrame
{
	private int DEFAULT_WIDTH=400;
	private int DEFAULT_HEIGHT=400;
	public DrawFrame()
	{
		setTitle("DrawTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//Adaugarea penelului la Frame
		
		DrawPanel panel = new DrawPanel();
		panel.setBackground(SystemColor.scrollbar);
		add(panel);
	}
}
