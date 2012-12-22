package Constants;

import java.awt.color.CMMException;

public class Constants 
{
	public static void main(String[] args)
	{
		final double CM_PER_INCH=2.54;
		double paperWidth=8.5;
		double PaperHeight=11;
		System.out.println("Size in cm : " + paperWidth*CM_PER_INCH + " on " + PaperHeight*CM_PER_INCH);
	}

}
