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
	private ArrayList<Projectile> bossProjectiles = new ArrayList<Projectile>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private int lives = 3;
	private boolean boss = false;
	private Boss theBoss;
	private Thread theBossThread;

	public GameScreen(Runner screenManager) {
		super();
		this.screenManager = screenManager;
		setRequestFocusEnabled(true);
		grabFocus();

		theBoss = new Boss((int)(Math.random() * 400) + 400, (int)(Math.random() * 800), (Math.random() * 2) + 3, (Math.random() * 2) + 3);
		theBossThread = new Thread(theBoss);

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
				} else if (keyCode == 80) {
					if (boss) {
						theBoss.kill();
					} else {
						enemies.clear();
					}
				}
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});

		Timer timer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
				requestFocusInWindow();

				if (Math.random() < .05) {
					Projectile p = new Projectile(theBoss.getX(), theBoss.getY());
					p.setColor(Color.RED);
					bossProjectiles.add(p);

					Thread t = new Thread(new Runnable() {
						public void run() {
							while (p.getX() > 0) {
								try { Thread.sleep(15); } catch (Exception e) {}
								p.moveLeft();
							}

							bossProjectiles.remove(p);
						}
					});

					t.start();
				}
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

			if (boss) {
				if (theBoss.checkCollision(p)) {
					theBoss.reduceLives();
					projectiles.remove(p);
				}
			} else {
				for (int j = 0; j < enemies.size(); j++) {
					if (enemies.get(j).checkCollision(p)) {
						projectiles.remove(p);
						enemies.remove(enemies.get(j));
						playSound("sounds/ping.mp3");
						break;
					}
				}
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			e.draw(g);

			if (e.checkCollision(player)) {
				lives--;
				e.goToInitial();
				player.goToInitial();

				playSound("sounds/ping.mp3");
			}
		}

		if (boss) {
			theBoss.draw(g);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Tahoma", Font.PLAIN, 24));
			int bossLives = theBoss.getLives();
			g.drawString("Boss lives: " + bossLives, 650, 60);

			if (bossLives == 0) {
				screenManager.goToWinScreen();
			}

			for (int i = 0; i < bossProjectiles.size(); i++) {
				Projectile p = bossProjectiles.get(i);
				p.draw(g);

				if (player.checkCollision(p)) {
					bossProjectiles.remove(i);
					lives--;
					player.goToInitial();
				}
			}
		} else if (enemies.size() == 0) {
			boss = true;
			theBossThread.start();
		}

		if (lives == 0) {
			screenManager.goToLoseScreen();
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
