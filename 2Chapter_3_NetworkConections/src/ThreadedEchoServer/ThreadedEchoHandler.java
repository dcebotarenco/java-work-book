package ThreadedEchoServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoHandler implements Runnable
{
/**
 * Constructro Handler
 * @param socket Socketul de conectiune
 * @param counter counter de handlere
 */
	public ThreadedEchoHandler(Socket socket, int aCounter)
	{
		incoming = socket;
		counter = aCounter;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			try
			{
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				Scanner in = new Scanner(inStream);
				
				PrintWriter out = new PrintWriter(outStream, true);
				out.println("Hello! This is example of server " +
						"made on JAVA by CEBOTARENCO DAN :>");
				out.println("Write Something or :>");
				out.println("Enter BYE to exit :>");
				
				
				Scanner conlose = new Scanner(System.in);
				//Trimiterea daletor scrise de client inapoi
				boolean done = false;
				while(!done &&  in.hasNextLine())
				{
					String line = in.nextLine();
					System.out.println(line);
					String forSend = conlose.nextLine();
					out.println(forSend);
					if(line.trim().equals("BYE"))
					{
						done = true;
					}
				}
			}
			finally
			{
				incoming.close();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private Socket incoming;
	private int counter;
}
