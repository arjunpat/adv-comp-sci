import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.util.Map.Entry;
import java.awt.image.BufferedImage;
import items.Player;
import items.Notification;
import game.Game;
import game.Location;

public class ClientGameScreen extends View {

	private Game game;
	private Client client;

	private Notification notification = new Notification("Your opponent is live", 4000);

	private Player player;
	private Player serverPlayer;
	private HashMap<String, Integer> itemsCollectedMap = new HashMap<String, Integer>();
	private Stack<Boolean> healthStack = new Stack<Boolean>();
	
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

					if (!game.getMap().containsKey(l)) {
						game.getMap().put(l, 2);
						game.setStatus("bomb");
					}

					client.sendGame(game);
					game.setStatus("");

					repaint();

					return;
				}


				checkHit();
				repaint();
				
				game.setClientLocation(new Location(player.getX(), player.getY()));
				client.sendGame(game);
				game.setStatus("");
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});

		for (int i = 0; i < 5; i++) {
			healthStack.push(true);
		}

	}

	public void draw(Graphics g) {

		drawGrid(g);

		Iterator<Entry<Location,Integer>> it = game.getMap().entrySet().iterator();

		while (it.hasNext()) {
			Entry<Location, Integer> e = it.next();
			Location l = e.getKey();
			BufferedImage pic = game.getImage(e.getValue());

			g.drawImage(pic, l.getX() * 100, l.getY() * 100, null);
		}

		serverPlayer.draw(g);
		player.draw(g);

		g.setColor(Color.BLUE);
		g.fillRect(650, 0, 150, 180);
		g.setFont(new Font("Tahoma", Font.BOLD, 14));
		g.setColor(Color.WHITE);
		g.drawString("Health: " + healthStack.size(), 660, 20);
		g.drawString("Items collected: " + player.getItemsCollected(), 660, 40);

		Iterator<Entry<String, Integer>> i = itemsCollectedMap.entrySet().iterator();

		int y = 60;
		while (i.hasNext()) {
			Entry<String, Integer> e = i.next();

			g.drawString(e.getKey() + ": " + e.getValue(), 660, y);

			y += 20;
		}

		if (!notification.isOld()) {
			notification.draw(g);
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
					game.setStatus("health");
				} else {
					client.lose("You ran out of health!");
					game.setStatus("lost");
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
				game.setStatus("collected");
			}
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
			notification = new Notification("Your opponent lost a health");
		} else if (status.equals("collected")) {
			notification = new Notification("Your opponent collected an item");
		} else if (status.equals("bomb")) {
			notification = new Notification("Your opponent has placed a bomb");
		}

		repaint();
	}
}