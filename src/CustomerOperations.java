import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CustomerOperations extends AbstractTableOperations{

	//REGISTER CUSTOMER
	boolean insert(String cid, String pw,String cname, String address, String phoneno){
		try{
			ps = con.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?)");
			
			ps.setString(1, cid);
			ps.setString(2,pw);
			ps.setString(3,cname);
			ps.setString(4,address);
			ps.setString(5,phoneno);

			ps.executeUpdate();
			con.commit();
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
	
	//TODO finish 
	boolean login(String cid, String pw){
		
		ResultSet rs;
		
		try {
			ps = con.prepareStatement("SELECT * FROM customer WHERE cid = ? AND password = ?"); 
				
			ps.setString(1, cid);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			System.out.println("Just executed query")	;	

if (rs.next()) return true;
else return false;
			
			
		}
		catch (SQLException ex) {
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);
			// no need to commit or rollback since it is only a query

			return false; 
		}
	}
	
	//TODO
	boolean delete(){
	
		return false;
	}
	
	//TODO
	boolean display(){
		
		return false;
	}
}
