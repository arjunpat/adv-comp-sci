import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChefView extends View {
	private Database db;
	private JFrame j;
	private Order order;
	private JTextArea orderTextArea = new JTextArea(300, 200);

	public ChefView(Database db, JFrame j) {
		this.db = db;
		db.addChangeListener(this);
		this.j = j;

		order = db.peekOrder();

		orderTextArea.setEditable(false);
		JScrollPane orderScrollPane = new JScrollPane(orderTextArea);
		orderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		orderScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		orderScrollPane.setBounds(50, 180, 300, 200);
		add(orderScrollPane);


		JButton done = new JButton("I'm done with this order");
		done.setBounds(180, 20, 200, 30);
		done.addActionListener(e -> {
			db.doneWithOrder();
			onChange();
		});
		add(done);

		if (order != null)
			orderTextArea.setText(order.stringify());
		else
			orderTextArea.setText("No orders! Relax!");
	}

	public void draw(Graphics g) {
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

	public void onChange() {
		order = db.peekOrder();

		if (order != null)
			orderTextArea.setText(order.stringify());
		else
			orderTextArea.setText("No orders! Relax!");
	}
}