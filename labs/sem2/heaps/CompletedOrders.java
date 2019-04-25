import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CompletedOrders extends View {
	private Database db;
	private JFrame j;
	private Order order;
	private JTextArea orderTextArea = new JTextArea(300, 400);

	public CompletedOrders(Database db, JFrame j) {
		this.db = db;
		db.addChangeListener(this);
		this.j = j;
		order = new Order();

		onChange();

		orderTextArea.setEditable(false);
		JScrollPane orderScrollPane = new JScrollPane(orderTextArea);
		orderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		orderScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		orderScrollPane.setBounds(20, 100, 300, 400);
		add(orderScrollPane);

		JButton done = new JButton("I'm done with this order");
		done.setBounds(340, 100, 200, 30);
		done.addActionListener(e -> {
			db.doneWithCompletedOrder();
			onChange();
		});
		add(done);

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
		order = db.peekCompletedOrder();

		if (order != null)
			orderTextArea.setText(order.stringify());
		else
			orderTextArea.setText("No orders! Relax!");
	}
}