package BlockingQueueTest;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
		String directory = in.nextLine();
		System.out.print("Enter keyword (e.g. volatile): ");
		String keyword = in.nextLine();
		
		final int FILE_QUEUE_SIZE  = 100;
		final int SEARCH_THREADS = 100;
		
		BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
		
		FileEnumerationTask enumerator = 
				new FileEnumerationTask(queue, new File(directory));
		new Thread(enumerator).start();
		for(int i=1; i<=SEARCH_THREADS; i++)
		{
			new Thread(new SearchTask(queue,keyword)).start();
		}
	}
}
