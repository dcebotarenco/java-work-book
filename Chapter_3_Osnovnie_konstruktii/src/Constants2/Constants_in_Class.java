package Constants2;

public class Constants_in_Class 
{
	public static void main(String[] args)
	{
		double paperWidth = 8.5;
		double PaperHeight = 11;
		System.out.println("Size of paper in CM: " + paperWidth*CM_PER_INCH + " on " + PaperHeight*CM_PER_INCH);
	}
	
	public static final double CM_PER_INCH = 2.54;

}
