package QueryDB;

import java.awt.GridBagLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class QueryBDFrame extends JFrame
{
	/**
	 * Acest frame contine liste pentru introducerea parametrilor
	 * pentru query, TextArea pentru afisarea rezultatelor, si butoane
	 * pentru executarea query si update la date.
	 */
	private static final long serialVersionUID = 1L;

	public QueryBDFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		setTitle("QueryDB");
		setSize(WIDTH, HEIGHT);
		setLayout(new GridBagLayout());
		
		authors = new JComboBox<String>();
		authors.setEditable(false);
		authors.addItem("Any");
		
		publishers = new JComboBox<String>();
		publishers.setEditable(false);
		publishers.addItem("Any");
		
		result = new JTextArea(4,80);
		result.setEditable(false);
		
		priceChange = new JTextField(8);
		priceChange.setText("-5.00");
		
		try
		{
			conn = getConnection();
			Statement stat = conn.createStatement();
			
			String query = "SELECT Name FROM Authors";
			ResultSet rs = stat.executeQuery(query);
			while(rs.next())
			{
				authors.addItem(rs.getString(1));
			}
			rs.close();
			
			query = "SELECT Name FROM Publishers";
			rs = stat.executeQuery(query);
			while(rs.next())
			{
				publishers.addItem(rs.getString(1));
			}
			rs.close();
			stat.close();
		}
		catch(SQLException e)
		{
			result.setText("");
			while(e != null)
			{
				result.append("" + e);
				e = e.getNextException();
			}
		}
		catch(IOException e)
		{
			result.setText("" + e);
		}
		
		add(authors, new GBC(0,0,2,1));
		add(publishers, new GBC(2,0,2,1));
		
		JButton queryButton = new JButton("Query");
		queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				executeQuery();
			}
		});
		add(queryButton, new GBC(0,1,1,1).setInsets(3));
		
		JButton changeButton = new JButton("Change prises");
		changeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				ChangePrices();
			}
		});
		add(changeButton, new GBC(2,1,1,1).setInsets(3));
		
		add(priceChange, new GBC(3,1,1,1).setFill(GBC.HORIZONTAL));
		add(new JScrollPane(result), new GBC(0,2,4,1).setFill(GBC.BOTH).setWeight(100, 100));
		
		addWindowListener(new WindowAdapter() {
		
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				try
				{
					if(conn!= null) conn.close();
				}
				catch(SQLException e)
				{
					while(e != null)
					{
						result.append("" + e);
						e = e.getNextException();
					}
				}
				
			}
						
		});
		
	}
	
	/**
	 * Executarea Query;
	 */
	private void executeQuery()
	{
		ResultSet rs = null;
		try
		{
			String author = (String) authors.getSelectedItem();
			String publisher = (String) publishers.getSelectedItem();
			if(!author.equals("Any") && !publisher.equals("Any"))
			{
				if(authorPublisherQueryStmt == null)
				{
					authorPublisherQueryStmt = conn.prepareStatement(authorPublisherQuery);
					
				}
				authorPublisherQueryStmt.setString(1, author);
				authorPublisherQueryStmt.setString(2, publisher);
				rs = authorPublisherQueryStmt.executeQuery();
				
			}
			else if(!author.equals("Any") && publisher.equals("Any"))
			{
				if(authorQueryStmt == null)
				{
					authorQueryStmt = conn.prepareStatement(authorQuery);	
					
				}
				authorQueryStmt.setString(1, author);
				rs = authorQueryStmt.executeQuery();
				
			}
			else if(author.equals("Any") && !publisher.equals("Any"))
			{
				if(publisherQueryStmt == null)
				{
					publisherQueryStmt = conn.prepareStatement(publisherQuery);
					
				}
				publisherQueryStmt.setString(1, publisher);
				rs = publisherQueryStmt.executeQuery();
				
			}
			else
			{
				if(allQueryStmt == null)
				{
					allQueryStmt = conn.prepareStatement(allQuery);
					
				}
				rs = allQueryStmt.executeQuery();
				
			}
			
			result.append("");
			while(rs.next())
			{
				result.append(rs.getString(1));
				result.append(", ");
				result.append(rs.getString(2));
				result.append("\n");
			}
			rs.close();
		}
		catch(SQLException e)
		{
			result.setText("");
			while(e != null)
			{
				result.append("" + e);
				e = e.getNextException();
			}
		}
	}
	
	
	/**
	 * Update la Pret
	 */
	public void ChangePrices()
	{
		String publisher = (String) publishers.getSelectedItem();
		if(publisher.equals("Any"))
		{
			result.setText("I am sorry, But I cant do that");
			return;
		}
		try
		{
			if(priceUpdateStmt == null)
			{
				priceUpdateStmt = conn.prepareStatement(priceUpdate);
			}
			priceUpdateStmt.setString(1, priceChange.getText());
			priceUpdateStmt.setString(2, publisher);
			int r = priceUpdateStmt.executeUpdate();
			result.setText(r + "records updated");
		}
		catch(SQLException e)
		{
			result.setText("");
			while(e != null)
			{
				result.append("" + e);
				e = e.getNextException();
			}
		}
	}
	/**
	 * 
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
	
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 300;
	
	private Connection conn;
	private JComboBox<String> authors;
	private JComboBox<String> publishers;
	
	private JTextArea result;
	private JTextField priceChange;
	private java.sql.PreparedStatement authorQueryStmt;
	private java.sql.PreparedStatement authorPublisherQueryStmt;
	private java.sql.PreparedStatement publisherQueryStmt;
	private java.sql.PreparedStatement priceUpdateStmt;
	private java.sql.PreparedStatement allQueryStmt;
	
	private static final String authorPublisherQuery = 
			"SELECT Books.Price, Books.Title" +
			" FROM Books, BooksAuthors, Authors, Publishers"+
			" WHERE Authors.Author_Id = BooksAuthors.Author_Id"+
			" AND BooksAuthors.ISBN = Books.ISBN"+
			" AND Books.Publisher_Id = Publishers.Publisher_Id"+
			" AND Authors.Name = ?"+
			" AND Publishers.Name = ?";
	
	private static final String authorQuery =
			"SELECT Books.Price, Books.Title" +
			" FROM Books, BooksAuthors, Authors" +
			" WHERE Authors.Author_Id = BooksAuthors.Author_Id" +
			" AND BooksAuthors.ISBN = Books.ISBN" +
			" AND Authors.Name = ?";
	private static final String publisherQuery =
			"SELECT Books.Price, Books.Title FROM Books, Publishers"+
			" WHERE Books.Publisher_Id = Publishers.Publisher_Id"+
			" AND Publishers.Name = ?";
	private static final String allQuery =
			"SELECT Books.Price, Books.Title FROM Books";
	
	private static final String priceUpdate =
			"UPDATE Books " + "SET Price = Price + ?" +
			" WHERE Books.Publisher_Id =" +
			" (SELECT Publisher_Id FROM Publishers WHERE Name =?)";
			
}
