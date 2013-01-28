package TreeSetTest;

/**
 * Produs cu descriere si numar
 * @author Dan
 *
 */
public class Item implements Comparable<Item>
{

	/**
	 * Constructor de obiect, ce descrie produsul
	 * @param aDescription Descrierea
	 * @param aPartNumber Numarul produsului
	 */
	public Item(String aDescription, int aPartNumber)
	{
		description = aDescription;
		partNumber = aPartNumber;
	}
	
	/**
	 * Returneaza descrierea produsului
	 * @return Descrierea
	 */
	public String getDescription()
	{
		return description;
	}
	
	public String toString()
	{
		return "[decription="+description
				+ ", partNumber=" +partNumber + "]";
	}
	
	public boolean equals(Object otherObject)
	{
		if(this == otherObject) return true;
		if(otherObject == null) return false;
		if(getClass() != otherObject.getClass()) return false;
		Item other = (Item) otherObject;
		return description.equals(other.description) && partNumber == other.partNumber;
	}
	
	public int hashCode()
	{
		return 13*description.hashCode()+17*partNumber;
	}
	
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return partNumber - o.partNumber;
	}
	
	private String description;
	private int partNumber;
}
