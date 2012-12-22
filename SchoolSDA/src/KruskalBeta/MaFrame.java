package KruskalBeta;

import java.awt.BorderLayout;
import javax.swing.JFrame;
/**
 * The aplication is separated in seven classes.We have the MaFrame class to start
 * the program.These class extends JFrame class,just initialize the different classes(Dessin,North and South),
 * and place components of these classes on the good position.
 * 		Arc and Node classes are just classes respectively using Kruskal Class.This class is used to run Kruskal Algorithm.
 * The three main classes for general design of aplication are Dessin,North and South classes.
 * 		The Dessin class extends JPanel class.This class can disply all the design of vertices and arcs with graphics2D.
 * This Graphics2D class extends the Graphics class to provide more sophisticated control over geometry,coordinate transformations,
 * color management, and text layout.This is the fundamental class for rendering 2D shapes,text and images on the Java platform.
 * 		North and South classes must have an object Dessin to run, because it is with these classes that user will be say to the
 * aplication what he wants to do, and after the user say waht he want, the diplay must be refreshed.
 */
public class MaFrame extends JFrame 
{ 
/** 
 *  
 */ 
private static final long serialVersionUID = 1L; 
 Draw d=new Draw(); 
 North n = new North(d); 
 South s=new South(d); 
 public MaFrame() 
	{ 
	   super("Kruskal Algorithm"); 
	   setLayout(new BorderLayout()); 
	   this.add(n,BorderLayout.NORTH); 
	   this.add(d, BorderLayout.CENTER);  
	   this.add(s,BorderLayout.SOUTH); 
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	   this.setSize(800, 600); 
	} 
 public static void main(String[] args) 
	 {  
	    JFrame frame = new MaFrame(); 
	    frame.setVisible(true); 
	 } 
} 