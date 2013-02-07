package InterruptibleSocketTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InterruptibleSocketFrame extends JFrame 
{
	public InterruptibleSocketFrame()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("InterruptibleSocketTest");
		
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		messages = new JTextArea();
		add(new JScrollPane(messages));
		
		busyBox = new JCheckBox("Busy");
		northPanel.add(busyBox);
		
		startButton = new JButton("Start");
		northPanel.add(startButton);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				startButton.setEnabled(false);
				cancelButton.setEnabled(true);
				connectThread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						connect();
					}
				});
				connectThread.start();
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.setEnabled(false);
		northPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				connectThread.interrupt();
				startButton.setEnabled(true);
				cancelButton.setEnabled(false);
			}
		});
		
		server = new TestServer();
		new Thread(server).start();
	}
	
	/**
	 * Conectarea la Server
	 */
	public void connect()
	{
		try
		{
			SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189));
			try
			{
				in = new Scanner(channel);
				while(true)
				{
					if(in.hasNextLine())
					{
						String line = in.nextLine();
						messages.append(line);
						messages.append("\n");
					}
					else	Thread.sleep(100);
				}
			}
			finally
			{
				channel.close();
				messages.append("Socket Closed\n");
			}
		}
		catch(IOException e)
		{
			messages.append("\nInterruptibleSocketTest.connect : " + e);
		}
		catch(InterruptedException e)
		{
			messages.append("\nInterruptibleSocketTest.connect : " + e);
		}
	}
	
	/**
	 * Server multiStream, care asteapa connectarea pe portul 8189 si transmite clientului urmatoarele valori
	 * @author Dan
	 *
	 */
	class TestServer implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try
			{
				int i = 1;
				ServerSocket s = new ServerSocket(8189);
				
				while(true)
				{
					Socket incoming = s.accept();
					Runnable r  = new RandomNumberHandler(incoming);
					Thread t = new Thread(r);
					t.start();
				}
			}
			catch(IOException e)
			{
				messages.append("\nTestServer.run " + e);
			}
		}

	}
	
	/**
	 * Acest Clas prelucreaza datele , primite de la client inntri conectiune
	 * @author Dan
	 *
	 */	
	class RandomNumberHandler implements Runnable
	{
		/**
		 * Constructor de prelucrare
		 * @param i Socket
		 */
		public RandomNumberHandler(Socket i)
		{
			incoming = i;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try
			{
				OutputStream outStream = incoming.getOutputStream();
				PrintWriter out = new PrintWriter(outStream, true);/*Transmiterea automata a datelor ramase*/
				Random generator = new Random();
				while(true)
				{
					if(!busyBox.isSelected())
					{
						out.println(generator.nextInt());
					}
					Thread.sleep(100);
				}
			}
			catch (IOException e)
			{
				messages.append("\nRandomNumberHandler.run " + e);
			}
			catch (InterruptedException e)
			{
				messages.append("\nRandomNumberHandler.run " + e);
			}
		}
		private Socket incoming;
	}
	public static Scanner in;
	private JButton startButton;
	private JButton cancelButton;
	private JTextArea messages;
	private JCheckBox busyBox;
	private Thread connectThread;
	private TestServer server;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	
}
