package BorderTest;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class BorderFrame extends JFrame 
{
	public BorderFrame()
	{
		setTitle("Border_Test");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		demoPanel = new JPanel();
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
		addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
		addRadioButton("Etched", BorderFactory.createEtchedBorder());
		addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
		addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
		addRadioButton("Empty", BorderFactory.createEmptyBorder());
		
		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched, "Border types");
		buttonPanel.setBorder(titled);
		
		setLayout(new GridLayout(2, 1));
		add(buttonPanel);
		add(demoPanel);
		
	}
	
	public void addRadioButton(String buttonName, final Border b)
	{
		JRadioButton button = new JRadioButton(buttonName);
		ActionListener listner = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				demoPanel.setBorder(b);
				validate();			
			}
		};
		
		button.addActionListener(listner);
		group.add(button);
		buttonPanel.add(button);
	}
	public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 200;
	
	private JPanel demoPanel;
	private JPanel buttonPanel;
	private ButtonGroup group;
}