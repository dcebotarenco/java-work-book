package FormatTest;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 * Verificator ce controleaza daca continutul cimpului este corect
 * @author Dan
 *
 */
public class FormattedTextFieldVerifier extends InputVerifier
{


	public boolean verify(JComponent input) 
	{
		JFormattedTextField field = (JFormattedTextField) input;
		return field.isEditValid();
	}

}
