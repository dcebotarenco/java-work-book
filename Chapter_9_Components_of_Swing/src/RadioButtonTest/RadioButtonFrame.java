package RadioButtonTest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.ButtonPeer;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonFrame extends JFrame
{
	public RadioButtonFrame()
	{
		setTitle("Radio Button Test");
		setSize(DEFAULT_WEIGHT,DEFAULT_HEIGHT);
		//Adaugarea label
		label = new JLabel("Hai sa sarim in aer.");
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		labelPanel = new JPanel();
		labelPanel.add(label);
		add(labelPanel,BorderLayout.CENTER);
		
		//Adaugarea Radio button
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("Small", 8);
		addRadioButton("Medium", 12);
		addRadioButton("Large", 18);
		addRadioButton("Extra Large", 36);
		
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Adaugarea redio buton, punerea marimii de shrift pentru a afisa labelu
	 * @param name numele label
	 * @param marimea
	 */
	public void addRadioButton(String name,final int size)
	{
		boolean selected = (size == DEFAULT_SIZE);
		JRadioButton button = new JRadioButton(name,selected);
		group.add(button);
		buttonPanel.add(button);
		
		//listnerul pune marimea shriftului
		 ActionListener listner = new ActionListener()
		{
			 public void actionPerformed(ActionEvent e) 
			{
				//marimea este egala cu ultimu parametru din metoda addRadioButton()
				label.setFont(new Font("Serif", Font.PLAIN, size));
			}
		};
		
		button.addActionListener(listner);
	}
	public static final int DEFAULT_HEIGHT = 200;
	public static final int DEFAULT_WEIGHT = 400;
	public static final int DEFAULT_SIZE = 8;
	
	private  JLabel label;
	private  ButtonGroup group;
	private  JPanel buttonPanel;
	private  JPanel labelPanel;
}
