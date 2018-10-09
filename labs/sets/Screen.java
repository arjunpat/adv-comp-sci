import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {
	private JTextArea itemTextArea = new JTextArea(390, 350);
	private JTextArea shoppingCartTextArea = new JTextArea(390, 350);

	private Database db = new Database("StoreA.txt");

	public Screen() {
		
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

		final JTextField priceTextField = new JTextField(20);
		priceTextField.setBounds(20, 360, 240, 30);
		priceTextField.setText("Price");
		this.add(priceTextField);

		final JTextField quantityTextField = new JTextField(20);
		quantityTextField.setBounds(10, 410, 250, 30);
		quantityTextField.setText("Quantity");
		this.add(quantityTextField);

		JButton addItemToCart = new JButton("Find and add");
		addItemToCart.setBounds(10, 460, 200, 30);
		addItemToCart.addActionListener(e -> {

			Item i = new Item(productNameTextField.getText(), Double.parseDouble(priceTextField.getText()));
			db.addToCart(i, Integer.parseInt(quantityTextField.getText()));
			productNameTextField.setText("Product name");
			priceTextField.setText("Price");
			quantityTextField.setText("Quantity");

			this.populateShoppingCart();
		});
		this.add(addItemToCart);

		final JTextField productNameStockTextField = new JTextField(20);
		productNameStockTextField.setBounds(10, 610, 250, 30);
		productNameStockTextField.setText("Product name");
		this.add(productNameStockTextField);

		final JTextField priceStockTextField = new JTextField(20);
		priceStockTextField.setBounds(20, 660, 240, 30);
		priceStockTextField.setText("Price");
		this.add(priceStockTextField);

		JButton addItem = new JButton("Add to inventory");
		addItem.setBounds(10, 710, 175, 30);
		addItem.addActionListener(e -> {
			Item item = new Item(productNameStockTextField.getText(), Double.parseDouble(priceStockTextField.getText()));
			db.addToInventory(item);
			this.populateItems();

			productNameStockTextField.setText("Product name");
			priceStockTextField.setText("Price");
		});
		this.add(addItem);

		JButton removeItem = new JButton("Remove from inventory");
		removeItem.setBounds(200, 710, 175, 30);
		removeItem.addActionListener(e -> {
			Item item = new Item(productNameStockTextField.getText(), Double.parseDouble(priceStockTextField.getText()));
			db.removeFromInventory(item);
			this.populateItems();

			productNameStockTextField.setText("Product name");
			priceStockTextField.setText("Price");
		});
		this.add(removeItem);

	}

	public void draw(Graphics g) {

		this.drawTitle(g, red, "Items in stock", 400, 35);
		this.drawTitle(g, red, "Your shopping cart", 400, 435);
		this.drawTitle(g, dblue, "Add an item to your cart", 10, 275);
		this.drawTitle(g, dblue, "Add or remove an item from stock", 10, 580);

		g.setColor(black);
		g.setFont(new Font("Tahoma", Font.PLAIN, 18));
		g.drawString("$", 10, 380);
		g.drawString("$", 10, 680);


		g.setColor(yellow1);
		g.fillRect(0, 30, 350, 200);

		g.setColor(black);
		g.setFont(new Font("Trebuchet MS", Font.PLAIN, 102));
		g.drawString("El", 10, 120);
		g.setFont(new Font("Trebuchet MS", Font.PLAIN, 82));
		g.drawString("Mercado", 10, 200);

	}

	private void drawTitle(Graphics g, Color c, String text, int x, int y) {
		g.setColor(black);
		g.setFont(new Font("Tahoma", Font.PLAIN, 24));
		g.drawString(text, x, y);
		g.setColor(c);
		g.fillRect(x, y + 5, text.length() * 11, 3);
	}

	private void populateShoppingCart() {
		this.shoppingCartTextArea.setText(db.cartToString());
	}

	private void populateItems() {
		this.itemTextArea.setText(db.getAllItems());
	}
}