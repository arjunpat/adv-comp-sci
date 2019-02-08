package articles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Dirt extends Article {
	private BufferedImage picture;
	private int x, y;

	public Dirt(int x, int y) {
		this.x = x;
		this.y = y;

		try {
			picture = ImageIO.read(getClass().getResource("images/dirt.jpeg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(picture, x, y, 40, 40, null);
	}

	public int hashCode() {
		return (x / 20) + (20 * ((y / 20)));
	}
}