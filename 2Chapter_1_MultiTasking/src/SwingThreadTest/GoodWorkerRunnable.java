package SwingThreadTest;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JComboBox;

/**
 * Acest Class Runnable modifica Combo lista,Random adaugind numere de la 0.
 * Pentru ca lista sa nu fie distrusa,opetatie de schimbare se redirectioneaza la THreadul
 * de conducere a evenimentelor
 * @author Dan
 *
 */
public class GoodWorkerRunnable implements Runnable
{
	public GoodWorkerRunnable(JComboBox<Integer> aCombo)
	{
		combo = aCombo;
		generator = new Random();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				EventQueue.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						combo.showPopup();
						int i = Math.abs(generator.nextInt());
						if(i % 2 == 0)
						{
							combo.insertItemAt(new Integer(i), 0);
						}
						else if(combo.getItemCount() > 0)
						{
							combo.removeItemAt(i%combo.getItemCount());
						}
					}
				});
				Thread.sleep(1);
			}
		}catch(InterruptedException e) {}
	}
	
	private JComboBox<Integer> combo;
	private Random generator;
}
