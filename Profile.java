import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Profile extends JFrame {

	private Shapessss shapessss;
	private JLabel jLabel;
	private ImageIcon imageIcon;

	public Profile() {

		super(register.name);
		String x = JOptionPane.showInputDialog("Enter the order of matrix"); // gereftene
																				// andaze
																				// safe
		String n = JOptionPane.showInputDialog("Enter the number of players"); // gereftane
																				// tedad
																				// bazikon
		int number1 = Integer.valueOf(x);
		int number2 = Integer.valueOf(n);

		shapessss = new Shapessss(number1, number2);
		setLayout(null);
		shapessss.setBounds(0, 0, 450, 480);
		imageIcon = register.profile;
		jLabel = new JLabel(imageIcon);
		jLabel.setBounds(450, 10, 100, 80);
		add(jLabel);
		add(shapessss);

	} // payan constructor Profile

} // payan class Profile
