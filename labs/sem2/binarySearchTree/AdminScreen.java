import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AdminScreen extends View {
	private Runner runner;
	private Database db;
	private JTextArea accountsTextArea = new JTextArea(390, 350);
	private int passes;
	private Account accountEditing;

	public AdminScreen(Runner runner, Database db) {
		this.runner = runner;
		this.db = db;

		setBackground(new Color(255, 255, 255));

		accountsTextArea.setEditable(false);
		JScrollPane accountsScrollPane = new JScrollPane(accountsTextArea);
		accountsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		accountsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		accountsScrollPane.setBounds(400, 50, 390, 350);
		add(accountsScrollPane);

		JTextField firstName = new JTextField();
		firstName.setBounds(20, 500, 200, 30);
		add(firstName);

		JTextField lastName = new JTextField();
		lastName.setBounds(20, 550, 200, 30);
		add(lastName);

		JTextField pin = new JTextField();
		pin.setBounds(20, 600, 200, 30);
		add(pin);

		JTextField balance = new JTextField();
		balance.setBounds(20, 650, 200, 30);
		add(balance);

		java.util.function.Function<Boolean, Boolean> reset = (bool) -> {
			accountsTextArea.setText(db.getAllNames());
			firstName.setText("First name");
			lastName.setText("Last name");
			pin.setText("Pin");
			balance.setText("Balance");
			repaint();

			return true;
		};

		JButton addAccount = new JButton("Add account");
		addAccount.setBounds(20, 700, 200, 30);
		addAccount.addActionListener(e -> {
			Account account = new Account(firstName.getText(), lastName.getText(), Integer.parseInt(pin.getText()), Double.parseDouble(balance.getText()));
			passes = db.addAccount(account);

			reset.apply(true);
		});
		add(addAccount);

		reset.apply(true);

		JTextField searchByName = new JTextField();
		searchByName.setBounds(250, 500, 200, 30);
		searchByName.setText("First and last name");
		add(searchByName);

		JTextField firstNameEdit = new JTextField();
		firstNameEdit.setBounds(250, 600, 200, 30);

		JTextField lastNameEdit = new JTextField();
		lastNameEdit.setBounds(250, 650, 200, 30);

		JTextField pinEdit = new JTextField();
		pinEdit.setBounds(475, 600, 200, 30);

		JTextField balanceEdit = new JTextField();
		balanceEdit.setBounds(475, 650, 200, 30);

		JButton updateAccount = new JButton("Update Account");
		updateAccount.setBounds(250, 700, 425, 30);

		JButton clickToSearch = new JButton("Search");
		clickToSearch.setBounds(500, 500, 100, 30);
		clickToSearch.addActionListener(e -> {
			String[] parts = searchByName.getText().split(" ");
			Account account = new Account(parts[0], parts[1], 0, 0);
			accountEditing = db.search(account);

			firstNameEdit.setText(accountEditing.getFirstName());
			lastNameEdit.setText(accountEditing.getLastName());
			pinEdit.setText(accountEditing.getPin() + "");
			balanceEdit.setText(accountEditing.getBalance() + "");

			add(firstNameEdit);
			add(lastNameEdit);
			add(pinEdit);
			add(balanceEdit);
			add(updateAccount);
		});
		add(clickToSearch);
	}

	public void draw(Graphics g) {
		drawBigTitle(g, Color.RED, "Admin Screen", 20, 50);
		drawTitle(g, Color.BLUE, "Add new account", 20, 450);
		drawTitle(g, Color.GREEN, "Search for an account", 250, 450);

		if (passes > 0) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Tahoma", Font.PLAIN, 14));
			g.drawString("Took " + passes + " passes", 20, 750);
		}
	}
}