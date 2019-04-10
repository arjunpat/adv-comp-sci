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
		drawTitle(g, Color.RED, "New Order", 20, 50);

		ArrayList<MenuItem> items = db.getMenuItems();
		boolean redoButton = false;
		if (buttons.length != items.size()) {
			for (int i = 0; i < buttons.length; i++) {
				remove(buttons[i]);
			}
			buttons = new JButton[items.size()];
			redoButton = true;
		}
		int x = 40;
		int y = 80;

		for (int i = 0; i < items.size(); i++) {
			MenuItem item = items.get(i);

			if (redoButton) {
				JButton btn = new JButton("Add for $" + item.getPrice());
				btn.setBounds(x - 10, y + 170, 170, 30);
				final int theI = i;
				btn.addActionListener(e -> {
					order.add(items.get(theI));
					update();
				});
				add(btn);

				buttons[i] = btn;
			}

			Graphics2D g2 = (Graphics2D)g;
			g2.drawImage(item.getImage(), x, y, 150, 150, null);

			x += 170;
			if (x > 500) {
				x = 40;
				y += 220;
			}
		}
	}

	public void update() {
		orderTextArea.setText(order.stringify());
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 800);
	}

	public void onChange() {

	}
}