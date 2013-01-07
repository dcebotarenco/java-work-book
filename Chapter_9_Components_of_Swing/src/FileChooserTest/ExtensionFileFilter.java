package FileChooserTest;

import java.io.File;
import java.util.ArrayList;

import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter extends FileFilter
{

	/**
	 * Adaugarea extensie 
	 * @param extension Extensia (.txt)
	 */
	public void addExtension(String extension)
	{
		if(!extension.startsWith("."))
		{
			extension = "." + extension;
		}
		extensions.add(extension.toLowerCase());
	}
	
	/**
	 * Crearea desrieri filurilor, gasite de filtru
	 * @param aDescription Descrierea Filurilor
	 */
	public void setDescription(String aDescription)
	{
		description = aDescription;
	}
	/**
	 * Reintoarce descrierea filutiloe, gasite de filtru
	 * @return descrierea
	 */
	public String getDescription()
	{
		return description;
	}
	
	public boolean accept(File f)
	{
		if (f.isDirectory()) return true;
		String name = f.getName().toLowerCase();
		//Controlo daca filul se termina cu una din extensii
		for(String extension : extensions)
		{
			if(name.endsWith(extension))
			{
				return true;
			}
		}
		return false;
	}
	private String description = "";
	private ArrayList<String> extensions = new ArrayList<String>();
}
