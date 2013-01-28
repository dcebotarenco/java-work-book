package SwingThreadTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingThreadFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SwingThreadFrame()
	{
		setTitle("SwingThreadTest");
		
		final JComboBox<Integer> combo = new JComboBox<Integer>();
		combo.insertItemAt(new Integer(Integer.MAX_VALUE), 0);
		combo.setPrototypeDisplayValue(combo.getItemAt(0));
		combo.setSelectedIndex(0);
		JPanel panel = new JPanel();
		
		JButton goodButton = new JButton("Good");
		goodButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Thread(new GoodWorkerRunnable(combo)).start();
			}
		});
		
		JButton badButton = new JButton("Bad");
		badButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new BadWorkerRunnable(combo)).start();
			}
		});
		
		panel.add(goodButton);
		panel.add(badButton);
		panel.add(combo);
		add(panel);
		pack();
	}
}
