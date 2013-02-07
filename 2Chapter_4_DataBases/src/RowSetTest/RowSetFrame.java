package RowSetTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Frame ce contine panel ce contin date si butoane pentru interschimbarea intre metadate
 * @author Dan
 *
 */
public class RowSetFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RowSetFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		try
		{
			String infos = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(infos);
			SwingUtilities.updateComponentTreeUI(RowSetFrame.this);
		}
		catch(Exception e) {e.printStackTrace();}
		setTitle("RowTest");
		setSize(WIDTH, HEIGHT);
		JLabel variants = new JLabel("Variants");
		tableNames = new JComboBox<String>();
		tableNames.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try 
				{
					showTable((String) tableNames.getSelectedItem());
				} 
				catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JPanel panelNorth = new JPanel();
		panelNorth.add(variants);
		panelNorth.add(tableNames);
		add(panelNorth, BorderLayout.NORTH);
		
		try
		{
			Connection conn = getConnection();
			try
			{
				DatabaseMetaData meta = conn.getMetaData();
				ResultSet mrs = meta.getTables(null, null, null, new String[] {"TABLE"});
				while(mrs.next())
				{
					tableNames.addItem(mrs.getString(3));
				}
			}
			finally
			{
				conn.close();
			}
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				showPreviousRow();
			}
		});
		buttonPanel.add(previousButton);
		
		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				showNextRow();
			}
		});
		buttonPanel.add(nextButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				deleteRow();
			}
		});
		buttonPanel.add(deleteButton);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					saveChanges();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonPanel.add(saveButton);		
	}
	
	/**
	 * Pregatirea cimpurilor de editare pentru tabela noua si afisarea primului rind
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void showTable(String tableName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		
		try
		{
			Connection conn = getConnection();
			
			try
			{
				//Primirea setului de resultate
				Statement stat = conn.createStatement();
				ResultSet result = stat.executeQuery("SELECT * FROM "+ tableName);
				
			/*	while(result.next())
				{
					System.out.println(result.getString(1));
					System.out.println(", ");
					System.out.println(result.getString(2));
					System.out.println(result.getString(3));
					System.out.println("\n");
				}*/
				
				rs = new com.sun.rowset.CachedRowSetImpl();
				rs.setTableName(tableName);
				rs.populate(result);
				
			}
			finally
			{
				conn.close();
			}
			
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
	 * Trecerea la rindul trecut din tabel
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
	
	/**
	 * Trecerea la urmatoarul rind din tabla
	 */
	public void showNextRow()
	{
		try
		{
			if(rs == null || rs.isLast())
			{
				return;
			}
			rs.next();
			dataPanel.showRow(rs);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	/**
	 * Stergerea rindului curent din tabela
	 */
	public void deleteRow()
	{
		try
		{
			rs.deleteRow();
			if(!rs.isLast())
			{
				rs.next();
			}
			else if(!rs.isFirst())
			{
				rs.previous();
			}
			else
			{
				rs = null;
			}
			dataPanel.showRow(rs);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	/**
	 * Salvarea Schimbarilor
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void saveChanges() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
		try
		{
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			try
			{
				rs.acceptChanges(conn);
			}
			finally
			{
				conn.close();
			}
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	public static Connection getConnection()
	throws SQLException,IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		String url = "jdbc:mysql://localhost:3306/";
		String password = "qwerty";
		String user = "root";
		return DriverManager.getConnection(url+"test", user, password);
	}
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 300;
	
	private JComboBox<String> tableNames;
	private JButton previousButton;
	private JButton nextButton;
	private JButton deleteButton;
	private JButton saveButton;
	private CachedRowSet rs ;
	private JScrollPane scrollPane;
	private DataPanel dataPanel;
}
