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

	private String[] values = {
		"Food",
		"Wall",
		"Bomb"
	};

	private String[] images = {
		"../items/images/food.png",
		"../items/images/wall.png",
		"../items/images/wall.png"
	};

	public Game() {

		serverLocation = new Location(520, 510);
		clientLocation = new Location(520, 500);

		map = new HashMap<Location, Integer>();

		map.put(new Location(1, 1), 0);
		
		map.put(new Location(0, 2), 1);
		map.put(new Location(1, 2), 1);
		map.put(new Location(2, 2), 1);
		map.put(new Location(2, 3), 1);
		map.put(new Location(2, 4), 1);
		map.put(new Location(2, 5), 1);

		map.put(new Location(3, 3), 0);
		map.put(new Location(4, 4), 0);
		map.put(new Location(5, 5), 0);
		map.put(new Location(7, 7), 0);

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
	
}