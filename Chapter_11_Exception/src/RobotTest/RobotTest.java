package RobotTest;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class RobotTest 
{
	public static void main(String[] args)
	{
		//Crearea Framului,  care contine panel cu butoane
		ButtonFrame frame = new ButtonFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//Legarea obiectului Robot cu ecranul
		GraphicsEnvironment enviroment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice screen = enviroment.getDefaultScreenDevice();
		
		try
		{
			Robot robot = new Robot(screen);
			run(robot);
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
		
		/**
		 * Pornirea procedurii de testare
		 * @param robot Obiectul Robor,legat cu ecranul
		 */
		
	}
	
	public static void run(Robot robot)
	{
		//Imitarea apasarii Space
		robot.keyPress(' ');
		robot.keyRelease(' ');
		
		//Imitarea apasarii <Tab> cu Space inpreuna
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(' ');
		robot.keyRelease(' ');
		
		//Imitarea clickului drept al mousului
		robot.delay(2000);
		robot.mouseMove(200, 50);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
		//Luarea continutului ecranului si afisarea imaginii primite
		robot.delay(2000);
		BufferedImage image  = robot.createScreenCapture(new Rectangle(0, 0, 400, 300));
		
		ImageFrame frame = new ImageFrame(image);
		frame.setVisible(true);
	}
}
