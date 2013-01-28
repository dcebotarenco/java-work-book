package SwingWorkerTest;

import java.awt.EventQueue;

/**
 * Extinderea acestui class, poate descrie problem,care se executa
 * in regim asihron si face refresh la Swing.
 * @author Dan
 *
 */
abstract class SwingWorkerTask implements Runnable
{
	/**
	 * In acesta metoda de realizeaza rezolvarea problemei.
	 * Trebue de luat in consideratie ca pentru a face refresh la interface
	 * dupa executarea unui segment de lucru se folosesste
	 * metoda doUpdate ci NU update
	 */	
	public abstract void work() throws InterruptedException;
	
	/**
	 * Overload la aceasta metoda, se paote de realizat operatii cu interface,care se fac 
	 * pina a incepe lucrul
	 */
	public void init() {}
	
	/**
	 * OverLoad la acesta metoda, se poate de realizat operatii cu interface userului,care se
	 * petrec dupa un segment de lucru
	 */
	public void update() {}
	
	/**
	 * Overload la acesta metoda, 
	 * se poate de realizat operatii cu interfata dupa finisarea lucrului
	 */
	public void finish() {}
	
	private void doInit()
	{
		EventQueue.invokeLater(new 
				Runnable() 
		{
			
			public void run() 
			{					
				init();				
			}
		});
	}
	
	/**
	 * Aceasta metoda se cheama din metoda work() si face refrashe la interface dupe
	 * un segment de lucru
	 */
	protected final void doUpdate()
	{
		if(done) return;
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				update();
			}
		});
	}
	
	private void doFinish()	
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	public final void run()
	{
		doInit();
		try
		{
			done = false;
			work();
		}
		catch(InterruptedException ex) {}
		finally
		{
			done = true;
			doFinish();
		}
	}
	
	private boolean done;
}
