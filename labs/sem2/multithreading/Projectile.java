import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Projectile {
	private int x, y;
	private Color col = Color.WHITE;

	public Projectile(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveRight() {
		x += 5;
	}

	public void moveLeft() {
		x -= 5;
	}

	public void setColor(Color c) {
		col = c;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(Graphics g) {
		g.setColor(col);
		g.fillRect(x, y, 10, 10);
	}
}
