package MailTest;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Frame pentru folosirea Interface-lui
 * @author Dan
 *
 */
public class MailTestFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MailTestFrame()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Gmail Prototype");
		
		setLayout(new GridBagLayout());
		
		//Folosim Classa GBC 
		add(new JLabel("From"), new GBC(0,0).setFill(GBC.HORIZONTAL));
		
		from=new JTextField(20);
		add(from, new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100, 0));
		
		add(new JLabel("To"), new GBC(0,1).setFill(GBC.HORIZONTAL));
		to=new JTextField(20);
		add(to,new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100, 0));
		
		add(new JLabel("Auth Password"), new GBC(0,2).setFill(GBC.HORIZONTAL));
		
		password = new JPasswordField(20);
		add(password, new GBC(1,2).setFill(GBC.HORIZONTAL).setWeight(100, 0));
		
		message = new JTextArea();
		add(new JScrollPane(message), new GBC(0,3,2,1)
								.setFill(GBC.BOTH)
								.setWeight(100, 100));
		
		comm =new JTextArea();
		add(new JScrollPane(comm), new GBC(0,4,2,1)
								.setFill(GBC.BOTH)
								.setWeight(100, 0));
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, new GBC(0,5,2,1));
		
		JButton sendButton = new JButton("Send");
		buttonPanel.add(sendButton);
		sendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						String pass = String.valueOf(password.getPassword());
						try 
						{
							GoogleMail.Send(from.getText(), pass, to.getText(), "", message.getText());
							comm.append("Mail Sent");
						} 
						catch (MessagingException e) 
						{
							e.printStackTrace();
						}
						
					}
				}).start();
			}
		});
	}

	private static final int WIDTH = 300;
	private static final int HEIGHT = 300; 
	
	private JTextField from;
	private JTextField to;
	private JPasswordField password;
	private JTextArea message;
	private JTextArea comm;

	
}
