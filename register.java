
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class register {
	public static ImageIcon profile;
	public static String name;

	public JButton[] avatars = new JButton[20];
	public int selectedAvatar = -1;

	public register() {
		Object complexMsg[] = new Object[22];
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 4, 10, 10));
		for (int i = 0; i < 20; i++) {
			JButton lb = new JButton(".");
			lb.setIcon(new ImageIcon("avatars/" + (i + 1) + ".jpg")); // gharar dadan har aks ber roye yek dokme 
			panel.add(lb);
			avatars[i] = lb;
			lb.setActionCommand(String.valueOf(i));
			lb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < 20; i++)
						avatars[i].setText(".");
					int n = Integer.valueOf(e.getActionCommand());
					avatars[n].setText("#");
					profile = new ImageIcon("avatars/" + (n + 1) + ".jpg");
					selectedAvatar = n;
					System.out.println(profile);
				}
			});
		} // payan for
		panel.add(new JLabel("name: "));
		JTextField name = new JTextField();
		panel.add(name);
		JOptionPane.showMessageDialog(null, panel, "player", JOptionPane.INFORMATION_MESSAGE);
		this.name = name.getText();
	} // payan constructor register
} // payan class register
