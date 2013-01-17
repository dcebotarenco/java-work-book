package EventTracer;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JSlider;

public class EventTracerFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventTracerFrame()
	{
		setTitle("EventTracerFrame");
		setSize(width, height);
		
		//adaugarea regulatorului si butonului
		add(new JSlider(), BorderLayout.NORTH);
		add(new Button("Test"), BorderLayout.SOUTH);
		
		//Prinderea tuturor eventurilor legate de componentele ferestrei
		EventTracer tracer = new EventTracer();
		tracer.add(this);
	}
	public static final int width = 400;
	public static final int height = 400;
}
