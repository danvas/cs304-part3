

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.event.EventListenerList;

public class itemOperations extends TableOperations{
	
	protected PreparedStatement ps = null;
	protected Connection con = null;
	protected EventListenerList listenerList = new EventListenerList();
	
	itemOperations(){
		con = AMSOracleConnection.getInstance().getConnection();
	}
	
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
	boolean delete(){
		return false;
		
	}
	
	void display(){
		
	}
	
	 
}
