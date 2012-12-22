package Timer;


import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest 
{
	public static void main(String[] args)
	{
		TimerPrinter listner = new TimerPrinter();
		//Crearea timerului, care cheama manipulatorul
		
		Timer t = new Timer(10000,listner);
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);
	}
}
