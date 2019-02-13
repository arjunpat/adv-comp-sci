import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import articles.*;

public class Runner extends View {

	private Database database = new Database();
	private Player player = new Player(400, 480);

	public Runner() {

		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int dx = 0;
				int dy = 0;

				if (keyCode == 40) {
					dy += 40;
				} else if (keyCode == 38) {
					dy -= 40;
				} else if (keyCode == 39) {
					dx += 40;
				} else if (keyCode == 37) {
					dx -= 40;
				}

				player.updateLocation(dx, dy);

				if (!database.canMove(player)) {
					player.updateLocation(-dx, -dy);
				}


				repaint();
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});

	}

	public void draw(Graphics g) {

		DLList<Article>[] table = database.getArr();

		for (int i = 0; i < table.length; i++) {
			DLList<Article> each = table[i];
			for (int j = 0; j < each.size(); j++) {
				each.get(j).draw(g);
			}
		}

		drawGrid(g);

		player.draw(g);
	}

	private void drawGrid(Graphics g) {
		g.setColor(Color.BLACK);

		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				g.drawRect(c * 40, r * 40, 40, 40);
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Scenery Grid");

		frame.add(new Runner());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}