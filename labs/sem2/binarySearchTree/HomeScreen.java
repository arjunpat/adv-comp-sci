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

		JButton customerScreen = new JButton("Customer screen");
		customerScreen.setBounds(400, 350, 300, 100);
		add(customerScreen);
	}

	public void draw(Graphics g) {
	}
}