import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SpaceFighter {
	private int x, y;
	private BufferedImage picture;
	private int moveConstant = 12;

	public SpaceFighter(int x, int y) {
		this.x = x;
		this.y = y;

		try {
			picture = ImageIO.read(getClass().getResource("img/spaceship.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveUp() {
		if (y + moveConstant <= 800)
			y += moveConstant;
	}

	public void moveDown() {
		if (y - moveConstant >= 0)
			y -= moveConstant;
	}

	public void moveLeft() {
		if (x - moveConstant >= 0)
			x -= moveConstant;
	}

	public void moveRight() {
		if (x + moveConstant <= 800)
			x += moveConstant;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(Graphics g) {
		g.drawImage(picture, x, y, null);
	}
}
