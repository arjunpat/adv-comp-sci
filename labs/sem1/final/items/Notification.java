package items;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Notification extends Item {

	private String text;
	private double created;
	private int length;

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

	public boolean isOld() {
		return System.currentTimeMillis() > created + length;
	}

	public void draw(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(148, 0, 404, 44);

		g.setColor(Color.WHITE);
		g.fillRect(150, 2, 400, 40);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.BOLD, 14));

		g.drawString(text, 175, 28);
	}
}