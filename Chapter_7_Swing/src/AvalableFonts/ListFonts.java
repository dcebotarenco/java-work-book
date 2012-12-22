package AvalableFonts;

import java.awt.GraphicsEnvironment;

public class ListFonts

{
	public static void main(String[] args)
	{
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(int i = 0; i < fontNames.length; i++)
		{
			System.out.println(fontNames[i]);
		}
	}
}
