package ConsoleWindow;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Fereastra pentru afisarea informatiei SYSTEM.oU descris in stream si System.err
 * @author Dan
 *
 */
public class ConsoleWindow 
{
	public static void init()
	{
		JFrame frame = new JFrame();
		frame.setTitle("ConsoleWindow");
		final JTextArea output = new JTextArea();
		output.setEditable(false);
		frame.add(new JScrollPane(output));
		frame.setSize(width, height);
		frame.setLocation(x, y);
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		
		PrintStream consoleStream = new PrintStream(new OutputStream() {
			
			public void write(int b){}
			@Override
			public void write(byte[] b,int off,int len) throws IOException {
				// TODO Auto-generated method stub
				output.append(new String(b,off,len));
			}
		});
		
		System.setOut(consoleStream);
		System.setErr(consoleStream);
	}
	
	public static final int width = 300;
	public static final int height = 200;
	public static final int x = 200;
	public static final int y = 200;
}
