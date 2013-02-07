package ViewDB;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Frame ce contine panel cu date si butoane pentru schimbarea inscrerilor
 * @author Dan
 *
 */
public class ViewFrameDB extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewFrameDB() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		setTitle("ViewFrameDB");
		setSize(WIDTH, HEIGHT);
		
		tableNames = new JComboBox<String>();
		tableNames.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					showTable((String) tableNames.getSelectedItem());
			}
		});
		add(tableNames, BorderLayout.NORTH);
		
		try
		{
			conn = getConnection();
			meta = conn.getMetaData();
			createStatement();
			getTableNames();
			
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		if(scrolling)
		{
			previousButton = new JButton("Previous");
			previousButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					showPreviousRow();
				}
			});
			buttonPanel.add(previousButton);
		}
		
		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showNextRow();
			}
		});
		buttonPanel.add(nextButton);
		
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				try
				{
					if(conn != null) conn.close();
				}
				catch(SQLException e1)
				{
					while(e != null)
					{
						e1.printStackTrace();
						e1 = e1.getNextException();
					}
				}
			}
		});
	}
	
	/**
	 * Connectiunea la baza
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection()
	throws SQLException,IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		String url = "jdbc:mysql://localhost:3306/";
		String password = "qwerty";
		String user = "root";
		return DriverManager.getConnection(url+"test", user, password);
	}
	
	/**
	 * Crearea Obiectului Statement pentru executarea query
	 * Daca in baza de date , datele permit cursorul pentru a te misca intre ele
	 * aceasta se va folosi in formatarea obiectului
	 */
	public void createStatement() throws SQLException
	{
		if(meta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE))
		{
			stat = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY
					);
			scrolling = true;
		}
		else
		{
			stat = conn.createStatement();
			scrolling = false;
		}
	}
	
	/**
	 * Primirea numelelor tabelelor bazei de date si adaugarea lor in ComboBox
	 * @throws SQLException 
	 */
	public void getTableNames() throws SQLException
	{
		ResultSet mrs = meta.getTables(null, null, null, new String[] {"TABLE"});
		while(mrs.next())
		{
			tableNames.addItem(mrs.getString(3));
		}
		mrs.close();
	}
	
	/**
	 * Gatirea cimpurilor redactate pentru o noua tabela si afisarea primului Rind
	 */
	public void showTable(String tableName)
	{
		try
		{
			if(rs!= null) rs.close();
			rs = stat.executeQuery("Select * FROM " + tableName);
			if(scrollPane != null)			
			{
				remove(scrollPane);
			}
				dataPanel = new DataPanel(rs);
				scrollPane = new JScrollPane(dataPanel);
				add(scrollPane, BorderLayout.CENTER);
				validate();
				showNextRow();
			
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	/**
	 * trecerea la ultima accesata
	 */
	public void showPreviousRow()
	{
		try
		{
			if(rs == null || rs.isFirst())
			{
				return;
			}
			rs.previous();
			dataPanel.showRow(rs);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	public void showNextRow()
	{
		try
		{
			if(rs == null || scrolling && rs.isLast()) 
			{
				return;
			}
			
			if(!rs.next() && !scrolling)
			{
				rs.close();
				rs = null;
				return;
			}
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	private JComboBox<String> tableNames;
	private Connection conn;
	private java.sql.DatabaseMetaData meta;
	private Statement stat;
	private boolean scrolling;
	private ResultSet rs;
	private JScrollPane scrollPane;
	private DataPanel dataPanel;
	private JButton previousButton;
	private JButton nextButton;
}
