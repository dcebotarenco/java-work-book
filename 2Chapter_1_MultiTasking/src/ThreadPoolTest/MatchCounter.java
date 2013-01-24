package ThreadPoolTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MatchCounter implements Callable<Integer>
{

	/**
	 * Constructor MatchCounter
	 * @param directory Catalog, de unde se incepe cautarea
	 * @param keyword Cuvintul cheie
	 */
	public MatchCounter(File directory, String keyword,ExecutorService pool)
	{
		this.directory= directory;
		this.keyword = keyword;
		this.pool = pool;
	}
	@Override
	public Integer call() throws Exception 
	{
		count = 0;
		
		try
		{
			File[] files = directory.listFiles();
			ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
			
			for(File file :files)
			{
				if(file.isDirectory())
				{
					MatchCounter counter = new MatchCounter(file, keyword,pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);

				}
				else
				{
					if(search(file)) count++;
				}
				
				for(Future<Integer> result : results)
				{
					try
					{
						count +=result.get();
					}
					catch (ExecutionException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		catch (InterruptedException e) {}
		return count;
	}

	
	/**
	 * Cautarea dupa keyWord, in fisier
	 * @param file Fisier, in care facem cautarea
	 * @return true, daca fisierul conOtine keyword
	 */
	
	public boolean search(File file)
	{
		try
		{
			Scanner in = new Scanner(new FileInputStream(file));
			boolean found = false;
			while(!found && in.hasNextLine())
			{
				String line =  in.nextLine();
				if(line.contains(keyword)) found = true;
			}
			in.close();
			return found;
		}catch (IOException e)
		{
			return false;
		}
	}
	private ExecutorService pool;
	private File directory;
	private String keyword;
	private int count;
}
