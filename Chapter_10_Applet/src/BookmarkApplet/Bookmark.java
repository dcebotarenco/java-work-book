package BookmarkApplet;

import java.applet.AppletContext;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JRadioButton;

public class Bookmark extends JApplet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init()
	{
		Box box = Box.createVerticalBox();
		ButtonGroup group = new ButtonGroup();
		
		int i = 1;
		String urlString;
		
		//Citirea parametrelor link.n
		
		
		while((urlString = getParameter("link."+i)) != null)
		{
			try
			{
				final URL url = new URL(urlString);
				//Crearea cite un radioButton pt fiecare link
				JRadioButton button = new JRadioButton(urlString);
				box.add(button);
				group.add(button);
				
				//Alegerea radioButton duce la afisarea paginii in frame din dreapta a documentului
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						AppletContext context = getAppletContext();
						context.showDocument(url, "right");
					}
				});
			}
			catch(MalformedURLException e)
			{
				e.printStackTrace();
			}
			i++;
		}
		
		Container contentPane = getContentPane();
	      contentPane.add(box);
	}
}
