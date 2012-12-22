package FontCentre;
import javax.swing.*;

public class FontFrame extends JFrame
{
	public static final int DEFAULT_WIDTH=300;
	public static final int DEFAULT_HEIGHT=200;
	public FontFrame()
	{
		setTitle("FontTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		//Adaugarea panelului
		FontPanel panel = new FontPanel();
		add(panel);
	}
}
