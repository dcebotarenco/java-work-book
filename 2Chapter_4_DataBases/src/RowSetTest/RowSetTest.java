package RowSetTest;

import java.io.IOException;

import javax.swing.JFrame;


/**
 * Aceasta programa demonstreaza folosirea metadatelor 
 * pentru afisarea tabelelor din baza de date
 * @author Dan
 */
public class RowSetTest
{
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		JFrame frame = new RowSetFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
