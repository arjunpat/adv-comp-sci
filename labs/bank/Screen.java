import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;

public class Screen extends JPanel implements ActionListener {
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private JTextField username = new JTextField(20);
	private JTextField password = new JTextField(20);
	private JTextField deposit = new JTextField(20);
	private JTextField withdraw = new JTextField(20);

	private JTextField changeName = new JTextField(20);
	private JTextField changePin = new JTextField(20);

	private JButton changeNameButton = new JButton("Change name");
	private JButton changePinButton = new JButton("Change pin");

	private JButton loginButton = new JButton("Login");
	private JButton depositButton = new JButton("Deposit");
	private JButton withdrawButton = new JButton("Withdraw");
	private JButton logoutButton = new JButton("Logout");

	private int currentAccount = 0;
	private boolean loginFailed = false;

	private String page = "login";

	private Color green = new Color(79, 255, 146);
	private Color white = new Color(255, 255, 255);
	private Color purple = new Color(192, 179, 224);
	private Color lblue = new Color(176, 224, 230);
	private Color blue = new Color(0, 0, 255);
	private Color red = new Color(255, 0, 0);
	private Color black = new Color(0, 0, 0);
	private Color yellow = new Color(244, 236, 8);
	private Color dblue = new Color(30, 144, 255);
	private Color red1 = new Color(242, 106, 117);
	private Color yellow1 = new Color(249, 228, 89);

	public Screen() {
		this.setLayout(null);

		accounts.add(new Account("Jennifer", 999.99, 1234));
		accounts.add(new Account("Jose", 500.01, 4321));
		accounts.add(new Account("Arjun", 123123.01, 1357));
		accounts.add(new Account("Tanay", 2342.01, 7531));
		accounts.add(new Account("Lee", 3432.01, 01010));


		username.setBounds(325, 250, 200, 30);
		this.add(username);

		password.setBounds(325, 350, 200, 30);
		this.add(password);

		loginButton.setBounds(350, 400, 100, 40);
		loginButton.addActionListener(this);
		this.add(loginButton);

		withdraw.setBounds(500, 275, 200, 30);
		deposit.setBounds(200, 275, 200, 30);
		changeName.setBounds(200, 525, 200, 30);
		changePin.setBounds(500, 525, 200, 30);
		
		withdrawButton.setBounds(500, 320, 100, 40);
		withdrawButton.addActionListener(this);
		
		depositButton.setBounds(200, 320, 100, 40);
		depositButton.addActionListener(this);

		logoutButton.setBounds(640, 50, 100, 40);
		logoutButton.addActionListener(this);

		changeNameButton.setBounds(200, 575, 100, 40);
		changeNameButton.addActionListener(this);

		changePinButton.setBounds(500, 575, 100, 40);
		changePinButton.addActionListener(this);

		this.setFocusable(true);

	}

	public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		switch (page) {
			case "login":
				g.setColor(white);
				g.fillRect(0, 0, 800, 800);

				g.setColor(black);
				g.setFont(new Font("Arial", Font.PLAIN, 30));
				g.drawString("Welcome to the bank.", 250, 100);

				g.setFont(new Font("Arial", Font.PLAIN, 20));

				g.drawString("Name", 350, 225);
				g.drawString("Pin", 350, 325);

				if (loginFailed) {
					g.drawString("Incorrect credentials", 320, 475);
				}

				break;
			case "loggedin":

				g.setFont(new Font("Arial", Font.PLAIN, 30));

				g.drawString("Hello, " + accounts.get(currentAccount - 1).getName(), 100, 100);
				g.setFont(new Font("Arial", Font.PLAIN, 20));
				g.drawString("Balance: $" + accounts.get(currentAccount - 1).getBalance(), 100, 130);

				g.drawString("Deposit money", 200, 250);

				g.drawString("Withdraw money", 500, 250);

				g.drawString("Change name", 200, 500);
				g.drawString("Change pin", 500, 500);

				break;
		}

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginButton) {
			String name = username.getText();
			int pin = Integer.parseInt(password.getText());

			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getName().equals(name)) {
					System.out.println(accounts.get(i).getName());

					accounts.get(i).setAccess(pin);
					if (accounts.get(i).getAccess() == true) {

						this.remove(username);
						this.remove(password);
						this.remove(loginButton);

						this.add(withdraw);
						this.add(deposit);
						this.add(changeName);
						this.add(changePin);
						this.add(withdrawButton);
						this.add(depositButton);
						this.add(logoutButton);
						this.add(changeNameButton);
						this.add(changePinButton);

						page = "loggedin";
						currentAccount = i + 1;
						break;
					}
				}
			}

			if (currentAccount == 0) {
				loginFailed = true;
			}

			username.setText("");
			password.setText("");
		} else if (e.getSource() == withdrawButton) {
			double amt = Double.parseDouble(withdraw.getText());
			withdraw.setText("");

			accounts.get(currentAccount - 1).withdraw(amt);

		} else if (e.getSource() == depositButton) {
			double amt = Double.parseDouble(deposit.getText());
			deposit.setText("");

			accounts.get(currentAccount - 1).deposit(amt);

		} else if (e.getSource() == logoutButton) {
			
			this.add(username);
			this.add(password);
			this.add(loginButton);

			this.remove(withdraw);
			this.remove(deposit);
			this.remove(changeName);
			this.remove(changePin);
			this.remove(withdrawButton);
			this.remove(depositButton);
			this.remove(logoutButton);
			this.remove(changePinButton);
			this.remove(changeNameButton);

			currentAccount = 0;
			page = "login";
		} else if (e.getSource() == changeNameButton && currentAccount != 0) {
			accounts.get(currentAccount - 1).changeName(changeName.getText());
			changeName.setText("");
		} else if (e.getSource() == changePinButton && currentAccount != 0) {
			accounts.get(currentAccount - 1).changePin(Integer.parseInt(changePin.getText()));
			changePin.setText("");
		}

		this.repaint();

	}

}