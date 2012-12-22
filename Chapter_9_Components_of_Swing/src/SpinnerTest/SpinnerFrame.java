package SpinnerTest;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
/**
 * Frame cu panel, ca re contine citiva regulatori de incrementare si un button de a vedea valoarea lor.
 * @author Dan
 *
 */
public class SpinnerFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpinnerFrame()
	{
		setTitle("SpinnerTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JPanel buttonPanel = new JPanel();
		okButton = new JButton("Ok");
		buttonPanel.add(okButton);
		add(buttonPanel, BorderLayout.SOUTH);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0,3));
		add(mainPanel, BorderLayout.CENTER);
		
		JSpinner defaultSpinner = new JSpinner();
		addRowToMainPanel("Default", defaultSpinner);
		
		JSpinner boundedSpinner = new JSpinner(new SpinnerNumberModel(5,0,10,0.5));
		addRowToMainPanel("Bounded", boundedSpinner);
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JSpinner listSpinner = new JSpinner(new SpinnerListModel(fonts));
		addRowToMainPanel("List", listSpinner);
		
		JSpinner reverseListSpinner = new JSpinner(new SpinnerListModel(fonts)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public Object getNextValue()
			{
				return super.getPreviousValue();
				
			}
			public Object getPreviousValue()
			{
				return super.getNextValue();
			}
		});
		addRowToMainPanel("Reverse List", reverseListSpinner);
		
		JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
		addRowToMainPanel("Date", dateSpinner);
		
		JSpinner betterDateSpinner = new JSpinner(new SpinnerDateModel());
		String pattern = ((SimpleDateFormat)DateFormat.getDateInstance()).toPattern();
		betterDateSpinner.setEditor(new JSpinner.DateEditor(betterDateSpinner, pattern));
		addRowToMainPanel("Better Date", betterDateSpinner);
		
		JSpinner timeSpinner = new JSpinner(
				new SpinnerDateModel(
						new GregorianCalendar(2000,Calendar.JANUARY,1,12,0,0).getTime(),
							null,null, Calendar.HOUR));
		addRowToMainPanel("Time", timeSpinner);
		
		JSpinner permSpinner = new JSpinner(new PermutationSpinnerModel("persic"));
		addRowToMainPanel("Word Permutation", permSpinner);
		
	}
	
	/**
	 * Adaugarea unui rind in panelul principal
	 * @param labelText Label a componentului JSpinner
	 * @param spinner componetul JSpinner
	 */
	public void addRowToMainPanel(String labelText, final JSpinner spinner)
	{
		mainPanel.add(new JLabel(labelText));
		mainPanel.add(spinner);
		
		final JLabel valueLabel = new JLabel();
		mainPanel.add(valueLabel);
		okButton.addActionListener(new ActionListener() 
		{
			
			
			public void actionPerformed(ActionEvent arg0) 
			{
				Object value = spinner.getValue();
				valueLabel.setText(value.toString());
			}
		});
		
	}
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 200;
	
	private JButton okButton;
	private JPanel mainPanel;
}
