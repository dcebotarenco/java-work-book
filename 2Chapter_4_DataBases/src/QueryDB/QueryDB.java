package QueryDB;

import javax.swing.JFrame;

/**
 * programa demostreaza folosirea query Complicat
 * @author Dan
 *
 */
public class QueryDB 
{
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		JFrame frame = new QueryBDFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
