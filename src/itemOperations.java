

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.event.EventListenerList;

import oracle.jdbc.driver.OracleConnection;

public class itemOperations {
	
	protected PreparedStatement ps = null;
	protected Connection con = null;
	protected EventListenerList listeners = new EventListenerList();
	
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
			
			ps.setInt(8, stock.intValue());
			
			return true;
		}
		catch (SQLException ex){
			
			
			
		 return false;
		}
	}
	
	boolean delete(){
		
	}
	
	void display(){
		
	}
}
