package ExceptTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Panel cu radioButton pentru executarea fragmentelor de cod si analiza exceptiilor
 * @author Dan
 *
 */
public class ExceptionTestPanel extends Box
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionTestPanel()
	{
		super(BoxLayout.Y_AXIS);
		group = new ButtonGroup();
		//Adaugarea radioButton
		
		addRadioButton("Integer divide by zero", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				a[1] = 1 / (a.length-a.length);
			}
		});
		
		addRadioButton("Floating point divide by zero", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a[1] = a[2]/(a[3]-a[3]);
			}
		});
		
		addRadioButton("Array bounds", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a[1] = a[10];
			}
		});
		
		addRadioButton("Bad cast", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a = (double[])e.getSource();
			}
		});
		
		addRadioButton("Null Pointer", new ActionListener() {
			
			@SuppressWarnings("null")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				e = null;
				System.out.println(e.getSource());
			}
		});
		
		addRadioButton("sqrt(-1)", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a[1] = Math.sqrt(-1);
			}
		});
		
		addRadioButton("Overflow", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a[1]= 1000 * 1000 * 1000 *1000;
				@SuppressWarnings("unused")
				int n = (int)a[1];
			}
		});
		
		addRadioButton("No such File", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try
				{
					@SuppressWarnings({ "unused", "resource" })
					InputStream in = new FileInputStream("woozle.txt");
				}
				catch (IOException err)
				{
					textField.setText(err.toString());
				}
			}
		});
		
		addRadioButton("Throw unknown", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				throw new UnknownError();
			}
		});
		
		
		//Adaugarea cimpului de redactare pentru afisarea informatiei despre exceptie
		textField = new JTextField(30);
		add(textField);
		
	}
	
	private ButtonGroup group;
	private JTextField textField;
	private double[] a = new double[10];
	
	/**
	 * Adauga in panelul un radioButton cu listner
	 * @param s Labelul radioButton
	 * @param listner Listnerul
	 */
	private void addRadioButton(String s,ActionListener listner)
	{
		@SuppressWarnings("serial")
		JRadioButton button = new JRadioButton(s,false)
		{
			//Aceasta metoda se cheama pentru generarea evenimetului
			//O schimbam pentru prevenirea exceptiilor
			protected void fireActionPerformed(ActionEvent event)
			{
				try
				{
					textField.setText("No exception");
					super.fireActionPerformed(event);
				}
				catch (Exception e)
				{
					textField.setText(e.toString());
				}
			}
		};
		button.addActionListener(listner);
		add(button);
		group.add(button);
	}
}
