package items;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Notification extends Item {

	private String text;
	private double created;
	private boolean isGood;
	private int length;
	private int borderLength = 1;

	public Notification(String text, boolean isGood) {
		this.text = text;
		this.created = System.currentTimeMillis();
		this.isGood = isGood;
		length = 1000;
	}

	public Notification(String text, boolean isGood, int length) {
		this.text = text;
		this.created = System.currentTimeMillis();
		this.length = length;
		this.isGood = isGood;
	}

	public boolean isOld() {
		return System.currentTimeMillis() > created + length;
	}

	public void draw(Graphics g) {
		if (isGood) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.RED);
		}
		g.drawRect(20 - borderLength, 720 - borderLength, 400 + (2 * borderLength), 50 + (2 * borderLength));

		g.setColor(new Color(255, 255, 255, 220));
		g.fillRect(20, 720, 400, 50);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.BOLD, 14));

		g.drawString(text, 40, 750);
	}
}