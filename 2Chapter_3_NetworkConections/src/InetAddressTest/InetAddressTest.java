package InetAddressTest;

import java.net.InetAddress;

/**
 * Aceasta programa demonstreaza folosirea clasei InetAddress.In calidate de parametru in Consola se 
 * pune numele hostului.
 * Pentru a afla adresa locala a PC, trebue de rulat fara parametri
 * @author Dan
 *
 */
public class InetAddressTest 
{
	public static void main(String[] args)
	{
		try
		{
			if(args.length > 0)
			{
				String host = args[0];
				InetAddress[] addresses = InetAddress.getAllByName(host);
				for(InetAddress a : addresses)
				{
					System.out.println(a);
				}
			}
			else
			{
				InetAddress localHostAddress = InetAddress.getLocalHost();
				System.out.println(localHostAddress);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
