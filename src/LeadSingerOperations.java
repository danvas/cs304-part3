import java.sql.*;

public class LeadSingerOperations extends AbstractTableOperations {
	
	/* Insert tuple into LeadSinger Table
	 * Attributes upc and sname must be NOT NULL
	 */
	void insert(String upc, String sname){
		try {
			ps = con.prepareStatement("INSERT INTO leadsinger VALUES (?,?)");
			ps.setString(1, upc);
			ps.setString(2, sname);

			ps.executeUpdate();
			con.commit();
		}

		catch (SQLException ex)  {
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);

			try {
				con.rollback();
			}
			catch (SQLException ex2){
				event = new ExceptionEvent(this, ex2.getMessage());
				fireExceptionGenerated(event);
			}
		}
	}

	/*
	 * Deletes a tuple from LeadSinger table by specifying the upc
	 * upc is a foreign key referencing Item
	 */
	void delete(String upc){
		try {
			ps = con.prepareStatement("DELETE FROM leadsinger WHERE upc = ?");
			ps.setString(1, upc);
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
	 * Display LeadSinger table tuples
	 */
	public ResultSet display(){
		try {
			ps = con.prepareStatement("SELECT * FROM leadsinger", 
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