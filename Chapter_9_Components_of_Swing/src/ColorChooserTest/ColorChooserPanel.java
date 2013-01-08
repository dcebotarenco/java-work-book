package ColorChooserTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Panel cu butoane pentru alege 3 tipuri de componente
 * @author Dan
 *
 */
public class ColorChooserPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ColorChooserPanel()
	{
		JButton modalButton = new JButton("Modal");
		modalButton.addActionListener(new ModalListner());
		add(modalButton);
		
		JButton modelessButton = new JButton("ModeLess");
		modelessButton.addActionListener(new ModelessListner());
		add(modelessButton);
		
		JButton immediateButton = new JButton("Immediate");
		immediateButton.addActionListener(new ImmediateListner());
		add(immediateButton);
	}
	
	/**
	 * Acest Listner afiseaza fereastra modala de culori
	 */
	
	private class ModalListner implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color defaultColor = getBackground();
			Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "set Background", defaultColor);
			if(selected!= null) setBackground(selected);
		}
		
	}
	
	/**
	 * Acest Listner afiseaza fereastra nemodala pentru alegerea culorii. Culoarea se schimba dupa click pe OK
	 */
	private class ModelessListner implements ActionListener
	{

		
		public ModelessListner()
		{
			chooser = new JColorChooser();
			dialog = JColorChooser.createDialog(
					ColorChooserPanel.this, 
					"BackGround Color", 
					false, chooser, 
					new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							setBackground(chooser.getColor());
						}
					}, 
					null);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
		
		private JColorChooser chooser;
		private JDialog dialog;
		
	}
	
	/**
	 * Acest Listner afiseaza fereastra ne modala cu culori.Background se schimb imediat dupa alegere Culorii
	 */
	private class ImmediateListner implements ActionListener
	{
		public ImmediateListner()
		{
			chooser = new JColorChooser();
			chooser.getSelectionModel().addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent arg0) {
					// TODO Auto-generated method stub
					setBackground(chooser.getColor());
				}
			});
			
			dialog = new JDialog(
					(Frame) null,
					false);
			dialog.add(chooser);
			dialog.pack();
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
		JColorChooser chooser;
		JDialog dialog;
		
	}
}
