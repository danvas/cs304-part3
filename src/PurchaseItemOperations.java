import java.sql.SQLException;

public class PurchaseItemOperations extends AbstractTableOperations{
 
	boolean insert(String receiptId, String upc, int qty){
		try{
			ps = con.prepareStatement("INSERT INTO PurchaseItem VALUES (?,?,?)");
			ps.setString(1, receiptId);
			ps.setString(2, upc);
			ps.setInt(3, qty);
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
			ps.setString(1,receiptId);
			ps.setString(2,upc);
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
