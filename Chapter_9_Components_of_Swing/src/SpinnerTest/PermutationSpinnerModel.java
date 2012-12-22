package SpinnerTest;

import javax.swing.AbstractSpinnerModel;

/**
 * Model ce genereaza dinamic permutarile literelor in cuvint
 * @author Dan
 *
 */
public class PermutationSpinnerModel extends AbstractSpinnerModel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructorul model
	 * @param w cuvintul pentru permutari
	 */
	public PermutationSpinnerModel(String w)
	{
		word = w;
	}
	
	public Object getNextValue() 
	{
		int[] codePoint = toCodePointArray(word);
		for(int i = codePoint.length - 1; i>0; i--)
		{
			if(codePoint[i-1] < codePoint[i])
			{
				int j = codePoint.length-1;
				while(codePoint[i-1]> codePoint[j])
					j--;
				swap(codePoint, i-1,j);
				reverse(codePoint,i,codePoint.length-1);
				return new String(codePoint,0,codePoint.length);
			}
		}
		reverse(codePoint, 0 , codePoint.length-1);
		return new String(codePoint,0,codePoint.length);
	}

	
	public Object getPreviousValue() 
	{
		int [] codePoint = toCodePointArray(word);
		for(int i = codePoint.length-1;i>0;i--)
		{
			if(codePoint[i-1] > codePoint[i])
			{
				int j = codePoint.length-1;
				while(codePoint[i-1] < codePoint[j])
					j--;
				swap(codePoint, i-1,j);
				reverse(codePoint,i,codePoint.length-1);
				return new String (codePoint, 0, codePoint.length);
			}
		}
		return null;
	}

	public Object getValue() 
	{
		return word;
	}


	public void setValue(Object value) 
	{
		if(!(value instanceof String))
			throw new IllegalArgumentException();
		word = (String) value;
		fireStateChanged();		
	}
	
	private static int[] toCodePointArray(String str)
	{
		int[] codePoint = new int[str.codePointCount(0, str.length())];
		for(int i=0,j=0;i<str.length(); i++,j++)
		{
			int cp = str.codePointAt(i);
			if(Character.isSupplementaryCodePoint(cp))
			{
				i++;
			}
			codePoint[j] = cp;
			
		}
		return codePoint;
	}
	
	private static void swap(int[] a, int i ,int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void reverse(int[] a,int i,int j)
	{
		while(i<j)
		{
			swap(a,i,j);
			i++;
			j--;
		}
	}
	private String word;
}
