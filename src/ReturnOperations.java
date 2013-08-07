import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;



public class ReturnOperations extends AbstractTableOperations {
	boolean insert(Integer receiptId,Date rdate){
		try {
			ps = con.prepareStatement("INSERT INTO return VALUES (receipt_retid.nextval,?,?)");
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
	/*
	 * Deletes a tuple from return table by specifying the retid
	 */
	Boolean delete(String retid){
		try {
			ps = con.prepareStatement("DELETE FROM return WHERE retid = ?");
			ps.setString(1, retid);
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

//	public ResultSet display(){
//		try {
//			ps = con.prepareStatement("SELECT * FROM return", 
//					ResultSet.TYPE_SCROLL_INSENSITIVE,
//					ResultSet.CONCUR_READ_ONLY);
//
//			ResultSet rs = ps.executeQuery();
//
//			return rs; 
//		}
//		catch (SQLException ex) {
//			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
//			fireExceptionGenerated(event);
//			// no need to commit or rollback since it is only a query
//
//			return null; 
//		}
//	}

}

