package AlgorithmAnimation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AnimationApplet extends JApplet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init()
	{
		
			ArrayPanel panel = new ArrayPanel();
			add(panel, BorderLayout.CENTER);
			
			Double[] values = new Double[VALUES_LENGTH];
			final Sorter sorter = new Sorter(values,panel);
			
			JButton runButton = new JButton("Run");
			runButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					sorter.setRun();
				}
			});
			
			JButton stepButton = new JButton("By Step");
			stepButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					sorter.setStep();
				}
			});
			
			JPanel buttons =new JPanel();
			buttons.add(runButton);
			buttons.add(stepButton);
			add(buttons, BorderLayout.NORTH);
			
			
			for(int i = 0; i<values.length;i++)
			{
				values[i] = new Double(Math.random());
			}
			
			Thread t = new Thread(sorter);
			t.start();
		
		
	}

	private static final int VALUES_LENGTH = 30;

}
