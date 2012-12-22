package KruskalBeta;

import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.*; 
/**
 * 	The last main part allows the user to define arcs of the tree. He writes the first number of a 
 *	node then the second and to finish the weight of this arc. When the user writes theses three information’s, 
 *	he can clicks on the send’s button and the arc will be shape on the second main part with the node.
 *	There are for this part,three JtextField,three JLabel and two Jbutton. When the user enters all the information
 *	and clicks on the send's button, we pick up each information and we stock them on different string.We test if each string is
 *	a good number and if the user does not put two same node or number of node so high compared to the highest node.
 *	Finally we test if arc does not in the tree yet.
 *	If he does not in, we put the arc after the last arc that put in the tree.
 *		When the user enters all arcs that he wants, he can click on the step's button, the Kruskal algorithm will be run.
 *	The user must click on the step's button to see step by step the advence of program. 
 * @author Dan
 *
 */
public class South extends JPanel implements ActionListener
{ 

	 private static final long serialVersionUID = 1L; 
	 private JTextField attachment1 =new JTextField(""); 
	 private JTextField attachment2 =new JTextField(""); 
	 private JTextField valueOfArc =new JTextField(""); 
	  
	 private JButton send = new JButton("Deseneaza");  
	 private JButton step = new JButton("Solutia");
	  
	 private JLabel node1 = new JLabel("1 Nod"); 
	 private JLabel node2 = new JLabel("2 Nod"); 
	 private JLabel cost = new JLabel("Lungime"); 
	  
	 private String regularExpression = "([1-9][0-9]*)"; 
	 Draw d; 
	 public int numberOfNodes =50; 
	 Arc[]tree = new Arc[numberOfNodes*numberOfNodes];
	  
	 Kruskal k;  
	 private final JLabel author = new JLabel("llllllllllllllllllll");
	 private final JLabel lblCebotarencoDan = new JLabel("Cebotarenco Dan");
	  
	 public South( Draw d)
	 {   
		this.d=d; 
		initTree(tree); 
		setBackground(Color.black); 
		send.addActionListener(this); 
		step.addActionListener(this); 
		  
		node1.setForeground(Color.white); 
		this.add(node1); 
		attachment1.setColumns(4); 
		this.add(attachment1); 
		  
		node2.setForeground(Color.white); 
		this.add(node2); 
		attachment2.setColumns(4); 
		this.add(attachment2); 
		  
		cost.setForeground(Color.white); this.add(cost); 
		valueOfArc.setColumns(4);
		this.add(valueOfArc); 
		this.add(send); 
		this.add(step);

		author.setFont(new Font("SimSun-ExtB", Font.ITALIC, 10));
		author.setForeground(Color.BLACK);
		
		this.add(author);
		lblCebotarencoDan.setFont(new Font("SimSun-ExtB", Font.ITALIC, 10));
		lblCebotarencoDan.setForeground(Color.WHITE);
		
		add(lblCebotarencoDan);
	 } 
	  
	 public void initTree(Arc[]tree)
	 { 
		 for(int i=0;i<tree.length;i++)
		 { 
			 tree[i]=null; 
		 } 
	 } 
	  
	 public void actionPerformed(ActionEvent event)
	 { 
		if(d.again)
		{ 
		  initTree(tree); 
		  d.again=false; 
		} 
		if(event.getSource() == send)
		{ 
			   String c1=attachment1.getText(); 
			   String c2=attachment2.getText(); 
			   String c3=valueOfArc.getText(); 
			    
			  if(c1.matches(regularExpression ) && c2.matches(regularExpression ) && c3.matches(regularExpression ) )
			  {  
			     
				    int s1 =Integer.parseInt(c1); 
				    int s2 =Integer.parseInt(c2); 
				    int value=Integer.parseInt(c3); 
				     
				if(s1<=d.getNumberOfNodes() && s2<=d.getNumberOfNodes() && s1!=s2)
				{ 
				  Arc a = new Arc(s1,s2,value); 
				      
				   boolean already=false; 
				   int emplacement =0; 
				   int i=0; 
				   
				  while(tree[i]!=null && i<tree.length)
				  { 
					 if( ( tree[i].getNode1()==a.getNode1()||tree[i].getNode1()==a.getNode2())&&( tree[i].getNode2()==a.getNode1()||tree[i].getNode2()==a.getNode2() ) )
					 {           
					    emplacement=i; 
					    already =true; 
					 } 
					   i++; 
				  } 
				   if(!already)
				   { 
					    tree[d.getNumberOfArc()]=a; 
					    d.addArc(a,d.getNumberOfArc());				       
				   }
				   else
				   { 
					    tree[emplacement].setCost(value); 
					    d.modifArc(emplacement,value); 
				   } 
				      
				    d.repaint(); 
				}    
			 } 
		}
		else if(event.getSource()==step)
		{ 
			if(tree[0]!=null)
			{ 
				    if(d.getCpt()==0)
				    { 
					     if(d.getChoice().equals("Kruskal"))
					     { 
					    	 k=new Kruskal(tree , d.getNumberOfNodes(), d.getNumberOfArc()); 
					    	 d.finalTree=k.tree; 
					     }
					      
					   d.end=true; 
				    } 
				       
				    if(d.finalTree[d.getCpt()]!=null)
				    { 
				    	d.setCpt(d.getCpt()+1); 
				    } 
				    d.repaint(); 
		    } 
		}   
	 } 
} 
