import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.Timer;


public class Runner extends View {
	private BinarySearchTree<Item> tree = new BinarySearchTree<Item>();
	private Notification notification = new Notification("", 0);
	private boolean autoBalance = false;
	private AddAndSearch addAndSearch =  new AddAndSearch();

	public Runner() {
		tree.add(new Item("Bread", 40));
		tree.add(new Item("Milk", 40));
		tree.add(new Item("Carrot", 40));
		tree.add(new Item("Apple", 40));
		tree.add(new Item("Goods", 40));
		tree.add(new Item("Milkshake", 40));
		tree.add(new Item("Cream", 40));
		tree.add(new Item("Plug", 40));
		tree.add(new Item("Table", 40));
		tree.add(new Item("Floor", 40));

		JButton balance = new JButton("Balance");
		balance.setBounds(650, 20, 100, 30);
		balance.addActionListener(e -> {
			tree.balance();
			repaint();
		});
		add(balance);


		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();

		add(addAndSearch);
	}

	public void draw(Graphics g) {

		tree.draw(g, 600, 600);

		g.setColor(new Color(245, 245, 245));
		g.fillRect(530, 350, 270, 700);


		if (!notification.isDone())
			notification.draw(g);

		if (notification.isOld()) {
			notification.addASecond();
			animateNotificationDown();
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Lab");
		frame.add(new Runner());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public void displayNotification(String text, int time) {
		notification = new Notification(text, time);
		animateNotificationUp();
	}

	private void animateNotificationUp() {
		notification.setY(800);

		Thread animate = new Thread(new Runnable() {
			public void run() {

				while (notification.getY() > Notification.FINAL_Y) {
					try {
						Thread.sleep(Notification.ANIMATE_WAIT_TIME);
						notification.moveUp();
						repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		});

		animate.start();
	}

	private void animateNotificationDown() {

		Thread animate = new Thread(new Runnable() {
			public void run() {

				while (notification.getY() < 800) {
					try {
						Thread.sleep(Notification.ANIMATE_WAIT_TIME);
						notification.moveDown();
						repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				notification.done();

			}
		});

		animate.start();
	}


	private class AddAndSearch extends View {


		public AddAndSearch() {
			JTextField name = new JTextField();
			name.setBounds(550, 400, 200, 30);
			name.setText("Name");
			add(name);

			JTextField price = new JTextField();
			price.setBounds(550, 450, 200, 30);
			price.setText("Price");
			add(price);

			JButton addItem = new JButton("Add");
			addItem.setBounds(550, 500, 100, 30);
			addItem.addActionListener(e -> {
				Item i = new Item(name.getText(), Double.parseDouble(price.getText()));
				tree.add(i);
				repaint();
			});
			add(addItem);

			JTextField nameSearch = new JTextField();
			nameSearch.setBounds(550, 600, 200, 30);
			nameSearch.setText("Name");
			add(nameSearch);

			JButton search = new JButton("Search");
			search.setBounds(550, 650, 100, 30);
			search.addActionListener(e -> {
				Item i = new Item(nameSearch.getText(), 0);
				i = tree.get(i);
				int passes = tree.getPasses();

				displayNotification("Passes: " + passes + ". Price: " + i.getPrice(), 3000);
			});
			add(search);
		}

		public void draw(Graphics g) {
			drawTitle(g, Color.RED, "Add Item", 555, 380);
			drawTitle(g, Color.RED, "Search for an item", 550, 580);
		}
	}
}