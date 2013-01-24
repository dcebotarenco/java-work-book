package SynchBankTest2;

/**
 * Bank cu conturi
 * @author Dan
 *
 */
public class Bank 
{
	/**
	 * Constructor de Obiect, ce descrie bancul
	 * @param n numarul de conturi
	 * @param initialBalance suma initiala pentru fiecare cont
	 */
	public Bank(int n, double initialBalance)
	{
		accounts = new double[n];
		for(int i = 0; i<accounts.length;i++)
		{
			accounts[i] = initialBalance;
		}
		
	}
	
	/**
	 * Transmite banii depe un cont la altul
	 * @param from Contul, de pe care se scot banii
	 * @param to Contul, pe care vin banii
	 * @param amount Suma, care se va transmite
	 * 
	 */
	public synchronized void transfer(int from,int to,double amount)	
	throws InterruptedException
	{
		while(accounts[from] < amount) wait();
		
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount,from,to);
			accounts[to] += amount;
			System.out.printf("Total Balance: %10.2f%n",getTotalBalance());
		
			notifyAll();
		
		
	}
	
	/**
	 * Primirea sumei totale de pe toate conturile
	 * @return Suma totala
	 */
	public synchronized double getTotalBalance()
	{
			double sum = 0;
			for(double a: accounts)
			{
				sum += a;
			}
			return sum;
		
	}
	
	/**
	 * Primirea numarului de conturi in Banca
	 * return numarul de conturi
	 */
	public int size()
	{
		return accounts.length;
	}
	
	private double[] accounts;

}
