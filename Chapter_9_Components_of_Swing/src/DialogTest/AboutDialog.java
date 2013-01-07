package DialogTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AboutDialog(JFrame owner)
	{
		super(owner, "About DialogTest", true);
		//Label, care contine HTML format care se pune in mijloc
		
		add(new JLabel(
				"<html><hl><i>Exemplu de Dialog Frame</i></hl><hr>" + "By Cebotarenco Dan</html>"
				),BorderLayout.CENTER);
		//Cind apasam butonul OK trebue sa se inchida
		
		JButton ok =  new JButton("OK");
		ok.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		//Buttonul se adauga in partea de jos a ferestrei de dialog
		
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel,BorderLayout.SOUTH);
		
		setSize(WIDTH, HEIGHT);
	}
	
	private static final int WIDTH = 250;
	private static final int HEIGHT = 150;
}
