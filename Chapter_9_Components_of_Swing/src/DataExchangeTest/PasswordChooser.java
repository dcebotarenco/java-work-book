package DataExchangeTest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class PasswordChooser extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordChooser()
	{
		setLayout(new BorderLayout());
		
		//Crearea panului cu cimpurile pentru introducerea datelor
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(new JLabel("User Name:"));
		
		username = new JTextArea("");
		panel.add(username);
		
		panel.add(new JLabel("Password:"));
		password = new JPasswordField("");
		panel.add(password);
		add(panel, BorderLayout.CENTER);	
		
		//Crearea butoanelor OK si CANCEL
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ok  = true;
				setVisible(false);
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Punerea valorilor implicite
	 * @param u infomatia despre utilizator, implicit
	 */
	public void setUser(User u)
	{
		username.setText(u.getName());
	}
	
	/**
	 * Primirea informatiei introduse
	 * @return Obiect User, a carui varoare se afiseaza in informatia introdusa
	 */
	public User getUser()
	{
		return new User(username.getText(),password.getPassword());
	}
	
	/**
	 * Afisarea paneluilui pentru introducerea datelor
	 * @param parent frame parinte
	 * @param title titlu fereastra de dialog
	 */
	public boolean showDialog(Component parent, String title)
	{
		ok = false;
		
		//Gasirea frame-parinte
		Frame owner = null;
		if(parent instanceof Frame)
			owner = (Frame)parent;
		else 
			owner = (Frame)SwingUtilities.getAncestorOfClass(Frame.class, parent);
		
		if (dialog == null || dialog.getOwner() != owner)
		{
			dialog = new JDialog(owner,true);
			dialog.add(this);
			dialog.getRootPane().setDefaultButton(okButton);
			dialog.pack();
		}
		
		//Punerea titlului
		dialog.setTitle(title);
		dialog.setVisible(true);
		return ok;
	}
	
	private JTextArea username;
	private JPasswordField password;
	private JButton okButton;
	private JButton cancelButton;
	private JDialog dialog;
	private boolean ok = false;
	

}
