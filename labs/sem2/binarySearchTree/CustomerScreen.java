import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.Timer;

public class CustomerScreen extends View {
	private Runner runner;
	private Database db;
	private Account account;
	private Notification notification = new Notification("", 0);

	public CustomerScreen(Runner runner, Database db, Account account) {
		this.runner = runner;
		this.db = db;
		this.account = account;

		setBackground(new Color(255, 255, 255));

		JButton leave = new JButton("Close");
		leave.setBounds(680, 10, 100, 30);
		leave.addActionListener(e -> {
			runner.showHomeScreen();
		});
		add(leave);

		JTextField firstNameEdit = new JTextField();
		firstNameEdit.setBounds(20, 350, 200, 30);
		add(firstNameEdit);

		JTextField lastNameEdit = new JTextField();
		lastNameEdit.setBounds(20, 400, 200, 30);
		add(lastNameEdit);

		JTextField pinEdit = new JTextField();
		pinEdit.setBounds(20, 450, 200, 30);
		add(pinEdit);

		java.util.function.Function<Boolean, Boolean> reset = (bool) -> {
			firstNameEdit.setText(account.getFirstName());
			lastNameEdit.setText(account.getLastName());
			pinEdit.setText(account.getPin() + "");
			repaint();

			return true;
		};

		JButton updateSettings = new JButton("Update settings");
		updateSettings.setBounds(20, 500, 200, 30);
		updateSettings.addActionListener(e -> {
			account.setFirstName(firstNameEdit.getText());
			account.setLastName(lastNameEdit.getText());
			account.setPin(Integer.parseInt(pinEdit.getText()));

			db.remove(account);
			db.addAccount(account);
			reset.apply(true);

			displayNotification("Account updated", 2000);
		});
		add(updateSettings);

		reset.apply(true);

		JTextField anAmount = new JTextField();
		anAmount.setBounds(350, 350, 200, 30);
		anAmount.setText("An amount");
		add(anAmount);

		JButton deposit = new JButton("Deposit");
		deposit.setBounds(350, 400, 110, 30);
		deposit.addActionListener(e -> {
			account.setBalance(account.getBalance() + Integer.parseInt(anAmount.getText()));

			reset.apply(true);
			displayNotification("Deposit successful", 2000);
		});
		add(deposit);

		JButton withdrawal = new JButton("Withdrawal");
		withdrawal.setBounds(465, 400, 110, 30);
		withdrawal.addActionListener(e -> {
			double finalAmount = account.getBalance() - Integer.parseInt(anAmount.getText());

			if (finalAmount < 0) {
				displayNotification("Withdrawal amount cannot exceed balance", 2000);
			} else {
				account.setBalance(finalAmount);

				reset.apply(true);
				displayNotification("Withdrawal successful", 2000);
			}
		});
		add(withdrawal);

		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();

	}

	public void draw(Graphics g) {
		drawBigTitle(g, Color.RED, "Hello, " + account.getFirstName() + " " + account.getLastName(), 20, 50);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 18));
		g.drawString("Your current balance is $" + account.getBalance(), 20, 100);

		drawTitle(g, Color.BLUE, "Settings", 20, 300);
		drawTitle(g, Color.BLUE, "Deposit & Withdrawal", 350, 300);

		if (!notification.isDone())
			notification.draw(g);

		if (notification.isOld()) {
			notification.addASecond();
			animateNotificationDown();
		}
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