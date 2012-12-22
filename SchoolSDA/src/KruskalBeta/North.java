package KruskalBeta;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * North Class allows the user to define numbers of node that he wants.
 * @author Dan
 *
 */
public class North extends JPanel implements ActionListener
{ 
	private static final long serialVersionUID = 1L; 
	/*
	 * We use JPanel to display number of nodes and then a JTextField to pick up the number of nodes that user wants and 
	 * to finish a button for send all of information.
	 */
	 private JTextField numberOfNodes =new JTextField(); 
	 private JButton sendButton = new JButton("Deseneaza");   
	 private JLabel node = new JLabel(" Numarul de Noduri"); 
	 private JLabel textName = new JLabel("Agoritmul Kruskal:    "); 
	 Draw d; 
	 private String regularExpression = "([0-9]*)"; 
	 public North(Draw d)
	 { 
		 this.d=d; 
		 setBackground(Color.black); 		
		 textName.setForeground(Color.WHITE); 
		 /*
		  * We connect the button to the listner, we define the disgh for the label, we fix
		  * tha size of the JTextField and we add all components to panel.
		  */
		 sendButton.addActionListener(this); 		  
		 this.add(textName); 
		 node.setForeground(Color.white); 
		 this.add(node); 
		 numberOfNodes.setColumns(4); 
		 this.add(numberOfNodes); 
		 this.add(sendButton); 
	 } 
	public void actionPerformed(ActionEvent e)
	{ 		
		/*
		 * When the user enters all information and when he 
			clicks on the send’s button, we pick up the text that 
			the user wants and we test if this text is a number
			and if the user enters something. If these conditions 
			are alright we update in the Dessin class the number 
			of nodes after we have converted the string in 
			integer.  
		 */
		String s=numberOfNodes.getText(); 
		if(s.matches(regularExpression) && s.length()>0)
		   { 
			   d.setNumberOfNodes(Integer.parseInt(s)); 
			   d.tree = new Arc[2500]; 
			   d.numberOfArc=0; 
			   d.setCpt(0); 
			   d.end=false; 
			   d.again=true; 
			   d.repaint(); 
		   } 
		
	} 
}