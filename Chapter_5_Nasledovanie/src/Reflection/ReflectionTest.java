package Reflection;
import java.util.*;
import java.lang.reflect.*;
import java.lang.Class;

public class ReflectionTest 
{
	
	public static void main(String[] args)
	{
		//Numele clasei se scoate din consola sau se da de la claviatura
		String name;
		if(args.length > 0)
			name = args[0];
		else
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (e.g. java.util.Date): ");
			name = in.next();
		}
		
		try
		{
			//Afisarea numelui de clasa si superclase (if != Object)
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			System.out.print("class " + name);
			if (supercl != null && supercl != Object.class)
			{
				System.out.print(" extends "+ supercl.getName());
			}
			
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println("}");
		}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		System.exit(0);
	}
	
	/**
	 * Afisarea tutuorur constructorilor
	 * @param cl clasa
	 */
	public static void printConstructors(Class cl)
	{
		Constructor[] constructors = cl.getDeclaredConstructors();
		for(Constructor c: constructors)
		{
			String name = c.getName();
			System.out.print("  " + Modifier.toString(c.getModifiers()));
			System.out.print("  "+name+"(");
			//Afisarea tipului de parametru
			Class[] paramTypes = c.getParameterTypes();
			for(int j=0; j<paramTypes.length;j++)
			{
				if(j>0) System.out.print(",  ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	/**
	 * Afisarea tuturor metodelor
	 * @param cl clasa
	 */
	public static void printMethods(Class cl)
	{
		Method[] methods = cl.getDeclaredMethods();
		
		for(Method m : methods)
		{
			Class retType = m.getReturnType();
			String name = m.getName();
			//Afisarea modificatorilor,tipul care se returneaza si numele metodei
			System.out.print("   " + Modifier.toString(m.getModifiers()));
			System.out.print("  "+ retType.getName() + " " + name + "(");
			//Afisarea tipului de parametru
			Class[] paramTypes = m.getParameterTypes();
			for(int j=0; j<paramTypes.length;j++)
			{
				if(j>0) System.out.print(",  ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * Afisarea cimpurilor clasei
	 * @param cl clasa
	 */ 
	public static void printFields(Class cl)
	{
		Field[] fields = cl.getDeclaredFields();
		
		for(Field f : fields)
		{
			Class type = f.getType();
			String name = f.getName();
			System.out.print("   " + Modifier.toString(f.getModifiers()));
			System.out.println(" " + type.getName() + " " + name + ";");
		}
	}
}
