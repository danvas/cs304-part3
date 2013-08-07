

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.event.EventListenerList;

public class ItemOperations extends AbstractTableOperations{

	boolean insert(Integer upc, String title, String type, String category, String company, String year, Double price, Integer stock){
		try {
			ps = con.prepareStatement("INSERT INTO item VALUES (?,?,?,?,?,?,?,?)");
			ps.setInt(1,upc.intValue());
			
			if (title != null){
				ps.setString(2,title);
			}
			else {
				ps.setString(2,null);
			}
			if (type!=null){
				ps.setString(3,type);
			}
			else{
				ps.setString(3,null);
			}
			if (category!=null){
				ps.setString(4,category);
			}
			else{
				ps.setString(4,null);
			}
			if (company!=null){
				ps.setString(5,company);
			}
			else {
				ps.setString(5,null);
			}
			if (year!= null){
				ps.setString(6,year);
			}
			else {
				ps.setString(6,null);
			}
			if (price!=null){
				ps.setDouble(7,price);
			}
			else {
				ps.setInt(7,-1);
			}

			ps.setInt(8, stock.intValue());
			ps.executeUpdate();
			con.commit();
			return true;
		}
		catch (SQLException ex){
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);

			try
			{
				con.rollback();
				return false; 
			}
			catch (SQLException ex2)
			{
				event = new ExceptionEvent(this, ex2.getMessage());
				fireExceptionGenerated(event);
				return false; 
			}
		}
	}
	boolean updateItem(int upc,int qty, double price){
		try{
			ps = con.prepareStatement("UPDATE item SET  ");

			return true;
		}
		catch(SQLException ex){
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);

			try
			{
				con.rollback();
				return false; 
			}
			catch (SQLException ex2)
			{
				event = new ExceptionEvent(this, ex2.getMessage());
				fireExceptionGenerated(event);
				return false; 
			}
		}
	}

	boolean delete(Integer upc){
		try {
			ps = con.prepareStatement("DELETE FROM item WHERE upc = ?");
			ps.setInt(1, upc);
			ps.executeUpdate();
			con.commit();
			return true;
		}
		catch (SQLException ex) {
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);

			try {
				con.rollback();
				return false;
			}
			catch (SQLException ex2) {
				event = new ExceptionEvent(this, ex2.getMessage());
				fireExceptionGenerated(event);
				return false;
			}
		}
	}

	void display(){

	}

//	public static void main(String args[])
//	{
//
//		System.out.println("test");
//
//		AMSOracleConnection oCon = AMSOracleConnection.getInstance();
//		oCon.connect("ora_o0g6", "a40493058");
//		//		oCon.connect("ora_h5n8", "a44140028");
//
//		ItemOperations item = new ItemOperations();
//
//
//
//		//		item.insertItem("9999999999999999", "test", "CD", "test", "test", "test", 999.99, 99);
////		item.insert(123456, "cpsc", "CD", "instrumental", "company", "year", 111.12, 27);
//		
//		//item.displayItem();
//		item.delete(123456);
//
//	} 


}
