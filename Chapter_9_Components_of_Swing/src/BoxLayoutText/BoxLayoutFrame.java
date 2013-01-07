package BoxLayoutText;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoxLayoutFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BoxLayoutFrame()
	{
		setTitle("Box_Layout_Text");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//Crearea blucului orizontal de sus
		JLabel label1 = new JLabel("Name");
		JTextField textField1 = new JTextField(10);
		textField1.setMaximumSize(textField1.getPreferredSize());
		
		Box hbox1 = Box.createHorizontalBox();
		hbox1.add(label1);
		//Elementul de impartire a raspor4ii cu marimea de 10 pixeli
		hbox1.add(Box.createHorizontalStrut(30));
		hbox1.add(textField1);
		
		//Crearea blocului din mijloc orizontal
		JLabel label2 = new JLabel("Password:");
		JTextField textField2 = new JTextField(10);
		textField2.setMaximumSize(textField2.getPreferredSize());
		
		Box hbox2 = Box.createHorizontalBox();
		hbox2.add(label2);
		//Elementul de impartire a raspor4ii cu marimea de 10 pixeli
		hbox2.add(Box.createHorizontalStrut(30));
		hbox2.add(textField2);
		
		//Crearea blocului de jos orizontal
		
		JButton button1 = new JButton("OK");
		JButton button2 = new JButton("Cancel");
		
		Box hbox3 = Box.createHorizontalBox();
		hbox3.add(button1);
		//Pentru indepartarea elementelor se foloseste Clei (GLUE);
		hbox3.add(Box.createHorizontalGlue());
		hbox3.add(button2);
		
		//Adaugarea tuturor blocurilor orizontale in unul vertical
		Box vbox = Box.createVerticalBox();
		vbox.add(hbox1);
		vbox.add(hbox2);
		vbox.add(Box.createGlue());
		vbox.add(hbox3);
		
		add(vbox, BorderLayout.CENTER);
		
	
	}
	
	public static final int DEFAULT_WIDTH = 200;
	public static final int DEFAULT_HEIGHT = 200;
}
