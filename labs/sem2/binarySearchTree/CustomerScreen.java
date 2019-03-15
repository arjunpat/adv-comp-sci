import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.Timer;

public class CustomerScreen extends View {
	private Runner runner;
	private Database db;
	private Notification notification = new Notification("", 0);

	public CustomerScreen(Runner runner, Database db) {
		this.runner = runner;
		this.db = db;

		setBackground(new Color(255, 255, 255));

		JButton leave = new JButton("Close");
		leave.setBounds(680, 10, 100, 30);
		leave.addActionListener(e -> {
			runner.showHomeScreen();
		});
		add(leave);

	}

	public void draw(Graphics g) {
		drawBigTitle(g, Color.RED, "Customer Screen", 20, 50);
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
}