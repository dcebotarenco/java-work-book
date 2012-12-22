package TextAreaTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaFrame extends JFrame
{
	public TextAreaFrame()
	{
		setTitle("TextAreaTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		buttonPanel = new JPanel();
		//Adaugarea butonului, care adaugarea textului in textarea
		
		JButton insertButton = new JButton("Insert");
		buttonPanel.add(insertButton);
		
		insertButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea.append("The quick brown fox jumps over the laxy dog.");
			}
		});
		
		//Adaugarea buttonului, care care porneshte sau opreshte WrapText
		
		wrapButton = new JButton("Wrap");
		buttonPanel.add(wrapButton);
		wrapButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean wrap = !textArea.getLineWrap();
				textArea.setLineWrap(wrap);
				scrollPane.revalidate();
				wrapButton.setText(wrap ? "No Wrap" : "Wrap");
			}
		});
		
		add(buttonPanel,BorderLayout.SOUTH);
		
		//Legarea textului cu scroll
		
		textArea = new JTextArea("Enter a text",8,40);
		scrollPane = new JScrollPane(textArea);
		
		add(scrollPane,BorderLayout.CENTER);
		
	}	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;
	
	private JPanel buttonPanel;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton wrapButton;
}
