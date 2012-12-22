package CheckBoxTest;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxPanel extends JPanel
{
	public CheckBoxPanel()
	{
		//Adaugarea textului
		label = new JLabel("The quick fox jumps over th laxy dog.");
		label.setFont(new Font("Serif",Font.PLAIN,FONTSIZE));
		add(label, BorderLayout.NORTH);
		
		//Urmatorul litner pune adtribul de srift in care va fi afisat textul label pe baza cHeckBox
		
		ActionListener listner = new ActionListener() 
		{
			
	
			public void actionPerformed(ActionEvent e) 
			{
				int mode = 0;
				if(bold.isSelected())
				{
					mode += Font.BOLD;
				}
				if(italic.isSelected())
				{
					mode += Font.ITALIC;
				}
				
				label.setFont(new Font("Serif",mode,FONTSIZE));
				
			}
		};
		
		south = new JPanel();
		bold = new JCheckBox("Bold");
		bold.addActionListener(listner);
		south.add(bold, BorderLayout.SOUTH);
		
		italic = new JCheckBox("Italic");
		italic.addActionListener(listner);
		south.add(italic, BorderLayout.SOUTH);
		
		add(south, BorderLayout.SOUTH);
		

	}
	
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	private JPanel south;
	
	private static final int FONTSIZE = 12;
}
