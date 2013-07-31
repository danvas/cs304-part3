//package start;
import javax.swing.*;



public class GUI {

private static void createandshowGUI(){
	
	//****** this is a change to test GIT
	
	
	//creates and prepares window
	JFrame frame = new JFrame("Gui");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//add AMS Database Label
	JLabel label = new JLabel("AMS Database");
	frame.getContentPane().add(label);
	
	//Display the window
	frame.pack();
	frame.setVisible(true);
}

public static void main(String[] args){
	//schedule job for event-dispatching thread
	//creating  and showing this application's GUI
	javax.swing.SwingUtilities.invokeLater(new Runnable(){
		public void run(){
			createandshowGUI();
		}
	});
	}
}