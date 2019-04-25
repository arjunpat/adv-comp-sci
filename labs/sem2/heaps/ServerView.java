import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ServerView extends View {
	private Database db;
	private JFrame j;

	public ServerView(Database db, JFrame j) {
		this.db = db;
		this.j = j;

		JButton toNew = new JButton("New Order");
		toNew.setBounds(200, 200, 200, 60);
		toNew.addActionListener(e -> {

			Thread animate = new Thread(new Runnable() {
				public void run() {
					int newOrderY = 400;
					double acc = 20;
					NewOrder newOrder = new NewOrder(db, j);
					newOrder.setBounds(0, newOrderY, 800, 800);
					newOrder.setBackground(new Color(255, 255, 255, 0));
					add(newOrder);

					while (newOrderY > 0) {
						int opacity = (int)(255 * ((400 - newOrderY) / 400.0));
						newOrder.setBackground(new Color(255, 255, 255, opacity));
						newOrder.setLocation(0, newOrderY);
						repaint();
						try { Thread.sleep(10); } catch (Exception e) {}
						newOrderY -= acc;
						acc += .5;
					}

					newOrder.setLocation(0, 0);
					newOrder.setBackground(new Color(255, 255, 255));

					j.setContentPane(newOrder);
					j.pack();
					j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					j.setVisible(true);
				}
			});

			animate.start();
		});
		add(toNew);


		JButton toCompleted = new JButton("Completed Orders");
		toCompleted.setBounds(200, 500, 200, 60);
		toCompleted.addActionListener(e -> {
			Thread animate = new Thread(new Runnable() {
				public void run() {
					int completedY = 400;
					double acc = 20;
					CompletedOrders completed = new CompletedOrders(db, j);
					completed.setBounds(0, completedY, 800, 800);
					completed.setBackground(new Color(255, 255, 255, 0));
					add(completed);

					while (completedY > 0) {
						int opacity = (int)(255 * ((400 - completedY) / 400.0));
						completed.setBackground(new Color(255, 255, 255, opacity));
						completed.setLocation(0, completedY);
						repaint();
						try { Thread.sleep(10); } catch (Exception e) {}
						completedY -= acc;
						acc += .5;
					}

					completed.setLocation(0, 0);
					completed.setBackground(new Color(255, 255, 255));

					j.setContentPane(completed);
					j.pack();
					j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					j.setVisible(true);
				}
			});

			animate.start();
		});
		add(toCompleted);

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