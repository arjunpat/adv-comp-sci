package articles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Tree extends Article {
	private BufferedImage picture;
	private int x, y;
	private final int overlayNumber = 2;

	public Tree(int x, int y, BufferedImage picture) {
		this.x = x;
		this.y = y;

		this.picture = picture;
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(picture, x, y, 40, 40, null);
	}

	public int hashCode() {
		return (x / 40) + (20 * ((y / 40)));
	}

	public int getOverlayNumber() {
		return overlayNumber;
	}
}