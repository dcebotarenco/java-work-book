package TextTest;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 * Frame cu dou cimpuri de redactare pentru ceas
 * @author Dan
 *
 */
public class TextTestFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;
	private JTextField hourField;
	private JTextField minuteField;
	private ClockPanel clock;
	public TextTestFrame()
	{
		setTitle("TextTest");
		DocumentListener listner = new ClockFieldListner() ;
		
		//Adaugarea panelului cu cimpuri de redactare
		JPanel panel = new JPanel();
		panel.add(new JLabel("Hours:"));
		hourField = new JTextField("12",3);
		panel.add(hourField);
		hourField.getDocument().addDocumentListener(listner);
		
		panel.add(new JLabel("Minutes:"));
		minuteField = new JTextField("00",3);
		panel.add(minuteField);
		minuteField.getDocument().addDocumentListener(listner);
		
		add(panel,BorderLayout.SOUTH);
		
		//Adaugarea ceasului
		clock = new ClockPanel();
		add(clock,BorderLayout.CENTER);
		pack();
	}
	
	/**
	 * Instalarea ceasului cu numerele introduse in cimpuri
	 */
	public void setClock()
	{
		try
		{
			int hours = Integer.parseInt(hourField.getText().trim());
			int minutes = Integer.parseInt(minuteField.getText().trim());
			clock.setTime(hours, minutes);
		}
		catch (NumberFormatException e) {}
		//Daca taxtul nu este cifra atunci ceasul nu se pune
	}
	
	private class ClockFieldListner implements DocumentListener	
	{

		public void changedUpdate(DocumentEvent e) {}

		
		public void insertUpdate(DocumentEvent e) 
		{
			setClock();			
		}

		
		public void removeUpdate(DocumentEvent e) 
		{
			setClock();
		}
		
	}
}
