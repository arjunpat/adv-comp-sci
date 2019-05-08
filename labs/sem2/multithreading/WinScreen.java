import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WinScreen extends View {
	private Runner screenManager;

	public WinScreen(Runner screenManager) {
		this.screenManager = screenManager;

		JButton btn = new JButton("Play again");
		btn.setBounds(20, 120, 250, 50);
		btn.addActionListener(e -> {
			screenManager.showStartScreen();
		});
		add(btn);

	}

	public void draw(Graphics g) {

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 36));
		g.drawString("You Win", 20, 30);

		g.setFont(new Font("Tahoma", Font.PLAIN, 24));
		g.drawString("Thanks for playing", 20, 80);

	}
}
