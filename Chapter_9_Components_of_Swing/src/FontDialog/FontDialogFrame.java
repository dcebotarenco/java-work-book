package FontDialog;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import ToolBarTest.GBC;

/**
 * Frame in care dispecerul GridBagLayout este folosesit pentru alinierea componentelor
 * care sunt pentru alegerea sriftului
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
		setTitle("Font_Dialog");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		ActionListener listner = new FontAction();
		
		JLabel faceLabel = new JLabel("Face: ");
		face = new JComboBox<String>(new String[]
			{
				"Serif", "SansSerif", "Monospaced",
				"Dialog", "DialogInput"
			}
		);
		face.addActionListener(listner);
		
		JLabel sizeLabel = new JLabel("Size: ");
		size = new JComboBox<String>(new String[]
			{
				"8","10","12","15","18","24","36","48"	
			}
		);
		size.addActionListener(listner);
		
		bold =new JCheckBox("Bold");
		bold.addActionListener(listner);
		
		italic = new JCheckBox("Italic");
		italic.addActionListener(listner);
		
		sample = new JTextArea();
		sample.setText("Hai sa scrim Impreuna");
		sample.setEditable(true);
		sample.setLineWrap(true);
		sample.setBorder(BorderFactory.createEtchedBorder());
		
		//Adaugarea componentelor cu ajutorul clase GBC
		add(faceLabel, new GBC(0,0).setAnchor(GBC.EAST));
		add(face, new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100.0, 0.0).setInsets(1));
		add(sizeLabel, new GBC(0,1).setAnchor(GBC.EAST));
		add(size, new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100.0, 0).setInsets(1));
		add(bold, new GBC(0,2,2,1).setAnchor(GBC.CENTER).setWeight(100.0, 100.0));
		add(italic, new GBC(0,3,2,1).setAnchor(GBC.CENTER).setWeight(100.0, 100.0));
		add(sample, new GBC(2,0,1,4).setFill(GBC.BOTH).setWeight(100, 100));
	}
	
	class FontAction implements ActionListener
	{	
		public void actionPerformed(ActionEvent event)
		   {  
		      String fontFace = (String)face.getSelectedItem();
		      int fontStyle = (bold.isSelected() ? Font.BOLD : 0)
		         + (italic.isSelected() ? Font.ITALIC : 0);
		      int fontSize = Integer.parseInt(
		         (String)size.getSelectedItem());
		      Font font = new Font(fontFace, fontStyle, fontSize);
		      sample.setFont(font);
		      sample.repaint();
		   }
	}
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	private JComboBox<String> face;
	private JComboBox<String> size;
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea sample;

}


