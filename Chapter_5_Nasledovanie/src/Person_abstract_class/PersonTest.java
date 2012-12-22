package Person_abstract_class;

public class PersonTest 
{
	public static void main(String[] args)
	{
		Person[] people = new Person[2];
		
		//Completam masivul people cu obiectele Student si Employee
		
		people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		people[1] = new Student("Maria Morris", "Computer  Science");
		
		//Afisarea numelor si descrierea despre obiectele Person
		for(Person p : people)
		{
			System.out.println(p.getName() + ", " + p.getDescription());
		}
	}
}
