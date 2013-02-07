package Window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindowFrame()
	{
		setTitle("Windows Test");
		setSize(300, 300);
		
		JButton messageButton = new JButton("Salut");
		add(messageButton, BorderLayout.SOUTH);
		
		messageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(WindowFrame.this,"Salutare Domnule");
			}
		});
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new WindowFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
