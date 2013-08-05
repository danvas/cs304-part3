import java.sql.*; 

public class OracleConnection {
	private static OracleConnection oCon = null;
	protected Connection con = null;
	protected boolean driverLoaded = false;
	
    /*
     * The constructor is declared protected so that only subclasses
     * can access it.
     */ 
    protected OracleConnection()
    {
	// empty
    }
    
    /*
     * Returns an instance of OracleConnection
     */ 
    public static OracleConnection getInstance()
    {
    	if (oCon == null)
    	{
    		oCon = new OracleConnection(); 
    	}

    	return oCon;
    }
    
    /*
     * connects to Oracle database named ug using user supplied username and password
     */ 
    private boolean connect(String username, String password)
    {

    	try 
    	{
    		String connectURL = "jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug";   

    		if (!driverLoaded) {
    			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    			driverLoaded = true;
    		}

    		con = DriverManager.getConnection(connectURL,username,password);

    		con.setAutoCommit(false);
    		System.out.println("\nConnected to Oracle!");
    		return true;
    	}
    	catch (SQLException ex)
    	{
    		System.out.println("Message: " + ex.getMessage());
    		return false;
    	}
    }
    
    /*
     * Returns the connection
     */
    public Connection getConnection()
    {
    	return con; 
    }
    
    /*
     * Sets the connection
     */
    public void setConnection(Connection connect)
    {
    	con = connect; 
    }
    
    /*
     * Returns true if the driver is loaded; false otherwise
     */ 
    public boolean isDriverLoaded()
    {
    	return driverLoaded; 
    }
    
    /*
     * This method allows members of this class to clean up after itself 
     * before it is garbage collected. It is called by the garbage collector.
     */ 
    protected void finalize() throws Throwable
    {		
    	if (con != null)
    	{
    		con.close();
    	}

	// finalize() must call super.finalize() as the last thing it does
	super.finalize();	
    }

    /*
     * Test main to check for Oracle Connection 
    public static void main (String args[]) {
    	getInstance();
    	oCon.connect("ora_o0g6", "a40493058");
    }
     */
}