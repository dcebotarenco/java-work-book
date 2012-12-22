package Employee_3;

public class ParamTest 
{
	public static void main(String[] args)
	{
		//TEST 1: metodele nu pot schimba parametri numerici
		System.out.println("Testing tripleValue");
		double percent = 10;
		System.out.println("Before : percent ="+ percent);
		tripleValue(percent);
		System.out.println("After : percent = "+ percent);
		
		//TEST 2: metodele pot schimba starea obiectelor care sunt in calitate de parametru
		System.out.println("\nTesting tripleSalary:");
		Employee harry = new Employee("Harry", 50000);
		System.out.println("Before: salary="+ harry.getSalary());
		tripleSalary(harry);
		System.out.println("After: salary="+ harry.getSalary());
		
		//TEST 3: metodele nu pot scrie noi obiecte parametrilor, care sunt referinte la obiecte
		System.out.println("\nTesting swap:");
		Employee a = new Employee("Alice", 70000);
		Employee b = new Employee("Bod", 60000);
		System.out.println("Before: a= "+ a.getName());
		System.out.println("Before: b= "+ b.getName());
		swap(a,b);
		System.out.println("After: a="+ a.getName());
		System.out.println("After: b="+ b.getName());
	 
	}
	
	public static void tripleValue(double x) //NU lucreaza
	{
		x = 3 * x;
		System.out.println("End of method: x=" + x);
	}
	
	public static void tripleSalary(Employee x) // LUCREAZA
	{
		x.raiseSalary(200);
		System.out.println("End of methof: salary= " + x.getSalary());
	}
	
	public static void swap(Employee x,Employee y)
	{
		Employee temp = x;
		x = y;
		y = temp;
		System.out.println("End of method: x=" + x.getName());
		System.out.println("End of method: y=" + y.getName());
	}
}
