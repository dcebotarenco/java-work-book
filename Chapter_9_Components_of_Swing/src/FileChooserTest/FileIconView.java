package FileChooserTest;

import java.io.File;

import javax.swing.Icon;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

public class FileIconView extends FileView
{
	/**
	 * Constructor FileIconView
	 * @param aFilter filtru - toate filurile care trec acest filtru sunt puse cu o pictograma speciala
	 * @param anIcon pictograma pentru filurile care trec filtru
	 */
public FileIconView (FileFilter aFilter,Icon anIcon)
	{
		filter = aFilter;
		icon = anIcon;
	}
	
	public Icon getIcon(File f)
	{
		if(!f.isDirectory() && filter.accept(f))
		{
			return icon;
		} else return null;
	}
	
	private FileFilter filter;
	private Icon icon;
}
