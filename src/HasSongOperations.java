import java.sql.*;
import javax.swing.event.EventListenerList;

public class HasSongOperations extends AbstractTableOperations {

	protected PreparedStatement ps = null;
	protected Connection con = null;
	protected EventListenerList listenerList = new EventListenerList();

	HasSongOperations(){
		con = AMSOracleConnection.getInstance().getConnection();
	}

	/* Insert tuple into HasSong Table
	 * Attributes upc and stitle must be not null
	 */
	void insert(String upc, String stitle){
		try {
			ps = con.prepareStatement("INSERT INTO HasSong VALUES (?,?)");
			ps.setString(1, upc);
			ps.setString(2, stitle);

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
			ps = con.prepareStatement("DELETE FROM hassong WHERE upc = ?");
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
	 * Display a Read-only HasSong table and its tuples
	 */
	public ResultSet display(){
		try {
			ps = con.prepareStatement("SELECT * FROM hassong", 
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