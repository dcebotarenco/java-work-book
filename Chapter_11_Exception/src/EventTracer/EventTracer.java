package EventTracer;

import java.awt.Component;
import java.awt.Container;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EventTracer 
{
	public EventTracer()
	{
		//Prelucrarea tuturor proxy
		handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				System.out.println(method + ":" + args[0]);
				return null;
			}
		};
	}
	
	/**
	 * Adauga obiecte EventTracer la toate evenimentele care pot fi 
	 * identificate la componentul dat si subclase
	 * @param c componet
	 */
	public void add(Component c)
	{
		try
		{
			//Luarea tuturor evenimentelor care pot pot fi citite
			
			BeanInfo info = Introspector.getBeanInfo(c.getClass());
			
			EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
			for(EventSetDescriptor eventSet : eventSets)
			{
				addListner(c,eventSet);
			}
		}catch(IntrospectionException e)
		{
			//Daca se genearaza o exceptie listnerii nu se adauga
		}
		
		if(c instanceof Container)
		{
			//Luarea tutturor obiectelor din subclasa
			//si recursiv se cheama metoda adds
			for(Component comp: ((Container) c).getComponents())
			{
				add(comp);
			}
		}
	}
	
	/**
	 * Adaugarea listnerului pentru activitati
	 * @param c Component
	 * @param eventSet descrierea listnerului
	 */
	public void addListner(Component c, EventSetDescriptor eventSet)
	{
		//Crearea proxyObiectului pentru tipul dat si redirectionarea chemerilor
		Object proxy = Proxy.newProxyInstance(null, new Class[] {eventSet.getListenerType()}, handler);
		//Adaugarea proxy in calitate de listner pentru component
		Method addListnerMethod = eventSet.getAddListenerMethod();
		try
		{
			addListnerMethod.invoke(c, proxy);
		}
		catch(InvocationTargetException e) {}
		catch(IllegalAccessException e) {}
		//Daca se genereaza o exceptie Listnerul nu se adauga
	}
	
	private InvocationHandler handler;
}
