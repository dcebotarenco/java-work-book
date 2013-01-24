package AlgorithmAnimation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Semaphore;

/**
 * Acest Obiect Runnable executa sortarea
 * La compararea a 2 elemente algoritmul opreste calculul si 
 * face refresh la panel
 * @author Dan
 *
 */
public class Sorter implements Runnable
{

	/**
	 * Constructor de obiect Sorter
	 * @param values Massiv pentru sortare
	 * @param panel Panel, pe care va fi afisat procesul de sortare
	 */
	public Sorter(Double[] values, ArrayPanel panel)
	{
		this.values = values;
		this.panel = panel;
		this.gate = new Semaphore(1);
		this.run = false;
	}
	
	/**
	 * Schimba obiectul Sorter in starea de lucru fara oprire
	 */
	public void setRun()
	{
		run = true;
		gate.release();
	}
	
	/**
	 * Schimba obiectul SOrter in regim de lucru pe pasi
	 */
	public void setStep()
	{
		run = false;
		gate.release();
	}
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		Comparator<Double> comp = new Comparator<Double>() 
				{
					public int compare(Double i1,Double i2)
					{
						panel.setValues(values,i1,i2);
						try
						{
							if(run)
							{
								Thread.sleep(DELAY);
							}
							else
							{
								gate.acquire();
							}
						}
						catch(InterruptedException exception)
						{
							Thread.currentThread().interrupt();
						}
						return i1.compareTo(i2);
					}
				};
				Arrays.sort(values,comp);
				panel.setValues(values, null, null);
	}
	
	private Double[] values;
	private ArrayPanel panel;
	private Semaphore gate;
	private static final int DELAY = 100;
	private boolean run;
}
