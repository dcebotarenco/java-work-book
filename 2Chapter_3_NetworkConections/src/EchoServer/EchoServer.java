package EchoServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer 
{
	public static void main(String[] args)
	{
		try
		{
			//Crearea soketului in partea serverului
			ServerSocket s =new ServerSocket(8189);
			
			//Asteptarea conectiunii clientului
			Socket incoming = s.accept();
			try
			{
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				Scanner in = new Scanner(inStream);
				/*Trimiterea automata a datelor ramase*/
				PrintWriter out = new PrintWriter(outStream, true);
				out.println("Hello! Enter BYE to exit.");
				
				//trimiterea clientului datele primite de server
				boolean done = false;
				while(!done && in.hasNextLine())
				{
					String line = in.nextLine();
					out.println("Echo: " + line);
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
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
