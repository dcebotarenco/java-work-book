package LoggingImageWindow;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class LoggingImageViewer 
{
	public static void main(String[] args)
	{
		if(System.getProperty("java.util.loggging.config.class")==null
				&& System.getProperty("java.util.loggging.config.file")==null)
		{
			try
			{
				Logger.getLogger("").setLevel(Level.ALL);
				final int LOG_ROTATION_COUNT = 10;
				Handler handler = new FileHandler("%h/LoggingImageViewer.log",0,LOG_ROTATION_COUNT);
				Logger.getLogger("").addHandler(handler);
			}
			catch(IOException e)
			{
				Logger.getLogger("com.cebotarenco.java").log(Level.SEVERE, "Can't create log file handler",e);
			}
		}
		
		Handler windowHandler = new WindowHandler();
		windowHandler.setLevel(Level.ALL);
		Logger.getLogger("com.cebotarenco.java").addHandler(windowHandler);
		
		JFrame frame = new ImageViewerFrame();
		frame.setTitle("LoggingImageViewer");
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Logger.getLogger("com.cebotarenco.java").fine("Showing Frame");
		frame.setVisible(true);
	}
}
