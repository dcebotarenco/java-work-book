package KruskalBeta;

import java.awt.* ; 
import javax.swing.*; 
/**
 *Draw is only the part where the trees will be shape. After the user chooses the 
 *number of node that he wants, nodes will be shape on the second part. On first time, the application 
 *shapes as much as oval that node define on the first main part. And it writes the number of each node in
 *their center.
 * @author Dan
 *
 */
public class Draw extends JPanel
{ 
	
	private static final long serialVersionUID = 1L;
	private int numberOfNodes=0; 
	private String choiceKp="Kruskal"; 
	  
	 Arc[] tree; 
	 public int numberOfArc=0; 
	  
	 Arc[] finalTree=new Arc[2500]; 
	 public boolean end=false; 
	 public boolean again=false; 
	 private int cpt=0; 
	  
	 public Draw() 
	 { 
		 tree = new Arc[2500]; 
		 setBackground(Color.white); 
	 } 
	  /*
	   * We call to the constructor of parent class to 
	   * initialize the graphics g, and we create a graphics2D 18
	   * from g.Then we recover the height and the width which 
	   * we will use to place different design. 
	   */
	 public void paint(Graphics g) 
	 { 
		super.paintComponent(g);   
		Graphics2D g2 = (Graphics2D) g; 
		int width = getSize().width; 
		int height = getSize().height; 
		double angle = 0; 
		Stroke s = g2.getStroke(); 
		  
		   for(int i=0;i<numberOfArc;i++)
		   {     
			   int node1=tree[i].getNode1(); 
			   int node2=tree[i].getNode2(); 
			   /*
			    * Now we will draw the initial arcs that the user 
			    * enters one by one. After the user clicks on the 
			  	* send’s button, we must refresh the display, and draw 
			  	* the last arc that the user enters. In a loop going of 
			  	* 0 to number of arcs, we will pick up the two vertices 
			  	* of each arc, and we will calculate the angle that its 
			  	* fact compared to the trigonometrical circle. 
			  	*/
			   angle =(node1-1)*(2*Math.PI / numberOfNodes); 
			   double angle1=(node2-1)*(2*Math.PI / numberOfNodes); 
			   g2.setColor(Color.gray); 
			   
			   /*
			    * 	Then we will calculate the coordinates to draw 
				*	the arc selected with the height and the width and 
				*	with cosine and sine.
			    */
				int x=(int)( (width/2)-( (width/4)*Math.cos(angle))+15 );   
				int y =(int) ( height/2- (height/4)*Math.sin(angle)+15 );   
				int x2=(int)( (width/2)-( (width/4)*Math.cos(angle1))+15 );   
				int y2=(int) ( height/2- (height/4)*Math.sin(angle1)+15 ); 
				       
				/*
				 * When we have the coordinates, we change the 
				 * color and we draw the line and this weight.
				 */
				g2.drawLine(x,y,x2,y2);     
				g.setColor(Color.gray); 
				g.drawString(""+(tree[i].getCost()),(int) ((x+x2)/2+30), (int) ((y+y2)/2 +30) ); 
		  } 
		    
		  for(int i=0;i<getCpt();i++)
		  { 
			  
			  if(finalTree[i]!=null)
			  { 
				  int top1=finalTree[i].getNode1(); 
				  int top2=finalTree[i].getNode2(); 
				      
				  angle =(top1-1)*(2*Math.PI / numberOfNodes); 
				  double angle1=(top2-1)*(2*Math.PI / numberOfNodes); 
				  
				  g2.setColor(Color.red); 
				  /*
				   *  After we test if the final tree is create. If the array is not empty and if the user
				   *  clicks on the step’s button, we draw as much arcs as the user hasclicked on the button. 
				   *  These arcs will be drawing in red and they will be largest. Before drawing we save the graphical context, 
				   *  we practice a zoom of two pixels, we draw arcs and weight of arcs and we 19restore the old graphical context.
				   */
				  g2.setStroke(new BasicStroke(2)); 
				  int x=(int)	((width/2)-( (width/4)*Math.cos(angle))+15 ); 			  
				  int y =(int) 	(height/2- (height/4)*Math.sin(angle)+15 ); 
				  int x2=(int) 	((width/2)-( (width/4)*Math.cos(angle1))+15 );   
				  int y2=(int) 	(height/2- (height/4)*Math.sin(angle1)+15 ); 
				        
				  g2.drawLine(x,y,x2,y2);     
				  g2.setStroke(s); 
				  g.setColor(Color.red); 
				  g.drawString(""+(finalTree[i].getCost()) , (int)((x+x2)/2 +30), (int) ((y+y2)/2 +30) ); 				    
			  } 
		   } 
		  angle=0; 
		  /*
		   * To finish we will draw each vertices. For each vertex we will change the color in dark gray and 
		   * we will draw oval around the trigonometrical circle. Then we change the color in white and we 
		   * draw the number of the vertex in the oval. At last we modifythe angle to be able to draw other vertex.
		   */
		  for(int i=0;i<numberOfNodes;i++)
		  { 
		    g2.setColor(Color.darkGray); 	     
		    g2.fillOval( (int)( (width/2)-( (width/4)*Math.cos(angle)) ), (int) ( height/2- (height/4)*Math.sin(angle) ), 30, 30) ; 
		    g.setColor(Color.white); 
		    g.drawString(""+(i+1) , (int)( (width/2)-( (width/4)*Math.cos(angle)) +10), (int) ( height/2- (height/4)*Math.sin(angle)+20 )); 
		    angle+=2*Math.PI / numberOfNodes; 
		  }  
		  
	 } 
	 public int getCpt()
	 { 
		 return cpt;  
	 } 
	 public void setCpt(int i)
	 { 
		 this.cpt=i;  
	 } 
	  
	 public int getNumberOfNodes()
	 { 
		 return numberOfNodes;  
	 } 
	  public void setNumberOfNodes(int i)
	 { 
		  this.numberOfNodes = i ; 
	 } 
	  
	 public void setChoice(String s)
	 { 
		 this.choiceKp = s ; 
	 } 
	  
	 public String getChoice()
	 { 
		 return choiceKp; 
	 } 
	  
	 public int getNumberOfArc()
	 { 
		 return numberOfArc; 
	 } 
	  
	 public void addArc(Arc a,int nbarc)
	 { 
		tree[nbarc]=a; 
		numberOfArc++; 
	 } 
	  
	 public void modifArc(int emplacement, int poid)
	 { 
		 tree[emplacement].setCost(poid); 
	 } 
}
