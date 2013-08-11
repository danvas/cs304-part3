import java.sql.*;

public class ReturnItemOperations extends AbstractTableOperations {

	/* Insert tuple into ReturnItem Table
	 * Attributes retid and upc must be NOT NULL
	 */
	boolean insert(String upc, int quantity){
		try {
			ps = con.prepareStatement("INSERT INTO returnitem VALUES (return_retid.currval,?,?)");
			
			ps.setString(1, upc);

			if (quantity != 0) {
				ps.setInt (2, quantity);
			}
			else {
				ps.setInt(2, 0);
			}
			System.out.println("inserting from RI class");
			ps.executeUpdate();

			con.commit();
			System.out.println("inserted via RI class");
			return true;
		}

		catch (SQLException ex)  {
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);
			System.out.println(ex.getMessage());
			try {
				con.rollback();
			}
			catch (SQLException ex2){
				event = new ExceptionEvent(this, ex2.getMessage());
				fireExceptionGenerated(event);
				System.out.println(ex2.getMessage());
			}
			return false;
		}
	}

	/*
	 * Deletes a tuple from return table by specifying the retid
	 */
	void delete(String retid){
		try {
			ps = con.prepareStatement("DELETE FROM returnitem WHERE retid = ?");
			ps.setString(1, retid);
			ps.executeUpdate();
			con.commit();
		}
		catch (SQLException ex) {
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);

			try {
				con.rollback();
			}
			catch (SQLException ex2) {
				event = new ExceptionEvent(this, ex2.getMessage());
				fireExceptionGenerated(event);
			}
		}
	}
	
	/*
	 * Display a read-only set of tuples from ReturnItem table
	 */
	public ResultSet display(){
		try {
			ps = con.prepareStatement("SELECT * FROM returnitem", 
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