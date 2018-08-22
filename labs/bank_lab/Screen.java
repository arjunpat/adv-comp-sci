import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener {
	private ArrayList<Account>() accounts;


	public Screen() {
		this.setLayout(null);

		accounts.add(new Account("Jennifer", 999.99, 1234));
		accounts.add(new Account("Jose", 500.01, 4321));

	}

	public Dimension getPreferredSize() {
		return new Dimension(800, 400);
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

	}

	public void actionPerformed(ActionEvent e) {

	}

}