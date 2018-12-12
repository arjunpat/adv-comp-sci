package game;

import java.util.HashMap;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.Serializable;

public class Game implements Serializable {
	private HashMap<Location, Integer> map;

	private Location serverLocation;
	private Location clientLocation;
	private String status = "";

	private int itemsCollected;

	private String[] values = {
		"Food",
		"Wall",
		"Bomb",
		"Computer",
		"Phone",
		"Drink"
	};

	private String[] images = {
		"../items/images/food.png",
		"../items/images/wall.png",
		"../items/images/bomb.png",
		"../items/images/computer.png",
		"../items/images/phone.png",
		"../items/images/drink.png"
	};

	public Game() {

		serverLocation = new Location(520, 510);
		clientLocation = new Location(520, 500);

		map = new HashMap<Location, Integer>();
		
		// wall
		map.put(new Location(0, 2), 1);
		map.put(new Location(1, 2), 1);
		map.put(new Location(2, 2), 1);
		map.put(new Location(2, 3), 1);
		map.put(new Location(2, 4), 1);
		map.put(new Location(2, 5), 1);
		map.put(new Location(3, 2), 1);
		map.put(new Location(4, 2), 1);
		map.put(new Location(5, 2), 1);
		map.put(new Location(6, 2), 1);
		map.put(new Location(7, 6), 2);

		// inside L
		map.put(new Location(0, 3), 3);
		map.put(new Location(1, 5), 0);

		// outside L
		map.put(new Location(1, 1), 0);
		map.put(new Location(3, 3), 3);
		map.put(new Location(4, 4), 0);
		map.put(new Location(5, 6), 0);
		map.put(new Location(7, 7), 3);
		map.put(new Location(5, 3), 4);
		map.put(new Location(0, 6), 4);
		map.put(new Location(3, 6), 5);
		map.put(new Location(7, 5), 5);
		map.put(new Location(5, 1), 5);
		map.put(new Location(2, 1), 3);

	}

	public HashMap<Location, Integer> getMap() {
		return map;
	}

	public BufferedImage getImage(int i) {
		String filename = images[i];

		try {
			return ImageIO.read(getClass().getResource(filename));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String toString() {
		return "[Game class]";
	}

	public String getObjectName(int i) {
		return values[i];
	}

	public void setServerLocation(Location l) {
		serverLocation = l;
	}

	public void setClientLocation(Location l) {
		clientLocation = l;
	}

	public Location getServerLocation() {
		return serverLocation;
	}

	public Location getClientLocation() {
		return clientLocation;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String _getStatus() {
		return status;
	}

	public String getStatus() {
		String current = status;
		status = "";
		return current;
	}

	public boolean itemCollected() {
		itemsCollected++;

		return itemsCollected == 13;
	}
	
}