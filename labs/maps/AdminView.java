import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AdminView extends View {
	private ScreenManager screenManager;
	private Database db;


	public AdminView(ScreenManager screenManager, Database db) {
		this.screenManager = screenManager;
		this.db = db;

		JButton backButton = new JButton("←");
		backButton.setBounds(10, 20, 50, 50);
		backButton.addActionListener(e -> {
			screenManager.showMainView();
		});
		this.add(backButton);


		final JTextField nameTextField = new JTextField(20);
		nameTextField.setBounds(10, 250, 200, 30);
		this.add(nameTextField);

		final JTextField priceTextField = new JTextField(20);
		priceTextField.setBounds(10, 300, 200, 30);
		this.add(priceTextField);

		final JTextField weightTextField = new JTextField(20);
		weightTextField.setBounds(10, 350, 200, 30);
		this.add(weightTextField);

		final JButton changePrice = new JButton("Change price");
		changePrice.setBounds(10, 400, 200, 30);
		changePrice.addActionListener(e -> {

			String name = nameTextField.getText();
			double price = Double.parseDouble(priceTextField.getText());
			double weight = Double.parseDouble(weightTextField.getText());

			db.changePrice(name, price, weight);

			nameTextField.setText("Name");
			priceTextField.setText("Price");
			weightTextField.setText("Weight");
		});
		this.add(changePrice);


		final JTextField nameAddTextField = new JTextField(20);
		nameAddTextField.setBounds(320, 250, 200, 30);
		this.add(nameAddTextField);

		final JTextField priceAddTextField = new JTextField(20);
		priceAddTextField.setBounds(320, 300, 200, 30);
		this.add(priceAddTextField);

		final JTextField weightAddTextField = new JTextField(20);
		weightAddTextField.setBounds(320, 350, 200, 30);
		this.add(weightAddTextField);

		final JTextField companyNameAddTextField = new JTextField(20);
		companyNameAddTextField.setBounds(320, 400, 200, 30);
		this.add(companyNameAddTextField);

		final JButton addItem = new JButton("Add item");
		addItem.setBounds(320, 450, 200, 30);
		addItem.addActionListener(e -> {

			String name = nameAddTextField.getText();
			String company = companyNameAddTextField.getText();
			double price = Double.parseDouble(priceAddTextField.getText());
			double weight = Double.parseDouble(weightAddTextField.getText());

			db.addItem(name, company, price, weight);

			nameAddTextField.setText("Name");
			companyNameAddTextField.setText("Company name");
			priceAddTextField.setText("Price");
			weightAddTextField.setText("Weight");

		});
		this.add(addItem);


		final JTextField nameRemoveTextField = new JTextField(20);
		nameRemoveTextField.setBounds(10, 600, 200, 30);
		this.add(nameRemoveTextField);

		final JButton removeItem = new JButton("Remove item");
		removeItem.setBounds(10, 650, 200, 30);
		removeItem.addActionListener(e -> {

			db.removeItem(nameRemoveTextField.getText());

			nameRemoveTextField.setText("Name");

		});
		this.add(removeItem);

		nameRemoveTextField.setText("Name");

		nameAddTextField.setText("Name");
		companyNameAddTextField.setText("Company name");
		priceAddTextField.setText("Price");
		weightAddTextField.setText("Weight");

		nameTextField.setText("Name");
		priceTextField.setText("Price");
		weightTextField.setText("Weight");

	}

	public void draw(Graphics g) {
		drawBigTitle(g, red, "Admin view", 80, 55);

		drawTitle(g, blue, "Change the price of an item", 10, 200);
		drawTitle(g, yellow, "Add item", 320, 200);

		drawTitle(g, blue, "Remove an item", 10, 550);

	}
}
