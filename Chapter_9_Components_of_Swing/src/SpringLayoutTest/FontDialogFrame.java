package SpringLayoutTest;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Spring;
import javax.swing.SpringLayout;
/**
 * Frame in care pentru aranjarea componentelor este folosit SpringLayout
 * @author Dan
 *
 */
public class FontDialogFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FontDialogFrame()
	{
		setTitle("FontDialog");
		setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);
		
		ActionListener listner = new FontAction();
		
		//Crearea Componentelor
		
		JLabel faceLabel = new JLabel("Font Face: ");
		
		face = new JComboBox<String>(new String[]
				{
					"Serif","SansSerif","Monospaced","Dialog","DialogInput"
				});
		face.addActionListener(listner);
		
		JLabel sizeLabel = new JLabel("Size: ");
		size = new JComboBox<String>(new String[]
				{
					"8","10","12","15","18","24","36","48"
				});
		size.addActionListener(listner);
		
		bold = new JCheckBox("Bold");
		bold.addActionListener(listner);
		italic = new JCheckBox("Italic");
		italic.addActionListener(listner);
		
		sample = new JTextArea();
		sample.setText("Write Something..");
		sample.setEditable(false);
		sample.setLineWrap(true);
		sample.setBorder(BorderFactory.createEtchedBorder());
		
		panel.add(faceLabel);
		panel.add(sizeLabel);
		panel.add(face);
		panel.add(size);
		panel.add(bold);
		panel.add(italic);
		panel.add(sample);
		
		//Adaugarea resorturilor
		
		Spring strut = Spring.constant(10);
		
		Spring labelsEast = Spring.sum(strut, 
				Spring.max(
						layout.getConstraints(faceLabel).getWidth(), 
						layout.getConstraints(sizeLabel).getWidth()));
		
		layout.putConstraint(SpringLayout.EAST, faceLabel, labelsEast, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, sizeLabel, labelsEast, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, faceLabel, strut, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, face, strut, SpringLayout.NORTH, panel);
		
		Spring secondRowNorth = Spring.sum(strut, 
				Spring.max(
						layout.getConstraint(SpringLayout.SOUTH,faceLabel), 
						layout.getConstraint(SpringLayout.SOUTH, face)));
		
		layout.putConstraint(SpringLayout.NORTH, sizeLabel, secondRowNorth, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, size, secondRowNorth, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, face, strut, SpringLayout.EAST, faceLabel);
		layout.putConstraint(SpringLayout.WEST, size, strut, SpringLayout.EAST, sizeLabel);
		layout.putConstraint(SpringLayout.WEST, bold, strut, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, italic, strut, SpringLayout.WEST, panel);
		
		Spring s = Spring.constant(10,10000,10000);
		
		Spring thirdRowNorth = Spring.sum(s,
				Spring.max(
						layout.getConstraint(SpringLayout.SOUTH, sizeLabel),
						layout.getConstraint(SpringLayout.SOUTH, size)));
		layout.putConstraint(SpringLayout.NORTH, bold, thirdRowNorth, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, italic, s, SpringLayout.SOUTH, bold);
		layout.putConstraint(SpringLayout.SOUTH, panel, s, SpringLayout.SOUTH, italic);
		
		Spring secondColumnWest = Spring.sum(strut,
				Spring.max(
						layout.getConstraint(SpringLayout.EAST, face),
						layout.getConstraint(SpringLayout.EAST, size)));
		
		layout.putConstraint(SpringLayout.WEST, sample, secondColumnWest, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH, sample, Spring.minus(strut), SpringLayout.SOUTH, panel);
		layout.putConstraint(SpringLayout.NORTH, sample, strut, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.EAST, panel, strut, SpringLayout.EAST, sample);
		
		add(panel);
	}
	
	private JComboBox<String> face;
	private JComboBox<String> size;
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea sample;
	
	class FontAction implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			String fontFace = (String) face.getSelectedItem();
			int fontStyle = (bold.isSelected() ? Font.BOLD : 0)+(italic.isSelected() ? Font.ITALIC : 0);
			int fontSize = Integer.parseInt((String) size.getSelectedItem());
			
			Font font = new Font(fontFace , fontStyle, fontSize);
			
			sample.setFont(font);
			sample.repaint();
			
		}
		
	}
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 200;
}
