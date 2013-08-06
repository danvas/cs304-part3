import java.sql.SQLException;



public class CustomerOperations extends AbstractTableOperations{

	boolean insert(String cid, String pw,String cname, String address, String phoneno){
		try{
			ps = con.prepareStatement("INSERT INTO customer VALUES ?,?,?,?,?");
			if(cid!=null){
				ps.setString(1, cid);
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
	boolean login(){
		return false;
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
