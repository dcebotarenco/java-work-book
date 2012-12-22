package ArrayGrow;

import java.lang.reflect.Array;

public class ArrayGrowTest
{
	public static void main(String[] args)
	{
		int[] a ={1,2,3};
		a=(int[]) goodArrayGrow(a);
		arrayPrint(a);
		
		String[] b = {"Tom", "Dick", "Harry"};
		b=(String[]) goodArrayGrow(b);
		arrayPrint(b);
		
		System.out.println("The following call will generate an exception.");
		b=(String[]) badArrayGrow(b);
	}
	/**GRESIT
	 * Aceasta metoda ar trebue sa mareasca lungimea masivului , creind unul nou si copiind in el elemetele celui vechi
	 * @param a masivul, care trebue de marit
	 * @return masivul marit, continind toate elementele a
	 */
	static Object[] badArrayGrow(Object[] a)
	{
		int newLength = a.length * 11 /10 + 10;
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, a.length);
		return newArray;
	}
	/**CORECT
	 * Aceasta metoda mareste lungimea masivului, creind unul nou de acelasi tip si coopiind acolo elemetele a
	 * @param a masivul care trebue de marit, poate contine atit obiecte cit si tipuri primitive
	 * @return masivul marit cu elementele a
	 */
	static Object goodArrayGrow(Object a)
	{
		Class cl = a.getClass();
		if(!cl.isArray()) return null;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		int newLength = length * 11 / 10 + 10;
		
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, length);
		return newArray;
		
	}
	
	static void arrayPrint(Object a)
	{
		Class cl = a.getClass();
		if(!cl.isArray()) return;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		System.out.print(componentType.getName()+ "[" + length + "] = { ");
		for( int i=0 ; i<Array.getLength(a); i++)
		{
			System.out.print(Array.get(a,i) + " ");
		}
		System.out.println("}");
	}
}
