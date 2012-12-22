package Calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Panel cu butoanele calculatorului si elementele pentru afisare a resultatului calcularii
 * @author Dan
 *
 */
public class CalculatorPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean start;
	
	public CalculatorPanel()
	{
		setLayout(new BorderLayout());
		result = 0;
		lastCommand = "=";
		start = true;
		//Adaugarea elementului pentru afisarea resultatului
		
		display= new JButton("0");
		display.setEnabled(false);
		add(display,BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		
		//Adaugarea butoanelor 4x4
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		
		addButton("7",insert);
		addButton("8",insert);
		addButton("9",insert);
		addButton("/",command);
		
		addButton("4",insert);
		addButton("5",insert);
		addButton("6",insert);
		addButton("*",command);
		
		addButton("1",insert);
		addButton("2",insert);
		addButton("3",insert);
		addButton("-",command);
		
		addButton("0",insert);
		addButton(".",insert);
		addButton("=",command);
		addButton("+",command);
		
		add(panel,BorderLayout.CENTER);
	}
	/**
	 * Adaugarea butonului in panelul din centru
	 * @param label labelul pe buton
	 * @param listner litnerul ce activeaza butonul
	 */
	private void addButton(String label,ActionListener listner)
	{
		JButton button=new JButton(label);
		button.addActionListener(listner);
		panel.add(button);
	}
	/**
	 * La controlul evenimentului in linie,legata de buton se adauga la final textul.
	 */
	private class InsertAction implements ActionListener
	{		
		public void actionPerformed(ActionEvent event) 
		{
			String input = event.getActionCommand();
			if(start)
			{
				display.setText("");
				start=false;
			}
			display.setText(display.getText()+input);
		}
	}
	/**
	 * La controlul evenimentului se executa comanda care se indentifica dupa linie, legata cu butonul.
	 */
	private class CommandAction implements ActionListener
	{

		
		public void actionPerformed(ActionEvent event) 
		{
			String command = event.getActionCommand();
			if(start)
			{
				if(command.equals("-"))
				{
					display.setText(command);
					start=false;
				}
				else
					lastCommand = command;
			}
			else
			{
				calculate(Double.parseDouble(display.getText()));
				lastCommand = command;
				start=true;
			}
		}
		
	}
	/**
	 * Executarea calcularii
	 */
	public void calculate(double x)
	{
		if(lastCommand.equals("+")) result += x;
		else if (lastCommand.equals("-")) result -= x;
		else if (lastCommand.equals("*")) result *= x;
		else if (lastCommand.equals("/")) result /= x;
		else if (lastCommand.equals("=")) result = x;
		display.setText("" + result);
	}
}
