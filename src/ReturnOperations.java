import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
	
	/*
	 * Process a return for an item.
	 */
	public boolean returnItem(Integer receiptId, String upc) {
		ResultSet rs;

		try {
			// check if the item has already been returned
			ps = con.prepareStatement("SELECT r.retid, r.receiptid, rdate FROM return r, returnitem ri WHERE r.receiptId = ? AND ri.upc = ?");
			ps.setInt(1, receiptId);
			ps.setString(2, upc);
			System.out.println("Executing Query");
			
			rs = ps.executeQuery();
			System.out.println("Query Executed");
			ps.close();

			if (rs.next()) {
				System.out.println("Return already made");
				return true;
			}
			else {
				//TODO: fix date
				Date currdate = null;
				// If return made within 15 days, update tables below
				if (checkValidDate (receiptId)) {
					
					// Insert new tuple into Return table
					insert(receiptId, currdate);
					System.out.println("Inserted into Return");
					
					// Insert new tuple into ReturnItem table
					ReturnItemOperations rio = new ReturnItemOperations();
					rio.insert(upc, 1);
					System.out.println("Inserted into ReturnItem");
					
					// Increment stock with given upc in Item table
					ItemOperations io = new ItemOperations();
					io.updateItem(upc, 1, null);
					System.out.println("Updated stock on item");
					return true;
				}
				System.out.println("Return greater than 15 days");
				return false;
			}
		}
		catch (SQLException ex) {
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);
			System.out.println(ex.getMessage());
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
	 * Checks if return date is within 15 days
	 * TODO: does this work?
	 */
	boolean checkValidDate (Integer receiptId){
		
		Date pdate;
		String cid;
		String cardno;
		String expDate;
		String eDate;
		String dDate;
		
		
		
		try{

			ps = con.prepareStatement("SELECT * FROM purchase where receiptId = ?");

			if (receiptId != null)
			{
				ps.setInt(1, receiptId);
			}
			else ps.setNull(1,Types.INTEGER);
			


			ResultSet rs = ps.executeQuery();
			// get info on ResultSet
			  ResultSetMetaData rsmd = rs.getMetaData();

			  // get number of columns
			  int numCols = rsmd.getColumnCount();

			  System.out.println(" ");
			  
			  // display column names;
			  for (int i = 0; i < numCols; i++)
			  {
			      // get column name and print it

			      System.out.printf("%-15s", rsmd.getColumnName(i+1));    
			  }

			  System.out.println(" ");

			  while(rs.next())
			  {
			      // for display purposes get everything from Oracle 
			      // as a string

			      // simplified output formatting; truncation may occur

			      pdate = rs.getDate("pdate");
			      System.out.printf("%-15.15s", pdate);

			      cid = rs.getString("cid");
			      System.out.printf("%-15.15s", cid);

			      cardno = rs.getString("cardno");
			      if (rs.wasNull())
			      {
			    	  System.out.printf("%-15.15s", " ");
		              }
			      else
			      {
			    	  System.out.printf("%-15.15s", cardno);
			      }

			      expDate = rs.getString("EXPIRYDATE");
			      System.out.printf("%-15.15s", expDate);

			      eDate = rs.getString("EXPECTEDDATE");
			      if (rs.wasNull())
			      {
			    	  System.out.printf("%-15.15s\n", " ");
		              }
			      else
			      {
			    	  System.out.printf("%-15.15s\n", eDate);
			      } 
			      dDate = rs.getString("DELIVEREDDATE");
			      if (rs.wasNull())
			      {
			    	  System.out.printf("%-15.15s\n", " ");
		              }
			      else
			      {
			    	  System.out.printf("%-15.15s\n", dDate);
			      } 
			      
			  }
			  
			  
//		 
//			  // close the statement; 
//			  // the ResultSet will also be closed
//			  stmt.close();
//			}
//			
			
//			Date utilDate = new Date(sqlDate.getTime());
			
//			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			   //get current date time with Date()
//			   Date date = new Date();
//			   System.out.println(dateFormat.format(date));
		 
			   //get current date time with Calendar()
//			   Calendar cal = Calendar.getInstance();
			   
//			   System.out.println(dateFormat.format(cal.getTime()));
			   
//			   System.out.println(dateFormat.format(rs.getDate("pdate")));
//			   java.sql.Date sqlDate = dateFormat.format(rs.getTime(2));
			   
//			if (utilDate.before(cal.getTime()));
//				System.out.println("before");

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
		oCon.connect("ora_o0g6", "a40493058");
//		oCon.connect("ora_h5n8", "a44140028");
		
		ReturnOperations ro = new ReturnOperations();
		//ro.insert(1007, rdate)
		ro.checkValidDate(1005);
		

		
		

	}

}

