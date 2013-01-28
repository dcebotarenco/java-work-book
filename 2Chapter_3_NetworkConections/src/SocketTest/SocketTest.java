package SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Aceasta programa creaaza un socket pentru conectarea  la ceasul din 
 * Boulder,statul Colorado
 * Afiseaza pe ecran timpul primit de pe server
 * @author Dan
 *
 */
public class SocketTest 
{
	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
			try
			{
				InputStream inStream = s.getInputStream();
				Scanner in = new Scanner(inStream);
				
				while(in.hasNextLine())
				{
					String line =  in.nextLine();
					System.out.println(line);
				}
			}
			finally
			{
				s.close();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
