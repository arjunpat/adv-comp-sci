import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import deck.*;

public class Runner extends View {

	private int score = 50;
	private Deck deck = new Deck();
	private DLList<Card> cardsToDisplay;
	private JButton playGameButton, drawButton, endButton;

	public Runner() {

		cardsToDisplay = new DLList<Card>();
		for (int i = 0; i < 5; i++) {
			cardsToDisplay.add(deck.drawCard());
		}

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				for (int i = 0; i < 5; i++) {
					cardsToDisplay.get(i).setHovered(false);
				}

				int i = getCardIndex(x, y);
				if (i > -1) {
					cardsToDisplay.get(i).setHovered(true);
				}

				repaint();
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				int i = getCardIndex(x, y);
				if (i > -1) {
					cardsToDisplay.get(i).toggleSelected();
				}

				repaint();
			}
		});

		playGameButton = new JButton("Play!");
		playGameButton.setBounds(10, 350, 100, 50);
		playGameButton.addActionListener(e -> {
			score--;
			animateCardsOut();
			remove(playGameButton);
			add(drawButton);
		});
		add(playGameButton);

		drawButton = new JButton("Draw");
		drawButton.setBounds(10, 350, 100, 50);
		drawButton.addActionListener(e -> {
			animateCardsInDraw();
			remove(drawButton);
			add(endButton);
		});

		endButton = new JButton("Finish Game");
		endButton.setBounds(10, 350, 100, 50);
		endButton.addActionListener(e -> {
			animateCardsInDone();

			remove(endButton);
			add(playGameButton);
		});

	}

	public void draw(Graphics g) {

		for (int i = 0; i < cardsToDisplay.size(); i++) {
			cardsToDisplay.get(i).draw(g);
		}

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.BOLD, 40));
		g.drawString("Your score: " + score, 10, 300);

	}

	public void incrementCard(Card c, int increments) {
		for (int i = 0; i < increments; i++) {
			try {
				Thread.sleep(15);
				c.increment();
				repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void animateCardsOut() {

		Thread thread = new Thread(new Runnable() {

			public void run() {

				final int increments = 25;

				cardsToDisplay.get(0).animateTo(100, 10, increments);
				incrementCard(cardsToDisplay.get(0), increments);

				cardsToDisplay.get(1).animateTo(310, 10, increments);
				incrementCard(cardsToDisplay.get(1), increments);

				cardsToDisplay.get(2).animateTo(520, 10, increments);
				incrementCard(cardsToDisplay.get(2), increments);

				cardsToDisplay.get(3).animateTo(730, 10, increments);
				incrementCard(cardsToDisplay.get(3), increments);

				cardsToDisplay.get(4).animateTo(940, 10, increments);
				incrementCard(cardsToDisplay.get(4), increments);
			}
		});

		thread.start();
	}

	public void animateCardsInDraw() {

		Thread thread = new Thread(new Runnable() {
			public void run() {

				final int increments = 25;

				for (int i = 4; i >= 0; i--) {
					Card c = cardsToDisplay.get(i);

					if (c.isSelected()) {
						c.animateTo(1000, 300, increments);
						incrementCard(c, increments);
					} else {
						c.animateTo(500, -210, increments);
						incrementCard(c, increments);
						cardsToDisplay.set(i, deck.drawCard());
					}
				}

				try { Thread.sleep(500); } catch (Exception e) {}

				animateCardsOut();
			}
		});

		thread.start();
	}

	public void animateCardsInDone() {

		Thread thread = new Thread(new Runnable() {
			public void run() {

				final int increments = 25;

				for (int i = 4; i >= 0; i--) {
					Card c = cardsToDisplay.get(i);
					c.animateTo(500, -210, increments);
					incrementCard(c, increments);
				}

				deck.loadDeck();
				cardsToDisplay = new DLList<Card>();

				for (int i = 0; i < 5; i++) {
					cardsToDisplay.add(deck.drawCard());
				}
			}
		});

		thread.start();
	}

	private int getCardIndex(int x, int y) {
		if (y > 10 && y < 210) {
			if (100 < x && x < 225) {
				return 0;
			} else if (310 < x && x < 435) {
				return 1;
			} else if (520 < x && x < 645) {
				return 2;
			} else if (730 < x && x < 855) {
				return 3;
			} else if (940 < x && x < 1065) {
				return 4;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Poker");

		frame.add(new Runner());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}