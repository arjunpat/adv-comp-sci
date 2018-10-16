import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MainView extends View {
	private ScreenManager screenManager;
	private Database db;
	private JTextArea itemTextArea = new JTextArea(390, 350);
	private JTextArea shoppingCartTextArea = new JTextArea(390, 350);

	public MainView(ScreenManager screenManager, Database db) {
		this.screenManager = screenManager;
		this.db = db;

		this.itemTextArea.setEditable(false);
		JScrollPane itemScrollPane = new JScrollPane(itemTextArea);
		itemScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		itemScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		itemScrollPane.setBounds(400, 50, 390, 350);
		this.add(itemScrollPane);
		this.populateItems();


		this.shoppingCartTextArea.setEditable(false);
		JScrollPane shoppingCartScrollPane = new JScrollPane(shoppingCartTextArea);
		shoppingCartScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		shoppingCartScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		shoppingCartScrollPane.setBounds(400, 450, 390, 350);
		this.add(shoppingCartScrollPane);
		this.populateShoppingCart();

		final JTextField productNameTextField = new JTextField(20);
		productNameTextField.setBounds(10, 310, 250, 30);
		productNameTextField.setText("Product name");
		this.add(productNameTextField);

		final JTextField quantityTextField = new JTextField(20);
		quantityTextField.setBounds(10, 360, 250, 30);
		quantityTextField.setText("Quantity");
		this.add(quantityTextField);

		JButton addItemToCart = new JButton("Find and add");
		addItemToCart.setBounds(10, 410, 200, 30);
		addItemToCart.addActionListener(e -> {
			
			try {
				db.addToCart(productNameTextField.getText(), Integer.parseInt(quantityTextField.getText()));
			} catch (NumberFormatException err) {

			}

			productNameTextField.setText("Product name");
			quantityTextField.setText("Quantity");

			this.populateShoppingCart();
		});
		this.add(addItemToCart);


		JButton goToAdminArea = new JButton("Admin area");
		goToAdminArea.setBounds(10, 600, 200, 30);
		goToAdminArea.addActionListener(e -> {

			screenManager.goToAdminArea();

		});
		this.add(goToAdminArea);

	}

	public void draw(Graphics g) {

		drawTitle(g, red, "Items in stock", 400, 35);
		drawTitle(g, red, "Your shopping cart", 400, 435);
		drawTitle(g, dblue, "Add an item to your cart", 10, 275);
		drawTitle(g, dblue, "Go to the admin area", 10, 580);

		g.setColor(yellow1);
		g.fillRect(0, 30, 350, 200);

		g.setColor(black);
		g.setFont(new Font("Trebuchet MS", Font.PLAIN, 102));
		g.drawString("El", 10, 120);
		g.setFont(new Font("Trebuchet MS", Font.PLAIN, 82));
		g.drawString("Mercado", 10, 200);

		g.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		g.drawString("18% shipping charge", 10, 460);

	}

	private void populateShoppingCart() {
		this.shoppingCartTextArea.setText(db.cartToString());
	}

	private void populateItems() {
		this.itemTextArea.setText(db.getAllItems());
	}
}