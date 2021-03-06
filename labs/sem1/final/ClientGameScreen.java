import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import items.Player;
import items.Notification;
import game.Game;
import game.Location;

import javax.swing.Timer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.Map.Entry;
import java.awt.image.BufferedImage;

public class ClientGameScreen extends View {

	private Game game;
	private Client client;

	private Notification notification = new Notification("", false, 0);

	private Player player;
	private Player serverPlayer;
	private HashMap<String, Integer> itemsCollectedMap = new HashMap<String, Integer>();
	private Stack<Boolean> healthStack = new Stack<Boolean>();

	private HashMap<Integer, BufferedImage> images = new HashMap<Integer, BufferedImage>();
	
	public ClientGameScreen(Client client) {
		game = new Game();
		this.client = client;

		Location l = game.getClientLocation();
		player = new Player(l.getX(), l.getY(), "images/player2.png");
		l = game.getServerLocation();
		serverPlayer = new Player(l.getX(), l.getY(), "images/player1.png");

		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();

				if (keyCode == 40) {
					player.moveUp();
				} else if (keyCode == 38) {
					player.moveDown();
				} else if (keyCode == 39) {
					player.moveRight();
				} else if (keyCode == 37) {
					player.moveLeft();
				} else if (keyCode == 32) { // spacebar, place bomb

					Location l = getCurrentLocation();

					if (!game.getMap().containsKey(l) && itemsCollectedMap.get("Bombs left") > 0) {
						game.getMap().put(l, 2);
						game.setStatus("bomb");

						itemsCollectedMap.put("Bombs left", itemsCollectedMap.get("Bombs left") - 1);

					} else {
						displayNotification("You cannot place a bomb here", false);
					}

					client.sendGame(game);

					repaint();

					return;
				}


				checkHit();
				repaint();
				
				game.setClientLocation(new Location(player.getX(), player.getY()));
				client.sendGame(game);
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});

		for (int i = 0; i < 5; i++) {
			healthStack.push(true);
		}

		itemsCollectedMap.put("Bombs left", 5);

		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();

	}

	public void draw(Graphics g) {

		drawGrid(g);

		Iterator<Entry<Location,Integer>> it = game.getMap().entrySet().iterator();

		while (it.hasNext()) {
			Entry<Location, Integer> e = it.next();
			int itemType = e.getValue();
			Location l = e.getKey();

			BufferedImage pic;

			if (images.containsKey(itemType)) {
				pic = images.get(itemType);
			} else {
				pic = game.getImage(itemType);
				images.put(itemType, pic);
			}

			g.drawImage(pic, l.getX() * 100, l.getY() * 100, null);
		}

		serverPlayer.draw(g);
		player.draw(g);

		g.setColor(new Color(0, 0, 255, 220));
		g.fillRect(650, 0, 150, 180);
		g.setFont(new Font("Tahoma", Font.BOLD, 14));
		g.setColor(Color.WHITE);
		g.drawString("My health: " + healthStack.size(), 660, 20);
		g.drawString("Items collected: " + player.getItemsCollected(), 660, 40);

		Iterator<Entry<String, Integer>> i = itemsCollectedMap.entrySet().iterator();

		int y = 60;
		while (i.hasNext()) {
			Entry<String, Integer> e = i.next();

			g.drawString(e.getKey() + ": " + e.getValue(), 660, y);

			y += 20;
		}

		if (!notification.isDone())
			notification.draw(g);

		if (notification.isOld()) {
			notification.addASecond();
			animateNotificationDown();
		}

	}

	private void drawGrid(Graphics g) {

		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				g.setColor(Color.BLACK);
				g.drawRect(c * 100, r * 100, 100, 100);

			}
		}

	}

	private void checkHit() {
		Location l = getCurrentLocation();

		if (game.getMap().containsKey(l)) {

			int itemType = game.getMap().get(l);
			if (itemType == 1 || itemType == 2) {

				if (healthStack.size() > 1) {
					healthStack.pop();
					player.moveTo(520, 500);

					displayNotification("You touched an obstacle and lost a health", false);
					game.setStatus("health");
					playOofSound();
				} else {
					client.lose("You ran out of health!");
					game.setStatus("lost");
				}

				if (itemType == 2) {
					game.getMap().remove(l);
				}

			} else {
				String key = game.getObjectName(game.getMap().get(l));
				if (itemsCollectedMap.containsKey(key)) {
					itemsCollectedMap.put(key, itemsCollectedMap.get(key) + 1);
				} else {
					itemsCollectedMap.put(key, 1);
				}

				game.getMap().remove(l);
				player.itemCollected();
				if (game.itemCollected()) {
					game.setStatus("done");
					displayResults();
				} else {
					game.setStatus("collected");
					playDingSound();
				}
			}
		}
	}

	private void playDingSound() { playSound("items/sounds/ding.wav"); }
	private void playOofSound() { playSound("items/sounds/oof.wav"); }

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

	public void displayNotification(String text, boolean isGood) {
		notification = new Notification(text, isGood);
		animateNotificationUp();
	}

	public void displayNotification(String text, boolean isGood, int time) {
		notification = new Notification(text, isGood, time);
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

	private void displayResults() {
		int collected = player.getItemsCollected();

		if (collected > 6) {
			client.win("You collected " + collected + " of the 13 items!");
		} else {
			client.lose("You collected " + collected + " of the 13 items!");
		}
	}

	private Location getCurrentLocation() {
		int x = (int)(player.getX() / 100);
		int y = (int)(player.getY() / 100);

		return new Location(x, y);
	}

	public void changeOccured(Game game) {
		this.game = game;

		Location l = game.getServerLocation();
		serverPlayer.moveTo(l.getX(), l.getY());

		String status = game.getStatus();
		if (status.equals("lost")) {
			client.win("Your opponent ran out of health");
		} else if (status.equals("health")) {
			displayNotification("Your opponent lost a health", true);
		} else if (status.equals("collected")) {
			displayNotification("Your opponent collected an item", false);
		} else if (status.equals("bomb")) {
			displayNotification("Your opponent has placed a bomb", false);
		} else if (status.equals("done")) {
			displayResults();
		}

		repaint();
	}
}