package Fill_2D_Draw;

import javax.swing.*;

public class FillFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	 public FillFrame()
	 {
		 setTitle("FillTest");
		 setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		 
		 //Adaugarea panelului
		 FillPanel panel = new FillPanel();
		 add(panel);
	 }
}
