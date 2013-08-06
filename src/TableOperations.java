import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.event.EventListenerList;


public abstract class TableOperations {
	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected EventListenerList listenerList;
	
	protected TableOperations(){
		con = AMSOracleConnection.getInstance().getConnection();
		listenerList = new EventListenerList();
	}
	
	public void addExceptionListener(ExceptionListener l) 
    {
	listenerList.add(ExceptionListener.class, l);
    }


    public void removeExceptionListener(ExceptionListener l) 
    {
	listenerList.remove(ExceptionListener.class, l);
    }

    
    /*
     * This method notifies all registered ExceptionListeners.
     * The code below is similar to the example in the Java 2 API
     * documentation for the EventListenerList class.
     */ 
    public void fireExceptionGenerated(ExceptionEvent ex) 
    {
	// Guaranteed to return a non-null array
	Object[] listeners = listenerList.getListenerList();

	// Process the listeners last to first, notifying
	// those that are interested in this event.
	// I have no idea why the for loop counts backwards by 2
	// and the array indices are the way they are.
	for (int i = listeners.length-2; i>=0; i-=2) 
	{
	    if (listeners[i]==ExceptionListener.class) 
	    {
		((ExceptionListener)listeners[i+1]).exceptionGenerated(ex);
	    }
         }
     }
}
