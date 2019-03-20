import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.Timer;

public class LoginScreen extends View {
	private Runner runner;
	private Database db;
	private Notification notification = new Notification("", 0);

	public LoginScreen(Runner runner, Database db) {
		this.runner = runner;
		this.db = db;

		setBackground(new Color(255, 255, 255));

		JButton leave = new JButton("Close");
		leave.setBounds(680, 10, 100, 30);
		leave.addActionListener(e -> {
			runner.showHomeScreen();
		});
		add(leave);

		JTextField firstName = new JTextField();
		firstName.setBounds(300, 300, 200, 30);
		add(firstName);

		JTextField lastName = new JTextField();
		lastName.setBounds(300, 350, 200, 30);
		add(lastName);

		JTextField pin = new JTextField();
		pin.setBounds(300, 400, 200, 30);
		add(pin);

		JButton login = new JButton("Login");
		login.setBounds(300, 450, 100, 30);
		login.addActionListener(e -> {
			Account account = new Account(firstName.getText(), lastName.getText(), 0, 0);
			Account theAccount = db.search(account);

			if (theAccount == null) {
				displayNotification("No account exists", 2000);
				return;
			}

			if (theAccount.getPin() != Integer.parseInt(pin.getText())) {
				displayNotification("Bad pin", 2000);
				return;
			}

			login.setEnabled(false);

			displayNotification("Took " + db.getPasses() + " passes; you are being logged in", 2000);


			Thread animate = new Thread(new Runnable() {
				public void run() {
					try { Thread.sleep(2000); } catch (Exception e) {}
					int customerScreenY = 400;
					double acc = 20;
					CustomerScreen customerScreen = new CustomerScreen(runner, db, theAccount);
					customerScreen.setBounds(0, customerScreenY, 800, 800);
					customerScreen.setBackground(new Color(255, 255, 255, 0));
					add(customerScreen);

					while (customerScreenY > 0) {
						int opacity = (int)(255 * ((400 - customerScreenY) / 400.0));
						customerScreen.setBackground(new Color(255, 255, 255, opacity));
						customerScreen.setLocation(0, customerScreenY);
						repaint();
						try { Thread.sleep(10); } catch (Exception e) {}
						customerScreenY -= acc;
						acc += .5;
					}

					customerScreen.setLocation(0, 0);
					customerScreen.setBackground(new Color(255, 255, 255));

					runner.updateScreen(customerScreen);
				}
			});

			animate.start();

		});
		add(login);


		java.util.function.Function<Boolean, Boolean> reset = (bool) -> {
			firstName.setText("First name");
			lastName.setText("Last name");
			pin.setText("Pin");

			return true;
		};

		reset.apply(true);




		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();

	}

	public void draw(Graphics g) {
		drawBigTitle(g, Color.RED, "Login", 20, 50);

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
		notification.setX(20);

		Thread animate = new Thread(new Runnable() {
			public void run() {

				while (notification.getY() > 720) {
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