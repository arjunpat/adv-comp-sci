import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Runner extends View {

	private JTextArea shoppingCartTextArea = new JTextArea(390, 350);
	private SLList<Item> items = new SLList<Item>();

	public Runner() {

		items.add(new Item("Apple", 0.99, 3));
		items.add(new Item("Milk", 6.32, 2));
		items.add(new Item("Cereal", 2.99, 2));

		shoppingCartTextArea.setEditable(false);
		JScrollPane shoppingCartScrollPane = new JScrollPane(shoppingCartTextArea);
		shoppingCartScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		shoppingCartScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		shoppingCartScrollPane.setBounds(400, 50, 390, 350);
		add(shoppingCartScrollPane);
		populateShoppingCart();

		JTextField name = new JTextField();
		name.setBounds(20, 60, 250, 30);
		name.setText("Name");
		add(name);

		JTextField price = new JTextField();
		price.setBounds(30, 100, 240, 30);
		price.setText("Price");
		add(price);

		JTextField quantity = new JTextField();
		quantity.setBounds(20, 140, 240, 30);
		quantity.setText("Quantity");
		add(quantity);

		JButton addButton = new JButton("Add");
		addButton.setBounds(20, 180, 175, 30);
		addButton.addActionListener(e -> {
			Item i = new Item(name.getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()));

			if (items.contains(i)) {
				items.set(items.indexOf(i), i);
			} else {
				items.add(i);
			}

			name.setText("Name");
			price.setText("Price");
			quantity.setText("Quantity");

			populateShoppingCart();
		});
		add(addButton);

		JTextField nameDelete = new JTextField();
		nameDelete.setBounds(20, 425, 250, 30);
		nameDelete.setText("Name");
		add(nameDelete);

		JTextField priceDelete = new JTextField();
		priceDelete.setBounds(30, 465, 240, 30);
		priceDelete.setText("Price");
		add(priceDelete);

		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(20, 505, 250, 30);
		removeButton.addActionListener(e -> {
			Item i = new Item(nameDelete.getText(), Double.parseDouble(priceDelete.getText()), 0);

			if (items.contains(i)) {
				items.remove(i);
			}

			nameDelete.setText("Name");
			priceDelete.setText("Price");

			populateShoppingCart();
		});
		add(removeButton);

	}

	public void draw(Graphics g) {

		drawTitle(g, Color.RED, "Your Shopping Cart", 400, 35);
		drawTitle(g, Color.BLUE, "Add An Item", 20, 35);
		drawTitle(g, Color.BLUE, "Remove An Item", 20, 400);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 18));
		g.drawString("$", 20, 120);
		g.drawString("$", 20, 485);

	}

	private void populateShoppingCart() {
		
		String str = "";
		double totalCost = 0;

		for (int i = 0; i < items.size(); i++) {
			Item it = items.get(i);
			totalCost += it.getPrice() * it.getQuantity();
			str += it.toString() + "\n";
		}

		str += "\nTotal cost: $" + totalCost;

		shoppingCartTextArea.setText(str);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Shopping Cart");

		frame.add(new Runner());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}