package SwingThreadTest;

import java.util.Random;

import javax.swing.JComboBox;

/**
 * Acest Class Runnable modifica lista combo, random adaugind numere de la 0.
 * Acasta poate duce la greseala, deoarece metodele din combo nu sunt sincronizate
 * si la acelasi combo se adreseaza si thread-ul de lucru si threadul de conducere a evenimentelor.
 * @author Dan
 *
 */
public class BadWorkerRunnable implements Runnable
{
	public BadWorkerRunnable(JComboBox<Integer> acombo)
	{
		combo = acombo;
		generator = new Random();
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				combo.showPopup();
				int i = Math.abs(generator.nextInt());
				if(i%2 == 0)
				{
					combo.insertItemAt(new Integer(i), 0);
				}
				else if(combo.getItemCount() > 0)
				{
					combo.removeItemAt(i % combo.getItemCount());
				}
				Thread.sleep(1);
			}
		}catch(InterruptedException e) {}
	}
	private JComboBox<Integer> combo;
	private Random generator;
}
