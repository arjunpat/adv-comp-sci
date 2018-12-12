package items;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Notification extends Item {

	private String text;
	private double created;
	private int length;
	private int borderLength = 3;

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
		g.fillRect(150 - borderLength, 0, 400 + (2 * borderLength), 40 + borderLength);

		g.setColor(Color.WHITE);
		g.fillRect(150, 0, 400, 40);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.BOLD, 14));

		g.drawString(text, 175, 25);
	}
}