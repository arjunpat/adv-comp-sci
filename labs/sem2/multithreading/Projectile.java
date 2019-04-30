import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Projectile {
	private int x, y;

	public Projectile(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveRight() {
		x += 5;
	}

	public int getX() {
		return x;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 10, 10);
	}
}
