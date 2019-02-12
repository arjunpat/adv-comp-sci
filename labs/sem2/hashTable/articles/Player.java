package articles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Player extends Article {
	private BufferedImage picture;
	private int x, y;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;

		try {
			picture = ImageIO.read(getClass().getResource("images/player.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveRight() {
		x += 40;
	}

	public void moveLeft() {
		x -= 40;
	}

	public void moveUp() {
		y += 40;
	}

	public void moveDown() {
		y -= 40;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(picture, x, y, 40, 40, null);
	}

	public int hashCode() {
		return (x / 40) + (20 * ((y / 40)));
	}

	public int getOverlayNumber() {
		return 0;
	}
}