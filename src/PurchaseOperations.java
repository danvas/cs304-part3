import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;



public class PurchaseOperations extends AbstractTableOperations {
	
	boolean insert(Date date,String cid,String cardno, String expdate, Date expected,Date delivered){
		try{
			ps=con.prepareStatement("INSERT INTO purchase VALUES purchase_receiptId.nextval,?,?,?,?,?,?");
			if (date!=null){
				ps.setDate(1, date);
			}
			else{
				ps.setDate(1,null);
			}
			if(cid!=null){
				ps.setString(2,cid);
			}
			else{
				ps.setString(2,null);
			}
			if (cardno!=null){
				ps.setString(3,cardno);
			}
			else{
				ps.setString(3, null);
			}
			if(expdate!=null){
				ps.setString(4,expdate);
			}
			else{
				ps.setString(4,null);
			}
			if(expected!=null){
				ps.setDate(5, expected);
			}
			else{
				ps.setDate(5,null);
			}
			if(delivered!=null){
				ps.setDate(6,delivered);
			}
			else{
				ps.setDate(6,null);
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
	
	boolean updateDeliveryDate(Integer receiptId,Date ddate){
		try{
			ps = con.prepareStatement("UPDATE purchase SET delivereddate = ? WHERE receiptId = ?");
			if(receiptId!=null){
				ps.setInt(2, receiptId);
			}
			else ps.setNull(2,Types.INTEGER);
			if(ddate!=null){
				ps.setDate(1,ddate);
			}
			else{
				ps.setDate(1,null);
			}
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
	
	//TODO
	void delete(){
		
	}
	
	//TODO
	void display(){
		
	}
}
