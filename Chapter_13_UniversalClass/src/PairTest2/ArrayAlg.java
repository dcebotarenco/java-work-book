package PairTest2;

public class ArrayAlg 
{
	/**
	 * Gaseste valoarea minimala si cea maximala a Obiectului tip T
	 * @param a Masiv de obiecte T
	 * @return Obiect Pair, care contine valoarea minima si cea maxima,
	 * 			daca masivul este gol atunci se returneaza null.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable> Pair<T> minmax(T[] a)
	{
		if(a==null || a.length == 0) return null;
		T min = a[0];
		T max = a[0];
		for(int i = 1 ;i<a.length; i++)
		{
			if (min.compareTo(a[i]) > 0) min = a[i];
			if (max.compareTo(a[i]) < 0) max = a[i];
		}
		
		return new Pair<T>(min, max);
	}
}
