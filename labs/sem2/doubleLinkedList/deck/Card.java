package deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Card {
	private int suit; // 1 clubs, 2 diamonds, 3 hearts, 4 spades
	private int card; // 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 Jacks, 12 Queens, 13 Kings, 14 Ace
	private boolean selected = false;
	private boolean hovered = false;
	private double x = 500;
	private double y = -210;
	private BufferedImage picture;

	public Card(int suit, int card) {
		this.suit = suit;
		this.card = card;

		try {
			picture = ImageIO.read(getClass().getResource("images/" + getSuitName() + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getSuit() {
		return suit;
	}

	public int getCard() {
		return card;
	}

	public String getCardName() {
		String[] names = {"", "", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

		return names[card];
	}

	public String getSymbol() {
		String[] names = {"", "", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

		return names[card];
	}

	public String getSuitName() {
		String[] names = {"", "Club", "Diamond", "Heart", "Spade"};

		return names[suit];
	}

	public String toString() {
		return getSuitName() + " - " + getCardName();
	}

	public void toggleSelected() {
		this.selected = !selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}

	public boolean isHovering() {
		return hovered;
	}

	private double xStep;
	private double yStep;
	public void animateTo(int finalX, int finalY, int increments) {
		xStep = (finalX - x) / increments;
		yStep = (finalY - y) / increments;
	}

	public void increment() {
		x += xStep;
		y += yStep;
	}

	public void draw(Graphics g) {

		int x = (int)this.x;
		int y = (int)this.y;

		if (hovered && !selected) {
			g.setColor(new Color(255, 210, 210));
			g.fillRoundRect(x, y, 125, 200, 15, 15);
			g.setColor(Color.BLACK);
			g.drawRoundRect(x, y, 125, 200, 15, 15);
		} else if (selected) {
			// y += 35;
			g.setColor(Color.RED);
			g.fillRoundRect(x - 3, y - 3, 125 + 6, 200 + 6, 15, 15);
			g.setColor(new Color(255, 210, 210));
			g.fillRoundRect(x, y, 125, 200, 15, 15);
			g.setColor(Color.RED);
			g.drawRoundRect(x, y, 125, 200, 15, 15);
		} else {
			g.setColor(Color.WHITE);
			g.fillRoundRect(x, y, 125, 200, 15, 15);
			g.setColor(Color.BLACK);
			g.drawRoundRect(x, y, 125, 200, 15, 15);
		}

		if (suit == 2 || suit == 3) {
			g.setColor(Color.RED);
		}

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.BOLD, 40));

		String symbol = getSymbol();

		g.drawString(symbol, x + 9, y + 75);
		g.drawImage(picture, x + 6, y + 6, null);

		if (symbol.length() == 1) {
			g.drawString(getSymbol(), x + 93, y + 154);
		} else {
			g.drawString(getSymbol(), x + 73, y + 154);
		}

		g.drawImage(picture, x + 90, y + 160, null);
	}
}