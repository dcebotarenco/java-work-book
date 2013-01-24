package BlockingQueueTest;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class FileEnumerationTask implements Runnable
{
	/**
	 * Constructor FileEnumarationTask
	 * @param queue Coada blocata, incare sunt inserate fisierele
	 * @param startingDirectory Catalogul, din care se incepe numerotarea
	 */
	public FileEnumerationTask(BlockingQueue<File> queue,File startingDirectory)
	{
		this.queue = queue;
		this.startingDirectory = startingDirectory;
	}
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		try
		{
			enumerate(startingDirectory);
			queue.put(FICTIV);
		}
		catch (InterruptedException e) {}
	}
	
	/**
	 * Recursiv numeroteaza toate fisierele din catalog si din subcataoage
	 * @param directory Catalogul initial
	 */
	public void enumerate(File directory)
	throws InterruptedException
	{
		File[] files = directory.listFiles();
		for(File file: files)
		{
			if(file.isDirectory())
			{
				enumerate(file);
			}
			else
			{
				queue.put(file);
			}
		}
		
	}
	public static File FICTIV = new File("");
	
	private BlockingQueue<File> queue;
	private File startingDirectory;
}
