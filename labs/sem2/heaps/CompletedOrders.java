import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class NewOrder extends View {
	private Database db;
	private JFrame j;
	private Order order;
	private JButton[] buttons = new JButton[0];
	private JTextArea orderTextArea = new JTextArea(300, 190);

	public NewOrder(Database db, JFrame j) {
		this.db = db;
		this.j = j;
		order = new Order();


		orderTextArea.setEditable(false);
		JScrollPane orderScrollPane = new JScrollPane(orderTextArea);
		orderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		orderScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		orderScrollPane.setBounds(10, 600, 300, 190);
		add(orderScrollPane);

		JButton placeOrder = new JButton("Place order");
		placeOrder.setBounds(320, 600, 200, 60);
		placeOrder.addActionListener(e -> {
			db.addOrder(order);
			order = new Order();
			update();
		});
		add(placeOrder);

		JButton close = new JButton("Close");
		close.setBounds(450, 20, 100, 30);
		close.addActionListener(e -> {
			j.setContentPane(new ServerView(db, j));
			j.pack();
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			j.setVisible(true);
		});
		add(close);
	}

	public void draw(Graphics g) {
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 800);
	}

	public void onChange() {

	}
}