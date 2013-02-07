package ViewDB;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construcotor de panel pentru date.
	 */
	public DataPanel(ResultSet rs) throws SQLException
	{
		fields = new ArrayList<JTextField>();
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		for(int i = 1; i<= rsmd.getColumnCount();i++)
		{
			gbc.gridy = i-1;
			
			String columnName = rsmd.getColumnLabel(i);
			gbc.gridx=0;
			gbc.anchor = GridBagConstraints.EAST;
			add(new JLabel(columnName), gbc);
			
			int columnWidth = rsmd.getColumnDisplaySize(i);
			JTextField tb = new JTextField(columnWidth);
			fields.add(tb);
			
			gbc.gridx = 1;
			gbc.anchor = GridBagConstraints.WEST;
			add(tb,gbc);

		}
	}
	
	/**
	 * Afisarea Rindului. Cimpurile se umplu cu caloarea coleanelor
	 */
	public void showRow(ResultSet rs) throws SQLException
	{
		for(int i = 1; i<=fields.size();i++)
		{
			String field = rs.getString(i);
			JTextField tb = (JTextField) fields.get(i - 1);
			tb.setText(field);
		}
	}
	
	private ArrayList<JTextField> fields;
}
