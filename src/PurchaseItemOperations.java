import java.sql.SQLException;
import java.sql.Types;

public class PurchaseItemOperations extends AbstractTableOperations{
 
	boolean insert(String receiptId, String upc, Integer qty){
		try{
			ps = con.prepareStatement("INSERT INTO PurchaseItem VALUES (?,?,?)");
			ps.setString(1, receiptId);
			ps.setString(2, upc);
			
			if(qty!= null){
				ps.setInt(3, qty);
			}
			else{
				ps.setNull(3, Types.INTEGER);
			}
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
	

	boolean delete(String receiptId,String upc){
		
		try{
			ps=con.prepareStatement("DELETE PurchaseItem WHERE receiptId = ?, upc = ?");
			if (receiptId != null){
				ps.setString(1,receiptId);
			}
			else {
				ps.setString(1,null);
			}
			
			if (upc != null){
				ps.setString(2,upc);
			}
			else {
				ps.setString(2,null);
			}
			ps.executeUpdate();
			con.commit();
			return true;
		}
		catch(SQLException ex){
			
		return false;
		}
	}
	
	boolean display(){
		return false;
	}
}
