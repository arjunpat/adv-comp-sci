import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.Timer;

public class GameScreen extends View {
	private Runner screenManager;
	private SpaceFighter player = new SpaceFighter(50, 200);
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public GameScreen(Runner screenManager) {
		this.screenManager = screenManager;


		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();

				if (keyCode == 40) {
					player.moveUp();
				} else if (keyCode == 38) {
					player.moveDown();
				} else if (keyCode == 32) { // space, shoot projectile
					Projectile p = new Projectile(player.getX() + 140, player.getY() + 40);
					projectiles.add(p);

					Thread t = new Thread(new Runnable() {
						public void run() {
							while (p.getX() < 800) {
								try { Thread.sleep(15); } catch (Exception e) {}
								p.moveRight();
							}

							projectiles.remove(p);
						}
					});

					t.start();
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});

		Timer timer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();
	}

	public void draw(Graphics g) {
		g.setColor(new Color(20, 20, 20));
		g.fillRect(0, 0, 800, 800);

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}

		player.draw(g);
	}
}
