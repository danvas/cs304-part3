
public class Controller implements ExceptionListener{

	private HasSongOperations hso = null;
	private CustomerOperations co = null;
	private ItemOperations io = null;
	private LeadSingerOperations lso = null;
	private PurchaseOperations p = null;
	private PurchaseItemOperations pi = null;
	private ReturnOperations ro = null;
	private ReturnItemOperations rio = null;
	
	@Override
	public void exceptionGenerated(ExceptionEvent ex) {
		// TODO Auto-generated method stub
		
	}
	public Controller(){
		this.hso = new HasSongOperations();
		this.co = new CustomerOperations();
		this.io = new ItemOperations();
		this.lso = new LeadSingerOperations();
		this.p = new PurchaseOperations();
		this.pi = new PurchaseItemOperations();
		this.ro = new ReturnOperations();
		this.rio = new ReturnItemOperations();
		
		//Add this as exception listener to all operations classes
		hso.addExceptionListener(this);
		co.addExceptionListener(this);
		io.addExceptionListener(this);
		lso.addExceptionListener(this);
		p.addExceptionListener(this);
		pi.addExceptionListener(this);
		ro.addExceptionListener(this);
		rio.addExceptionListener(this);
	}
	public PurchaseOperations getPurchaseOps(){
		return this.p;
	}
	public PurchaseItemOperations getPurchaseItemOps(){
		return this.pi;
	}
	public CustomerOperations getCustomerOps(){
		return this.co;
	}
	public ItemOperations getItemOps(){
		return this. io;
	}
	public ReturnOperations getReturnOps(){
		return this.ro;
	}
	public ReturnItemOperations getReturnItemOps(){
		return this.rio;
	}
	public HasSongOperations getHasSongOps(){
		return this.hso;
	}
	public LeadSingerOperations getLeadSingerOps(){
		return this.lso;
	}
	
}
