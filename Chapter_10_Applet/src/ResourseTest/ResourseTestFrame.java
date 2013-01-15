package ResourseTest;

import javax.swing.JFrame;


/**
 * Frame ce contine panel cu componente ca demostreaza accesul la componente din Jar file
 * @author Dan
 *
 */
public class ResourseTestFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourseTestFrame()
	{
		setTitle("Resource Test Frame");
		setSize(WIDTH, HEIGHT);
		add(new AboutPanel());
	}
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;

}
