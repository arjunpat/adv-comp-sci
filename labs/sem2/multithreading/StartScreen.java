import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StartScreen extends View {
	private Runner screenManager;

	public StartScreen(Runner screenManager) {
		this.screenManager = screenManager;

		JButton btn = new JButton("Start game");
		btn.setBounds(20, 120, 250, 50);
		btn.addActionListener(e -> {
			screenManager.showGameScreen();
		});
		add(btn);

	}

	public void draw(Graphics g) {

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 36));
		g.drawString("Welcome", 20, 30);

		g.setFont(new Font("Tahoma", Font.PLAIN, 24));
		g.drawString("Move the spaceship around with the arrow keys. Use keyboard to shoot", 20, 80);

	}
}
