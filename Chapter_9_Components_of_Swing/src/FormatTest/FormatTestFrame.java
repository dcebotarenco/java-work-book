package FormatTest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DocumentFilter;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.MaskFormatter;
/**
 * Frame ce contine cimpul de redactare cu continerea dormatului si unui buton, ce presupune activarea continutului lor.
 * @author Dan
 *
 */
public class FormatTestFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FormatTestFrame()
	{
		setTitle("FormatTest");
		setSize(WIDTH,HEIGHT);
		
		JPanel buttonPanel = new JPanel();
		okButton = new JButton("OK");
		buttonPanel.add(okButton);
		add(buttonPanel,BorderLayout.SOUTH);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0,3));
		add(mainPanel,BorderLayout.CENTER);
		
		JFormattedTextField intField = new JFormattedTextField(NumberFormat.getInstance());
		intField.setValue(new Integer(100));	
		addRow("Number:", intField);
		
		JFormattedTextField intField2 = new JFormattedTextField(NumberFormat.getInstance());
		intField2.setValue(new Integer(100));
		intField2.setFocusLostBehavior(JFormattedTextField.COMMIT);
		addRow("Number (commit behavior):", intField2);
		
		JFormattedTextField intField3 = new JFormattedTextField(new InternationalFormatter(NumberFormat.getInstance())
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			protected DocumentFilter getDocumentFilter()
			{
				return filter;
			}
			private DocumentFilter filter = new IntFilter();
		});
		intField3.setValue(new Integer(100));
		addRow("Filtered Number", intField3);
		
		JFormattedTextField intField4 = new JFormattedTextField(NumberFormat.getInstance());
		intField4.setValue(new Integer(100));
		intField4.setInputVerifier(new FormattedTextFieldVerifier());
		addRow("Verified Number", intField4);
		
		JFormattedTextField currencyField = new JFormattedTextField(NumberFormat.getInstance());
		currencyField.setValue(new Double(10));
		addRow("Currency:", currencyField);
		
		JFormattedTextField dateField = new JFormattedTextField(DateFormat.getDateInstance());
		dateField.setValue(new Date());
		addRow("Date (default):", dateField);
		
		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
		format.setLenient(false);
		JFormattedTextField dateField2 = new JFormattedTextField(format);
		dateField2.setValue(new Date());
		addRow("Date (short,not lenient)", dateField2);
		
		try
		{
			DefaultFormatter formatter = new DefaultFormatter();
			formatter.setOverwriteMode(false);
			JFormattedTextField urlField = new JFormattedTextField(formatter);
			urlField.setValue(new URL("http://www.google.com"));
			addRow("URL:",urlField);
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			MaskFormatter formmater = new MaskFormatter("###-##-####");
			formmater.setPlaceholderCharacter('0');
			JFormattedTextField ssnField = new JFormattedTextField(formmater);
			ssnField.setValue("078-05-1120");
			addRow("SSN Mask:", ssnField);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		
		JFormattedTextField ipField = new JFormattedTextField(new IPAddressFormatter());
		ipField.setValue(new byte[] {(byte) 130,65,86,66});
		addRow("IP Address:", ipField);

	}
	
	/**
	 * Adauga Textul in panelul pricipal
	 */
	public void addRow(String labelText, final JFormattedTextField field)
	{
		mainPanel.add(new JLabel(labelText));
		mainPanel.add(field);
		
		final JLabel valueLabel = new JLabel();
		mainPanel.add(valueLabel);
		
		okButton.addActionListener(new ActionListener() 
		{		
			public void actionPerformed(ActionEvent e) 
			{
				Object value = field.getValue();
				if(value.getClass().isArray())
				{
					StringBuilder builder = new StringBuilder();
					builder.append('{');
					for(int i=0;i<Array.getLength(value);i++)
					{
						if(i>0) 
						{
							builder.append(',');							
						}
						builder.append(Array.get(value, i).toString());
					}
					builder.append('}');
					valueLabel.setText(builder.toString());					
				}
				else
				{
					valueLabel.setText(value.toString());
				}
				
			}
		});
	}
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 250;
	private JButton okButton;
	private JPanel mainPanel;
}
