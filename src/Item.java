import java.io.IOException;
import java.sql.*; 

import javax.swing.event.EventListenerList;


public class Item {
	protected PreparedStatement ps = null;
	protected EventListenerList listenerList = new EventListenerList();
	protected Connection con = null; 

	/*
	 * Default constructor
	 */ 
	public Item(){
		
		con = AMSOracleConnection.getInstance().getConnection();
	}

	public void insertItem(String upc, String iTitle, String type, String category, 
			String company, String year, double price, int stock)	{
		try
		{	   
			ps = con.prepareStatement("INSERT INTO item VALUES (?,?,?,?,?,?,?,?)");

			ps.setString(1, upc);
			ps.setString(2, iTitle);
			ps.setString(3, type);
			ps.setString(4, category);
			ps.setString(5, company);
			ps.setString(6, year);
			ps.setDouble(7, price);
			ps.setInt(8, stock);


			ps.executeUpdate();

			con.commit();


		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
			try 
			{
				// undo the insert
				con.rollback();	
			}
			catch (SQLException ex2)
			{
				System.out.println("Message: " + ex2.getMessage());
				System.exit(-1);
			}
		}
	}

	private void displayItem()
	{
		String     upc;
		String     iTitle;
		String     type;
		String     category;
		String     company;
		String     year;
		double 	   price;
		int 	   stock;
		Statement  stmt;
		ResultSet  rs;

		try
		{
			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT * FROM item");

			// get info on ResultSet
			ResultSetMetaData rsmd = rs.getMetaData();

			// get number of columns
			int numCols = rsmd.getColumnCount();

			System.out.println(" ");

			// display column names;
			for (int i = 0; i < numCols; i++)
			{
				// get column name and print it

				System.out.printf("%-15s", rsmd.getColumnName(i+1));    
			}

			System.out.println(" ");

			while(rs.next())
			{
				// for display purposes get everything from Oracle 
				// as a string

				// simplified output formatting; truncation may occur

				upc = rs.getString("upc");
				System.out.printf("%-10.10s", upc);

				iTitle = rs.getString("ititle");
				if (rs.wasNull())
				{
					System.out.printf("%-20.20s", " ");
				}
				else
				{
					System.out.printf("%-20.20s", iTitle);
				}

				type = rs.getString("type");
				if (rs.wasNull())
				{
					System.out.printf("%-20.20s", " ");
				}
				else
				{
					System.out.printf("%-20.20s", type);
				}
				
				category = rs.getString("category");
				if (rs.wasNull())
				{
					System.out.printf("%-20.20s", " ");
				}
				else
				{
					System.out.printf("%-20.20s", category);
				}
				
				company = rs.getString("company");
				if (rs.wasNull())
				{
					System.out.printf("%-20.20s", " ");
				}
				else
				{
					System.out.printf("%-20.20s", company);
				}
				
				year = rs.getString("year");
				if (rs.wasNull())
				{
					System.out.printf("%-20.20s", " ");
				}
				else
				{
					System.out.printf("%-20.20s", year);
				}

				price = rs.getDouble("price");
				if (rs.wasNull())
				{
					System.out.printf("%-20.20s", " ");
				}
				else
				{
					System.out.printf("%-20.20s", price);
				}
				
				stock = rs.getInt("stock");
				if (rs.wasNull())
				{
					System.out.printf("%-20.20s", " ");
				}
				else
				{
					System.out.printf("%-20.20s", stock);
				}
				System.out.println("");
			}

			// close the statement; 
			// the ResultSet will also be closed
			stmt.close();
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
		}	
	}

	
	public static void main(String args[])
	{
		
		System.out.println("test");
		
		AMSOracleConnection oCon = AMSOracleConnection.getInstance();
		oCon.connect("ora_o0g6", "a40493058");
//		oCon.connect("ora_h5n8", "a44140028");
		
		Item item = new Item();
		
		item.displayItem();
		
		item.insertItem("9999999999999999", "test", "CD", "test", "test", "test", 999.99, 99);
		item.insertItem("12345678901", "iTitle", "CD", "instrumental", "company", "year", 111.12, 27);
		//item.displayItem();

	} 
	
}