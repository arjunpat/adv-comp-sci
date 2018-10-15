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
		quantityTextField.setBounds(10, 360, 240, 30);
		quantityTextField.setText("Quantity");
		this.add(quantityTextField);

		JButton addItemToCart = new JButton("Find and add");
		addItemToCart.setBounds(10, 410, 200, 30);
		/*addItemToCart.addActionListener(e -> {

			Item i = new Item(productNameTextField.getText(), Double.parseDouble(priceTextField.getText()));
			db.addToCart(i, Integer.parseInt(quantityTextField.getText()));
			productNameTextField.setText("Product name");
			priceTextField.setText("Price");
			quantityTextField.setText("Quantity");

			this.populateShoppingCart();
		});
		this.add(addItemToCart);*/

    }

    public void draw(Graphics g) {

		this.drawTitle(g, red, "Items in stock", 400, 35);
		this.drawTitle(g, red, "Your shopping cart", 400, 435);
		this.drawTitle(g, dblue, "Add an item to your cart", 10, 275);
		this.drawTitle(g, dblue, "Add or remove an item from stock", 10, 580);

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
		//this.shoppingCartTextArea.setText(db.cartToString());
	}

	private void populateItems() {
		this.itemTextArea.setText(db.getAllItems());
	}
}