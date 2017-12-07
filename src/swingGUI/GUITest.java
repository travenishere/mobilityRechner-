package swingGUI;

import javax.swing.*;

public class GUITest {

	private static void createAndShowGUI() {
        MainFrame frame = new MainFrame("Mobility Rechner");
    }
	
	public static void main(String[] args) {
		
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		
	}
	
	
}
