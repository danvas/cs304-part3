import java.sql.*;



public class CustomerOperations extends AbstractTableOperations{

	//REGISTER CUSTOMER
	public boolean insert(String cid, String pw,String cname, String address, String phoneno){
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
	
	/*
	 * Login to AMS database if customer is registered
	 */
	//TODO finish 
	public boolean login(String cid, String pw){
		
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

	//	/*
//	 * Deletes a tuple from Customer table by specifying cid and password
//	 */
//	public boolean login(String cid, String pw){
//		//Statement stmt;
//		ResultSet rs;
//		
//		try {
//			System.out.println("in CustomerOperations.login()..."); //debugging printout
//
//			ps = con.prepareStatement("SELECT * FROM customer WHERE cid = ? AND password = ?"); 
//				
//			ps.setString(1, cid);
//			ps.setString(2, pw);
//			
//			rs = ps.executeQuery();
//			System.out.println("rs = "+ rs); //debugging printout
//					
//			System.out.println("exiting CustomerOperations.login()..."); //debugging printout
//
//			return true;
//		}
//	}
	
	/*
	 * Deletes a tuple from Customer table by specifying the cid
	 */
	public boolean delete(String cid){
	
		try {
			ps = con.prepareStatement("DELETE FROM customer WHERE cid = ?");
			ps.setString(1, cid);
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
	
	/*
	 * Display Customer table tuples
	 */
	public ResultSet display(){

		try {
			ps = con.prepareStatement("SELECT * FROM customer", 
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = ps.executeQuery();

			return rs; 
		}
		catch (SQLException ex) {
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);
			// no need to commit or rollback since it is only a query

			return null; 
		}
	
	}
}


