package MenuTest;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class TestAction extends AbstractAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TestAction(String name)
	{
		super(name);
	}
	public void actionPerformed(ActionEvent arg0) 
	{
		System.out.println(getValue(Action.NAME) + " selected");
	}

}
