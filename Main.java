
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// safe bazi
		register registerrrr= new register();
		Profile profile= new Profile();
		profile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profile.setSize(650,480);
		profile.setVisible(true);
		
		// mohit chat
		Server application = new Server(register.name);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runServer();

	} // payan main

} // payan class Main
