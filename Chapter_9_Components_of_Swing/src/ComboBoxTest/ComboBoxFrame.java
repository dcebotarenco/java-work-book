package ComboBoxTest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxFrame extends JFrame
{
	public ComboBoxFrame()
	{
		setTitle("ComboBoxTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//Adaugarea labelui
		label = new JLabel("Hai sa plecam acasa");
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		
		JPanel labelPanel = new JPanel();
		labelPanel.add(label);
		add(labelPanel, BorderLayout.CENTER);
		
		//Crearea listei si adaugarea in ei a punctelor
		optionCombo = new JComboBox<String>();
		optionCombo.setEditable(true);
		
		optionCombo.addItem("Serif");
		optionCombo.addItem("SansSerif");
		optionCombo.addItem("MonoSpaced");
		optionCombo.addItem("Dialog");
		optionCombo.addItem("DialogInput");
		
		//listnerul de evenimente legat cu deschiderea listei, schimba sriftul prin care este reprezentate labelul
		
		ActionListener listner = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				label.setFont(new Font((String) optionCombo.getSelectedItem(),Font.PLAIN,DEFAULT_SIZE));				
			}
		};
		optionCombo.addActionListener(listner);
		
		JPanel comboPanel = new JPanel();
		comboPanel.add(optionCombo);
		add(comboPanel, BorderLayout.SOUTH);
		
	}
	
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 200;
	public static final int DEFAULT_SIZE = 12;
	
	private JLabel label;
	private JComboBox<String> optionCombo;
}
