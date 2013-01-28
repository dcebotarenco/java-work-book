package MapTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Acest Program foloseste Map cu Key String si Value de tip Employee
 * @author Dan
 *
 */
public class MapTest 
{
	public static void main(String[] args)
	{
		Map<String,Employee> staff = new HashMap<String,Employee>();
		
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hacker"));
		staff.put("157-62-7935", new Employee("Gary Cooper"));
		staff.put("456-62-5527", new Employee("Francesca Cruz"));
		
		//Afisarea tututotr valorilor
		System.out.println(staff);
		
		//Stergerea unui element din Map
		staff.remove("567-24-2546");
		
		//Inlocuirea unui elemnt din Map
		
		staff.put("456-62-5527", new Employee("Francesca Miller"));
		
		//Cautarea elemtului dupa key
		System.out.println(staff.get("157-62-7935"));
		
		//Toate valorile
		
		for(Map.Entry<String, Employee> entry: staff.entrySet())
		{
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key="+key + ", value=" + value);
		}
	}
}
