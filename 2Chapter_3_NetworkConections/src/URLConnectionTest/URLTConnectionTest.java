package URLConnectionTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLTConnectionTest 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		try
		{
			String urlName;
			urlName = in.nextLine();
			
			
			URL url = new URL(urlName);
			URLConnection connection = url.openConnection();
			
			//Setarea username si parola daca sunt indicate in cimp
			
			if(urlName.length() > 2)
			{
				String username = in.nextLine();
				String password = in.nextLine();
				String input = username + ":" + password;
				String encoding = base64Encode(input);
				
				connection.setRequestProperty("Authorization", "Basic "+ encoding);
			}
			connection.connect();
			
			//Afisarea cimpurilor din header
			
			Map<String, List<String>> headers = connection.getHeaderFields();
			
			for(Map.Entry<String, List<String>> entry: headers.entrySet())
			{
				String key = entry.getKey();
				for(String value : entry.getValue())
				{
					System.out.println(key + ": " + value);
				}
			}
			
			//Afisarea valorilor de cimpuri, primite cu ajutorul metodelor speciale
			System.out.println("--------");
			System.out.println("getContentType: " + connection.getContentType());
			System.out.println("getContentLenght: " + connection.getContentLength());
			System.out.println("getContentEncoding: " + connection.getContentEncoding());
			System.out.println("getDate: " + connection.getDate());
			System.out.println("getExpiration: " + connection.getExpiration());
			System.out.println("getLastModifed: " + connection.getLastModified());
			System.out.println("---------");
			
			Scanner inConnectionScanner = new Scanner(connection.getInputStream());
			
			//Afisarea primelor 10 rinduri de continut
			
			for(int n = 1; inConnectionScanner.hasNextLine() && n <=10; n++)
			{
				System.out.println(inConnectionScanner.nextLine());
			}
			if(inConnectionScanner.hasNextLine())
			{
				System.out.println("...");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Codificarea base64 Cimp
	 * @param s String
	 * @return String,codat
	 */
	public static String base64Encode(String s) 
	{
		ByteArrayOutputStream bOut =new ByteArrayOutputStream();
		Base64OutputStream out = new Base64OutputStream(bOut);
		try
		{
			out.write(s.getBytes());
			out.flush();
		}
		catch(IOException e)
		{
			
		}
		return bOut.toString();
	}
}
