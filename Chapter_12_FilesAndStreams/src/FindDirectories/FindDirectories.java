package FindDirectories;

import java.io.File;
import java.io.IOException;

public class FindDirectories 
{
	public static void main(String[] args)
	{
			//Daca parametri nu sunt pusi , cautarea se incepere la catalogul parinte
		if(args.length == 0) 
		{
			args = new String[] {".."};
		}
		
		try
		{
			File pathName =new File(args[0]);
			String[] fileNames = pathName.list();
			
			//Gasirea numelor filurilot din catalog
			for(int i = 0; i<fileNames.length; i++)
			{
				File f = new File(pathName.getPath(), fileNames[i]);
				
				//Daca file este in catalog, recursiv se cheama main.
				if(f.isDirectory())
				{
					System.out.println(f.getCanonicalPath());
					main(new String[] {f.getPath()});
				}
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
