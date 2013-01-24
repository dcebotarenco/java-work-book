package BlockingQueueTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class SearchTask implements Runnable
{

	/**
	 * Constructor SearchTask
	 * @param queue Coada, din case se scot filurile
	 * @param keyword Key de cautare
	 */
	public SearchTask(BlockingQueue<File> queue, String keyword)
	{
		this.queue = queue;
		this.keyword = keyword;
	}
	
	public void run() 
	{
		boolean done = false;
		try
		{
			while(!done)
				{
					File file = queue.take();
					if(file == FileEnumerationTask.FICTIV)
					{
						queue.put(file);
						done = true;
					}
					else
					{
						search(file);
					}
				}
		}
		catch(IOException e) {e.printStackTrace();}
		catch(InterruptedException e) {} 
	}
	
	/**
	 * Se executa cautare fisierului cu keyword si se afiseaza toare cimpurile,
	 * ce satisfac criteriului de cautare
	 * @param file File de cautare
	 */
	public void search(File file) 
	throws IOException
	{
		Scanner in = new Scanner(new FileInputStream(file));
		int lineNumber = 0;
		while(in.hasNextLine())
		{
			lineNumber++;
			String line = in.nextLine();
			if(line.contains(keyword))
			{
				System.out.printf("%s:%d:%s%n", file.getPath(),lineNumber,line);
			}
		}
		in.close();
	}
	private BlockingQueue<File> queue;
	private String keyword;
}
