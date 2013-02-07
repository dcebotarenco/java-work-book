package MailTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AppletGmail extends JApplet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init()
	{
		//Crearea Ferestrei  cu panelu de calculator
		
				final JFrame frame = new MailTestFrame();
				
				setSize(100, 100);
				//Buttonul de Chemare sau inchidere a calculatorului
				JButton calcButton = new JButton("Gmail");
				add(calcButton,BorderLayout.SOUTH);
				
				calcButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						frame.setVisible(!frame.isVisible());
					}
				});
	}

}
