/**
   @version 1.20 26 Jun 1998
   @author Cay Horstmann
*/

/*
  <APPLET CODE="NotHelloWorldApplet.class" WIDTH=300 HEIGHT=100>
  </APPLET>
*/
package NotHelloWorld;

import java.awt.*;
import javax.swing.*;

public class NotHelloWorldApplet extends JApplet
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void init()
   {
      Container contentPane = getContentPane();
      JLabel label = new JLabel("Not a Hello, World applet",
         SwingConstants.CENTER);
      contentPane.add(label);
   }
}
