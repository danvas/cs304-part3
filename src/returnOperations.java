import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;



public class returnOperations extends TableOperations {
	boolean insert(Integer receiptId,Date rdate){
		try {
			ps = con.prepareStatement("INSERT INTO return VALUES receipt_retid.nextval,?,?");
			if(receiptId!=null){
				ps.setInt(1, receiptId);
			}
			else{
				ps.setNull(1, Types.INTEGER);
			}
			if(rdate!=null){
				ps.setDate(2,rdate);
			}
			else{
				ps.setDate(2, null);
			}
			ps.executeUpdate();
			con.commit();
			return true;
		} 
		catch (SQLException ex) {
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
	//TODO
	void delete(){
		
	}
	//TODO
	void display(){
		
	}
}
