package CalculatorAppletWithFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PopupCalculatorApplet extends JApplet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init()
	{
		//Crearea Ferestrei  cu panelu de calculator
		
		final JFrame frame = new JFrame();
		frame.setTitle("PopUpCalculator");
		frame.setSize(WIDTH, HEIGHT);
		frame.add(new CalculatorPanel());
		
		//Buttonul de Chemare sau inchidere a calculatorului
		JButton calcButton = new JButton("Calculator");
		add(calcButton);
		
		calcButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				frame.setVisible(!frame.isVisible());
			}
		});
	}
	public static final int WIDTH = 200;
	public static final int HEIGHT = 200;
}
