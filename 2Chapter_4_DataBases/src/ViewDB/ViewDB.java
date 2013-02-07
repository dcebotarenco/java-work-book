package ViewDB;

import javax.swing.JFrame;

/**
 * Aceasta programa demonstreaza folosirea metadatelor pentru afisarea tabelelor din baza de date
 * @author Dan
 *
 */
public class ViewDB 
{
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		JFrame frame = new ViewFrameDB();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
