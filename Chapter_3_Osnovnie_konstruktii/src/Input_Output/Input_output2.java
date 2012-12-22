package Input_Output;
import java.util.Date;

import javax.swing.*;
public class Input_output2 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String name = JOptionPane.showInputDialog("What is you name?");
		String age = JOptionPane.showInputDialog("How old are you?");
		int ages = Integer.parseInt(age);
		System.out.println(name + ", next year you will have " + (ages + 1));
		System.out.printf("%1$s %2$tB %2$te, %2$tY","Date :",new Date());
		System.exit(0);
		

	}

}
