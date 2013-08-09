import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



public class PurchaseOperations extends AbstractTableOperations {
	
	private int receiptID;					// receipt id
	private String pdate; 					// date of purchase
	private String cardno; 					// card number
	private HashMap<String, Integer> items;
	private int quantities;
	private int total;
	

	//TODO test 
	boolean insert(Date date,String cid,String cardno, String expdate, Date expected,Date delivered){
		try{
			ps=con.prepareStatement("INSERT INTO purchase VALUES (purchase_receiptId.nextval,?,?,?,?,?,?)");
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
	//TODO: PLEASE TEST THIS IN GUI via display in SQL+. - Ian
	// tried this in GUI under Manager -> SetDeliveryDate and didn't work. 
	// The Query below is correct in SQLPlus - Allan

	boolean updateDeliveryDate(Integer receiptId,String stringdate){
		try{
			ps = con.prepareStatement("UPDATE purchase SET delivereddate = ? WHERE receiptId = ?");
			if(receiptId!=null){
				ps.setInt(2, receiptId);
			}
			else ps.setNull(2,Types.INTEGER);
			if(stringdate!=null){
				SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yy");
				java.util.Date utilDate = fm.parse(stringdate);
				java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
				ps.setDate(1,sqldate);
			}
			else{
				ps.setDate(1,null);
			}
			ps.executeUpdate();
			con.commit();
			System.out.println("Delivery Date Set");
			return true;
		}
		catch(SQLException | ParseException ex){
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


	//TODO test 
	boolean delete(Integer receiptId, Integer upc){
		try {
			ps = con.prepareStatement("DELETE FROM purchase WHERE receiptId = ? AND upc = ?");
			ps.setInt(1, receiptId);
			ps.setInt(2, upc);
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
	 * Display a read-only set of tuples from ReturnItem table
	 */
	public ResultSet display(){
		try {
			ps = con.prepareStatement("SELECT * FROM purchase", 
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

/*	Method to generate a receipt at the end of a purchase that shows, a receipt number, the date, 
	a list with the items purchased, their quantities and their prices, and the total 
	amount for the purchase.  If the customer pays by a credit card, the receipt should 
	show the last 5 digits of the card's number.
*/	
	
	
	public void printReceipt(int receiptId){
		System.out.println("in printReceipt(int)...");
		receiptID =receiptId;
		pdate = "aug.3,2013";				// date of purchase
		cardno = "45674"; 					// card number
		total = 0;
		try{

			ps = con.prepareStatement("SELECT * FROM purchase where receiptId = ?");
			ps.setInt(1, receiptId);
			ResultSet rs = ps.executeQuery();
			System.out.println("receiptID = " + receiptId);


		}
		catch(SQLException ex){
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);

			try {
				con.rollback();
				//return false; 
			}
			catch (SQLException ex2) {
				event = new ExceptionEvent(this, ex2.getMessage());
				fireExceptionGenerated(event);
				//return false; 
			}
		}
		
	}
	
	boolean isInStock (String upc, Integer qty){
		try{

			ps = con.prepareStatement("SELECT * FROM item where upc = ? AND stock >= ?");

			if (upc != null)
			{
				ps.setString(1, upc);
			}
			else
			{
				ps.setString(1, null);
			}

			if(qty!=null){
				ps.setInt(2, qty);
			}
			else ps.setNull(2,Types.INTEGER);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
			{
				return true; 
			}
			else
			{
				return false; 
			}
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
//TODO: IAN FINISH THIS METHOD
	
	public boolean addItemToVirtualBasket(String title, String category,String leadsinger, Integer qty){
		try {
			String rsupc;
			String rstitle;
			String rscategory;
			String rsleadsinger;
			Integer rsprice;
						
			ps=con.prepareStatement("Select upc, ititle, category, leadsinger, price FROM item i, leadsinger l WHERE i.upc = l.upc AND ititle = ? AND category = ? AND leadsinger = ? AND stock>= ?");
			if(title!=null){
			ps.setString(1, title);
			}
			else ps.setString(1, "*" );
			if(category!=null){
				ps.setString(2, category);
			}
			else ps.setString(2,"*");
			if (leadsinger!=null){
				ps.setString(3,leadsinger);
			}
			else ps.setString(3,"*");
			if (qty!=null){
				ps.setInt(4, qty);
			}
			else return false;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	

	
	public static void main(String args[])
	{
		
		System.out.println("test");
		
		AMSOracleConnection oCon = AMSOracleConnection.getInstance();
//		oCon.connect("ora_o0g6", "a40493058");
		oCon.connect("ora_h5n8", "a44140028");
		
		PurchaseOperations po = new PurchaseOperations();
		

		@SuppressWarnings("deprecation")
		java.sql.Date date = new java.sql.Date(2013, 10, 10);

		

		
//		po.insert(date, "joe123", "666", "555", null, null);
//		po.insert(date, "joe123", "667", "555", null, null);
		po.insert(date, "joe123", "test", "test", null, null);
		
		

	} 
	
}


