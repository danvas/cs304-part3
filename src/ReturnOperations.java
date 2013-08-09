import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



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

	boolean checkValidDate (Integer receiptId){
		int year;
		int month;
		int day;
		
		try{

			ps = con.prepareStatement("SELECT * FROM purchase where receiptId = ?");

			if (receiptId != null)
			{
				ps.setInt(1, receiptId);
			}
			else ps.setNull(1,Types.INTEGER);
			


			ResultSet rs = ps.executeQuery();
			if (rs != null)
				System.out.println("not null");
			
			
			
			
			
//			Date utilDate = new Date(sqlDate.getTime());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			   //get current date time with Date()
//			   Date date = new Date();
//			   System.out.println(dateFormat.format(date));
		 
			   //get current date time with Calendar()
			   Calendar cal = Calendar.getInstance();
			   
			   System.out.println(dateFormat.format(cal.getTime()));
			   
			   System.out.println(dateFormat.format(rs.getDate("pdate")));
//			   java.sql.Date sqlDate = dateFormat.format(rs.getTime(2));
			   
//			if (utilDate.before(cal.getTime()));
//				System.out.println("before");
			
			

//			

			
			
			
			
			
					
//			SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yy");
//			java.util.Date utilDate = fm.parse(stringdate);
//			java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
//			ps.setDate(1,sqldate);


			return true;
		}
		catch(SQLException ex){
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
	
	public static void main(String args[])
	{
		
		System.out.println("test");
		
		AMSOracleConnection oCon = AMSOracleConnection.getInstance();
//		oCon.connect("ora_o0g6", "a40493058");
		oCon.connect("ora_h5n8", "a44140028");
		
		ReturnOperations ro = new ReturnOperations();
		
		ro.checkValidDate(1005);
		

		
		

	}

}

