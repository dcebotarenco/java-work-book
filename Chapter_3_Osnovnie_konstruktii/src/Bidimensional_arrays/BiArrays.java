package Bidimensional_arrays;

public class BiArrays 
{
	public static void main(String[] args)
	{
		final int STARTRATE = 10;
		final int NRATES = 6;
		final int NYEARS = 10;
		
		//Instalarea procentului de interes 10 ....15 %
		double[] interestRate = new double[NRATES];
		for(int j=0;j< interestRate.length;j++)
		{
			interestRate[j] = (STARTRATE + j)/100.0;
		}
		
		double[][] balances = new double[NYEARS][NRATES];
		
		//Suma initiala = 1000
		
		for (int j = 0; j<balances[0].length;j++)
		{
			balances[0][j]=10000;
		}
		
		//Calcularea balansului pe anii precedenti
		
		for(int i=1;i<balances.length;i++)
		{
			for(int j=0;j<balances[i].length;j++)
			{
				//Scoaterea balansului pe anul precedent
				double oldBalance = balances[i-1][j];
				
				//Calcularea procentului 
				double interest = oldBalance * interestRate[j];
				
				//Calcularea balansului pe anul curent
				balances[i][j]=oldBalance + interest;
			}
		}
		
		//Afisarea procentelor
		for (int j =0;j<interestRate.length;j++)
		{
			System.out.printf("%9.0f%%",100 * interestRate[j]);
		}
		
		System.out.println();
		//Afisarea tabeleo
		for(double[] row:balances)
		{
			//Afisarea rindurilor tabelei
			for(double b : row)
			{
				System.out.printf("%10.2f", b);
			}
			System.out.println();
		}
	}
}
