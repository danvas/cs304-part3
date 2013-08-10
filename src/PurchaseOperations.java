import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PurchaseOperations extends AbstractTableOperations {
	
	//TODO test 
	boolean insert(java.sql.Date date,String cid,String cardno, String expdate, java.sql.Date expected,java.sql.Date delivered){
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
	/*	
	 * Given a receipt number, this query lists all the items purchased, their 
	 * quantities and their prices. Total amount for the purchase to be calculated in Java code.
	 * */
	public void listItems(int receiptId){
		String q = "SELECT ititle as Title, I.upc, quantity, price FROM Item I, PurchaseItem PI WHERE I.upc=PI.upc AND receiptId=?";
//		int totalQty = 0; //uncomment for other uses
		double subtotal = 0.0;
		double totalPrice;
		double tax = 1.12;
		try {
			ps = con.prepareStatement(q);

			ps.setInt(1, receiptId);

			ResultSet rs = ps.executeQuery();
			System.out.println("Item    " + "\t" + "Quantity" + "\t" + "Price");
			System.out.println("-----------" + "\t" + "--------" + "\t" + "-----");
			while (rs.next()) {

				String item = rs.getString("Title");
				int qty = rs.getInt("quantity");
//				totalQty += qty; //uncomment for other uses
				double price = rs.getDouble("price");
				subtotal += price;
				System.out.printf(item + "%-12.12s" +  qty + "%-6.6s" + price + "\n", " ", " " );
				//System.out.println(item + "\t" + qty + "\t" + price);          // ************ item, qty, price OUTPUT TO GUI
			}
			System.out.println("\n\nSubtotal: "  + subtotal);                      // ************ subtotal OUTPUT TO GUI
			totalPrice = subtotal*tax; 
			DecimalFormat twoDForm = new DecimalFormat("#.##");
			totalPrice = (double) Double.valueOf(twoDForm.format(totalPrice)); // ************ totalPrice OUTPUT TO GUI
			System.out.println("Total: "  + totalPrice + "\n");
			System.out.println("Thank you for shoopping at AMS!\n");

		}
		catch (SQLException ex) {
			System.out.println("exception");
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);
			// no need to commit or rollback since it is only a query


		}
	}
	
	/*	
	 * Given a receipt number, finds purchase date, and last 5 digits of the card's number if exists
	 */	
	public void getDateCard(int receiptId){
		String cardno;
		String q =  "SELECT pdate as PurchaseDate, 'xxxxxxxxxxx' || SUBSTR(cardno, 12,5) as CardNumber " +
					"FROM Purchase " +
					"WHERE receiptId = ? AND cardno IS NOT NULL " +
					"UNION " +
					"SELECT pdate, cardno " +
					"FROM Purchase " +
					"WHERE receiptId = ? AND cardno IS NULL";

		try {
			ps = con.prepareStatement(q);

			ps.setInt(1, receiptId);
			ps.setInt(2, receiptId);

			ResultSet rs = ps.executeQuery();
			


			if(rs.next()){ // if cardno is null, don't assign cardno
				cardno = rs.getString("CardNumber"); // assign cardno string
			} else {
				cardno = rs.getString("CardNumber"); // assign cardno string
				 }
			
			
			Date pdate = rs.getDate("PurchaseDate");


			if(cardno == null){
				System.out.println("Receipt Number" + "\t" + "Purchase Date");
			System.out.println("--------------" + "\t" + "-------------");
				System.out.printf(receiptId + "%-12.12s" +  pdate + "\n\n", " " );  // ************ receiptId, pdate, cardno OUTPUT TO GUI
		}else {
				System.out.println("Receipt Number" + "\t" + "Purchase Date" + "\t" + "Credit Card");
			System.out.println("--------------" + "\t" + "-------------" + "\t" + "-----------------");
				System.out.printf(receiptId + "%-12.12s" +  pdate + "%-6.6s" + cardno + "\n\n", " ", " " );}  // ************ receiptId, pdate, cardno OUTPUT TO GUI


			//System.out.println(receiptId + "\t" +  pdate + "\t" + cardno );  // ************ receiptId, pdate, cardno OUTPUT TO GUI



		}
		catch (SQLException ex) {
			System.out.println("exception");
			System.out.println(ex.getMessage());
			ExceptionEvent event = new ExceptionEvent(this, ex.getMessage());
			fireExceptionGenerated(event);
			// no need to commit or rollback since it is only a query


		}
	}
	
	/*	Prints out receipt number, the date, 
	a list with the items purchased, their quantities and their prices, and the total 
	amount for the purchase.  If the customer pays by a credit card, the receipt should 
	show the last 5 digits of the card's number.
	 */	
	public void printReceipt(int receiptId){
		getDateCard(receiptId);
		listItems(receiptId);
	}
	
	//This method checks whether the items requested for purchase
	//also adds it to the array list in mainframe
	boolean isInStock (String upc, Integer qty){
		
		try{
			
			ps = con.prepareStatement("SELECT upc, price  FROM item where upc = ? AND stock >= ?");
			String rsupc;
			Double rsprice;
			String displayItem;
			
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

			System.out.println("About to execute query for instore purchase");
			
			ResultSet rs = ps.executeQuery();
			System.out.println("Just executed query and about to insert to GUI ItemList");
		
			while (rs.next())
			{
				rsupc = rs.getString(1);
				System.out.println(rsupc);
				rsprice = rs.getDouble(2);
				System.out.println(rsprice);
				displayItem = "                    "+rsupc+"               "+rsprice.toString()+"               "+qty.toString();
				MainFrame.addInstoreItemToPurchase(displayItem);
				MainFrame.savePurchaseItem(rsupc);
				MainFrame.savePurchaseItem(qty.toString());
			}
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

//TODO: IAN FINISH THIS METHOD
	
	public boolean addItemToVirtualBasket(String title, String category,String leadsinger, Integer qty){
		try {
			String rsupc;
			String rstitle;
			String rscategory;
			String rsleadsinger;
			Double rsprice;
			
			String qtitle = "";
			String qcat = "";
			String qls= "";
			String qqty = "";
			
			if(qty==null||qty==0)return false;
			else qqty = "AND i.stock >= "+qty.toString();
					System.out.println(qqty);
			if (title != null && !title.isEmpty()){
				qtitle = " AND i.ititle = '"+title+"'";
			}
			System.out.println(qtitle);
			if (category != null && !category.isEmpty()){
				qcat = " AND i.category = '"+category+"'";
			}
			System.out.println(qcat);
			if (leadsinger != null && !leadsinger.isEmpty()){
				qls = " AND l.sname = '"+leadsinger+"'";
			}
			System.out.println(qls);
			

			
			String statement = "SELECT i.upc, ititle, category, sname, price FROM Item i, LeadSinger l WHERE i.upc = l.upc "+qqty+qtitle+qcat+qls;
			//String statement = "SELECT * FROM Item i, LeadSinger l WHERE i.upc=l.upc";
			//String statement = "SELECT i.upc, i.ititle, i.category, l.sname, i.price FROM Item i inner join LeadSinger l on i.upc = l.upc WHERE "+qqty+qtitle+qcat+qls;

			
			System.out.println(statement);
			ps = con.prepareStatement(statement,ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			
			
			System.out.println("About to Execute Online Search");
//			ps=con.prepareStatement(statement);
//			
//			ps = con.prepareStatement("SELECT upc, ititle, category, sname, price FROM item i, leadsinger l WHERE i.upc = l.upc ? ? ? AND stock>=?");		
//			if (title!=null){
//				ps.setString(1," AND ititle = " + title);
//			}
//			else ps.setString(1,"");
//			
//			if(category!=null){
//				ps.setString(2, " AND category = "+category);
//			}
//			else ps.setString(2,"");
//			
//			if (leadsinger!=null){
//				ps.setString(3," AND sname = "+leadsinger);
//			}
//			else ps.setString(3,"");
//			
//			if (qty!=null){
//				ps.setInt(4, qty);
//			}
//			else return false;
			
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			int j = 0;
			System.out.println("Just Executed Online Item Search Query");
			while(rs.next()){
				
				System.out.println("We are in the loop");
				rsupc = rs.getString(1);
				System.out.println("Checking out rsupc value: "+rsupc);
				MainFrame.table_1.setValueAt(rsupc, i, j);
				j++;
				
				rstitle = rs.getString(2);
				System.out.println("Checking out rstitle value: "+rstitle);
				MainFrame.table_1.setValueAt(rstitle, i, j);
				j++;
				
				rscategory = rs.getString(3);
				System.out.println("Checking out rscat value: "+rscategory);
				MainFrame.table_1.setValueAt(rscategory, i, j);
				j++;
				
				rsleadsinger = rs.getString(4);
				System.out.println("Checking out rsls value: "+rsleadsinger);
				MainFrame.table_1.setValueAt(rsleadsinger, i, j);
				j++;
				
				rsprice = rs.getDouble(5);
				System.out.println("Checking out rsprice value: "+rsprice);
				MainFrame.table_1.setValueAt(rsprice, i, j);
				
				i++;
				j=0;
			}
			
			return true;
			
		} catch (SQLException ex) {
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
	// expected date not null for online purchases
	//for purchase, require receiptid.nextval, upc, cardno, expdate
	// for purchaseitem inserts, require receiptid.currentval,upc,qty
	public boolean completePurchase(String cardno, String cardexpdate){
		String upc;
		Integer qty;
		ArrayList<String> items = MainFrame.getPurchaseItems();
		java.util.Date pdate = new Date();
		java.sql.Date sqlpdate = new java.sql.Date(pdate.getTime());
			
		try {
			
			ps = con.prepareStatement("INSERT INTO purchase VALUES (purchase_receiptId.nextval, ?, ?, ?, ?, ? ,?)");
			ps.setDate(1, sqlpdate);
			ps.setString(2,null);
			if (cardno!=null&&!cardno.isEmpty()&&cardexpdate!=null&&!cardexpdate.isEmpty()){
				ps.setString(3,cardno);  //this is a card purchase
				ps.setString(4,cardexpdate);
			}
			else{
				ps.setString(3, null);  //this means this is a cash purchase
				ps.setString(4,null);
			}
			ps.setDate(5, null); // expecteddate
			ps.setDate(6,null); // deliverydate

			ps.executeUpdate();
			
			for(int i=0; i<MainFrame.getNumberInstorePurchaseItems();i++){
				upc = items.get(0);
				qty = Integer.parseInt(items.get(1));
				ps = con.prepareStatement("INSERT INTO PurchaseItem VALUES (purchase_receiptId.currval,?,?)");
				
				ps.setString(1,upc);
				ps.setInt(2,qty);
				
				ps.executeUpdate();
			}
						con.commit();
			return true;
			
		} catch (SQLException ex) {
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
//	public static void main(String args[])
//	{
//		
//	// Receipt tests:
//	AMSOracleConnection oCon = AMSOracleConnection.getInstance();
//
//	oCon.connect("ora_n7o8", "a36421089");
//	PurchaseOperations po = new PurchaseOperations();
//	System.out.println("test******** receipt w/card");
//	po.printReceipt(1001);
//	System.out.println("test******** receipt w/o card");
//	po.printReceipt(1004);
	
//		System.out.println("test");
//		
//		AMSOracleConnection oCon = AMSOracleConnection.getInstance();
////		oCon.connect("ora_o0g6", "a40493058");
//		oCon.connect("ora_h5n8", "a44140028");
//		
//		PurchaseOperations po = new PurchaseOperations();
//		
//
//		@SuppressWarnings("deprecation")
//		java.sql.Date date = new java.sql.Date(2013, 10, 10);
//

	
//		
//
//		
////		po.insert(date, "joe123", "666", "555", null, null);
////		po.insert(date, "joe123", "667", "555", null, null);
//		po.insert(date, "joe123", "test", "test", null, null);
//		
//		
//
//	} 
	
	
	
}


