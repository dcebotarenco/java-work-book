package ThreadedEchoServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**Aceasta programa realizeaza un server multiThread, care asteapta conectarea la 8189 
 * si returneaza clientului datele trimise de el
 * @author Dan
 *
 */
public class ThreadedEchoServer
{
	public static void main(String[] args)
	{
		try
		{
			int i =1 ;
			ServerSocket server = new ServerSocket(8189);
			
			while(true)
			{
				Socket incoming = server.accept();
				System.out.println("Connected "+ i);
				Runnable r = new ThreadedEchoHandler(incoming , i);
				Thread t = new Thread(r);
				t.start();
				i++;
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
