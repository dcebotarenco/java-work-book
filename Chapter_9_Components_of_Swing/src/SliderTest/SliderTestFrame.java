package SliderTest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Frame cu regulator in linie si cu cimp ce afiseaza valoarea curenta a regulatorului
 * @author Dan
 *
 */
public class SliderTestFrame extends JFrame
{
	public SliderTestFrame()
	{
		setTitle("SliderTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//interceptor unic pentru regulatoare
		listner = new ChangeListener() 
		{			
			public void stateChanged(ChangeEvent event) 
			{
				//Refresh la cimpuri la modificarea regulatorului
				JSlider source = (JSlider) event.getSource();
				textField.setText("" + source.getValue());			
			}
		};
		
		//Adaugarea unui regulator simplu
		JSlider slider = new JSlider();
		addSlider(slider,"Plain");
		
		//Adaugarea regulatorului cu dispartituri principale si secundare
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Ticks");
		
		//Adaugarea regulatorului cu fixarea la dispartituri
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Snap to Ticks");
		
		//Adaugarea regulatorului a carei drum nu se arata
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addSlider(slider, "Ticks");
		
		//Adaugarea regulatorului cu miscare in contra sens
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider, "Inverted");
		
		//Adaugarea regulatorului cu tick cifrate
		slider= new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Labels");
		
		//Adaugarea regulatorului cu tick literat
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		//Literile
		Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();
		labelTable.put(0,new JLabel("A"));
		labelTable.put(20,new JLabel("B"));
		labelTable.put(40,new JLabel("C"));
		labelTable.put(60,new JLabel("D"));
		labelTable.put(80,new JLabel("E"));
		labelTable.put(100,new JLabel("F"));
		
		slider.setLabelTable(labelTable);
		addSlider(slider, "Custom Labels");
		
		//Adaugarea  regulatorului cu tickurile in forma de pictograme.
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(20);
		
		labelTable = new Hashtable<Integer, Component>();
		//Adaugarea imaginilor
		labelTable.put(0, new JLabel(new ImageIcon("images/nine.gif")));
		labelTable.put(20, new JLabel(new ImageIcon("images/ten.gif")));
		labelTable.put(40, new JLabel(new ImageIcon("images/jack.gif")));
		labelTable.put(60, new JLabel(new ImageIcon("images/queen.gif")));
		labelTable.put(80, new JLabel(new ImageIcon("images/king.gif")));
		labelTable.put(100, new JLabel(new ImageIcon("images/ace.gif")));
		
		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon Labels");
		
		//Adaugarea unui Text FIeld pentru afisarea LAbel
		textField = new JTextField();
		add(sliderPanel, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
			
	
		
	}
	
	/**
	 * Adaugam reguleator in panl si il legam cu interceptorul de evenimente
	 * @param s regulator
	 * @param description decrierea regulatorului
	 */
	public void addSlider(JSlider s, String description)
	{
		s.addChangeListener(listner);
		JPanel panel = new JPanel();
		panel.add(s);
		panel.add(new JLabel(description));
		sliderPanel.add(panel);
	}
	
	public static final int DEFAULT_WIDTH = 350;
	public static final int DEFAULT_HEIGHT = 450;
	

	private JPanel sliderPanel;
	private ChangeListener listner;
	private JTextField textField;
}
