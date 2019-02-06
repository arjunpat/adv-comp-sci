import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Notification {

	private String text;
	private double created;
	private int length;
	private int borderLength = 1;

	private int x = 780;
	private int y = 500;

	private boolean done = false;

	public static int FINAL_Y = 420;
	public static int ANIMATE_WAIT_TIME = 5;

	public Notification(String text) {
		this.text = text;
		this.created = System.currentTimeMillis();
		length = 1000;
	}

	public Notification(String text, int length) {
		this.text = text;
		this.created = System.currentTimeMillis();
		this.length = length;
	}

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isOld() {
		return System.currentTimeMillis() > created + length;
	}

	public void draw(Graphics g) {

		g.setColor(new Color(50, 50, 50, 150));
		g.fillRoundRect(x, y, 403, 53, 8, 8);

		g.setColor(Color.WHITE);
		g.fillRoundRect(x, y, 400, 50, 8, 8);

		g.setColor(new Color(50, 50, 50, 240));
		g.setFont(new Font("Tahoma", Font.PLAIN, 14));

		g.drawString(text, x + 20, y + 30);
	}

	public void moveUp() {
		y -= 3;
	}

	public void moveDown() {
		y += 3;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void addASecond() {
		created += 1000;
	}

	public void done() {
		done = true;
	}

	public boolean isDone() {
		return done;
	}
}