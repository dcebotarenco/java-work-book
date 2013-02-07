package PostTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PostTestFrame extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PostTestFrame()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("PostTest");
		
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		final JComboBox<String> combo = new JComboBox<String>();
		for(int i=0;i<countries.length; i+=2)
		{
			combo.addItem(countries[i]);		
		}
		northPanel.add(combo);
		
		final JTextArea result = new JTextArea();
		add(new JScrollPane(result));
		
		JButton getButton = new JButton("Get");
		northPanel.add(getButton);
		getButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						final String SERVER_URL = "http://www.census.gov/cgi-bin/ipc/idbsprd";
						result.setText("");
						Map<String, String> post = new HashMap<String,String>();
						post.put("tbl", "001");
						post.put("cty", countries[2*combo.getSelectedIndex()+1]);
						post.put("optyr", "lastest checked");
						try
						{
							result.setText(doPost(SERVER_URL, post));
						}
						catch(IOException e)
						{
							result.setText("" + e);
						}
					}
				}).start();
			}
		});
	}
	/**
	 * Creaza request POST si intoarce raspuns de la server.
	 * @param urlString URL, pe care se face requestu
	 * @param nameValuePairs Map cu date pentru request
	 * @return Raspuns de pe servet(luat ori din stream ce intra sau sin stream error)
	 */
	public static String doPost(String urlString, Map<String, String> nameValuePairs) 
			throws IOException
			{
				URL url = new URL(urlString);
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				
				PrintWriter out = new PrintWriter(connection.getOutputStream());
				boolean first = true;
				
				for(Map.Entry<String, String> pair : nameValuePairs.entrySet())
				{
					if(first) first =false;
					else out.print('&');
					String name = pair.getKey();
					String value = pair.getValue();
					out.print(name);
					out.print('=');
					out.print(URLEncoder.encode(value, "UTF-8"));
				}
				
				out.close();
				
				Scanner in;
				StringBuilder response = new StringBuilder();
				try
				{
					in = new  Scanner(connection.getInputStream());
				}
				catch(IOException e)
				{
					if(!(connection instanceof HttpURLConnection)) throw e;
					InputStream err = ((HttpURLConnection) connection).getErrorStream();
					if(err == null) throw e;
					in = new Scanner(err);
				}
				
				while(in.hasNextLine())					
				{
					response.append(in.nextLine());
					response.append("\n");
				}
				
				in.close();
				return response.toString();
			}
	
	private String[] countries = {"China", "Ethiopia", "Haiti", "Luxembourg", "Malta"
            , "Pakistan", "Russia", "Serbia", "Spain", "Turkey", "Uganda"
            , "USA"};
	public static final int WIDTH = 400;
	public static final int HEIGHT  = 300;
}
