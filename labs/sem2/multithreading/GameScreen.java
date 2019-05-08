import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.Timer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class GameScreen extends View {
	private Runner screenManager;
	private SpaceFighter player = new SpaceFighter(50, 200);
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private int lives = 3;

	public GameScreen(Runner screenManager) {
		super();
		this.screenManager = screenManager;
		setRequestFocusEnabled(true);
		grabFocus();

		for (int i = 0; i < 5; i++) {
			int x = (int)(Math.random() * 400) + 400;
			int y = (int)(Math.random() * 800);
			double dx = (Math.random() * 2) + 1;
			double dy = (Math.random() * 2) + 1;

			Enemy e = new Enemy(x, y, dx, dy);
			Thread t = new Thread(e);
			t.start();

			enemies.add(e);
		}


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
					playSound("sounds/ping.wav");

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
				requestFocusInWindow();
			}
		});
		timer.start();

	}

	public void draw(Graphics g) {
		g.setColor(new Color(20, 20, 20));
		g.fillRect(0, 0, 800, 800);

		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			p.draw(g);

			for (int j = 0; j < enemies.size(); j++) {
				if (enemies.get(j).checkCollision(p)) {
					projectiles.remove(p);
					enemies.remove(enemies.get(j));
					playSound("sounds/ping.mp3");
				}
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			e.draw(g);

			if (e.checkCollision(player)) {
				lives--;
				e.goToInitial();

				playSound("sounds/ping.mp3");

				if (lives == 0) {
					screenManager.goToLoseScreen();
				}
			}
		}

		player.draw(g);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Tahoma", Font.PLAIN, 24));
		g.drawString("Lives: " + lives, 700, 30);
	}

	private void playSound(String filename) {
		try {
			URL url = this.getClass().getClassLoader().getResource(filename);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(url));
			clip.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
