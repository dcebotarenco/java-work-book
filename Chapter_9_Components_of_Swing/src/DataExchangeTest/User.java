package DataExchangeTest;

public class User 
{
	public User(String aName, char[] aPassword)
	{
		name = aName;
		password = aPassword;
	}
	
	public String getName(){return name;}
	public char[] getPassword(){return password;}
	
	public void setName(String aName) {name = aName;}
	public void setPassword(char[] aPassword){password = aPassword;}
	
	private String name;
	private char[] password;
}
