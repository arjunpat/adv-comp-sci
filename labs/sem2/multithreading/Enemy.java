import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Enemy implements Runnable {
	private int x, y, ix, iy;
	private double dx, dy;
	private BufferedImage picture;
	private boolean hit = false;

	public Enemy(int x, int y, double dx, double dy) {
		this.x = x;
		this.y = y;
		this.ix = x;
		this.iy = y;
		this.dx = dx;
		this.dy = dy;

		try {
			picture = ImageIO.read(getClass().getResource("img/enemy.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (!hit) {
			x += dx;
			y += dy;

			if (x > 800 || x < 0) {
				dx = -dx + (Math.random() * 4) - 2;
			}

			if (y > 800 || y < 0) {
				dy = -dy  + (Math.random() * 4) - 2;
			}

			try { Thread.sleep(30); } catch (Exception e) {}
		}
	}

	public void draw(Graphics g) {
		g.drawImage(picture, x, y, null);
	}

	public void goToInitial() {
		x = ix;
		y = iy;
	}

	public boolean checkCollision(SpaceFighter p) {
		int pX = p.getX();
		int pY = p.getY();
		int pWidth = 120;
		int pHeight = 70;

		return pX + pWidth >= x && pX <= x + pWidth && pY + pHeight >= y && pY <= y + pHeight;
	}
}
