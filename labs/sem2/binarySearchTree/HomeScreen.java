import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class HomeScreen extends View {
	public HomeScreen(Runner runner, Database db) {
		JButton adminScreen = new JButton("Admin screen");
		adminScreen.setBounds(20, 350, 300, 100);
		adminScreen.addActionListener(e -> {

			Thread animate = new Thread(new Runnable() {
				public void run() {
					int adminScreenY = 400;
					double acc = 20;
					AdminScreen adminScreen = new AdminScreen(runner, db);
					adminScreen.setBounds(0, adminScreenY, 800, 800);
					adminScreen.setBackground(new Color(255, 255, 255, 0));
					add(adminScreen);

					while (adminScreenY > 0) {
						int opacity = (int)(255 * ((400 - adminScreenY) / 400.0));
						adminScreen.setBackground(new Color(255, 255, 255, opacity));
						adminScreen.setLocation(0, adminScreenY);
						repaint();
						try { Thread.sleep(10); } catch (Exception e) {}
						adminScreenY -= acc;
						acc += .5;
					}

					adminScreen.setLocation(0, 0);
					adminScreen.setBackground(new Color(255, 255, 255));

					runner.updateScreen(adminScreen);
				}
			});

			animate.start();
		});
		add(adminScreen);

		JButton customerScreenBtn = new JButton("Customer screen");
		customerScreenBtn.setBounds(400, 350, 300, 100);
		customerScreenBtn.addActionListener(e -> {
			Thread animate = new Thread(new Runnable() {
				public void run() {
					int customerScreenY = 400;
					double acc = 20;
					LoginScreen customerScreen = new LoginScreen(runner, db);
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
		add(customerScreenBtn);
	}

	public void draw(Graphics g) {
	}
}