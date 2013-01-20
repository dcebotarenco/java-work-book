package ZipTest;

import java.io.File;
import java.util.ArrayList;

import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter extends FileFilter
{

	/**
	 * Adaugam extensie in ArrayList
	 * @param extension
	 */
		public void addExtension(String extension)
		{
			if(!extension.startsWith("."))
			{
				extension = "."+extension;
			}
			extensions.add(extension.toLowerCase());
		}
		
		public void setDescription(String aDescription)
		{
			description = aDescription;
		}
	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		if (f.isDirectory()) return true;
		String name = f.getName().toLowerCase();
		
		//Control de extensie
		for(String e: extensions)
		{
			if(name.endsWith(e))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}
	
	private String description = "";
	private  ArrayList<String> extensions = new ArrayList<String>();
}
