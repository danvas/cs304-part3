

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.event.EventListenerList;

public class ItemOperations extends AbstractTableOperations{

	boolean insert(String upc, String title, String type, String category, String company, String year, Double price, Integer stock){
		try {
			ps = con.prepareStatement("INSERT INTO item VALUES (?,?,?,?,?,?,?,?)");
			
			ps.setString(1,upc);
			
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

	boolean delete(String upc){
		try {
			ps = con.prepareStatement("DELETE FROM item WHERE upc = ?");
			ps.setString(1, upc);
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
//TODO: Fairly straightforward ManagerAddItem, see comment below. 
	//if upc null, return false
	//check if upc exists in item, if it does, add quantity to current (modify price if input)
	//if upc doesn't exist, insert all fields to Item
	void managerAddItem(String upc,Integer qty,Double price ){
		ResultSet rs;
		try {
			// finds tuple with given upc
			ps = con.prepareStatement("SELECT * FROM ITEM WHERE upc = ?");

			ps.setString(1, upc);
			//ps.setInt(2, qty);
			//			//if (price != null) {
			//				ps.setDouble(3, price);
			//			}
			//			else {
			//				ps.setNull(3, Types.DOUBLE);
			//			}		
			rs = ps.executeQuery();

			if (!rs.next()) {
				ps = con.prepareStatement("INSERT INTO items VALUES (?,?,?)");
				ps.setString(1, upc);
				ps.setInt(2, qty);
				if (price != null) {
					ps.setDouble(3, price);
				}
				else {
					ps.setNull(3, Types.DOUBLE);
				}

				rs = ps.executeQuery();
				con.commit();

				System.out.println("New Item added");
				//return false;
			}
			else {
				if (rs.next()) {
					ps = con.prepareStatement("UPDATE item SET price = ?, qty = qty + ? where upc = ?");
					ps.setString(3, upc);
					ps.setInt(2, qty);
					if (price != null) {
						ps.setDouble(1, price);
					}
					else {
						ps.setNull(1, Types.DOUBLE);
					}
					
					rs = ps.executeQuery();
					con.commit();
					//return true;
				}
			}	
		}
		catch (SQLException ex) {
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);
			//return false; 
		}
	}
	
//	public static void main(String args[])
//	{

//		System.out.println("test");
//
//		AMSOracleConnection oCon = AMSOracleConnection.getInstance();
//		oCon.connect("ora_o0g6", "a40493058");
//		oCon.connect("ora_h5n8", "a44140028");
//
//		ItemOperations item = new ItemOperations();



//		item.insert("999888", "test", "CD", "test", "test", "test", 999.99, 99);
//		item.insert("123457", "cpsc", "CD", "instrumental", "company", "year", 111.12, 27);
		
//		//item.displayItem();
//		item.delete("999888");
//		item.delete("999999");
//		item.delete("123457");
//
//	} 


}
