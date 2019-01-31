import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.Timer;

import deck.*;

public class Runner extends View {

	private int score = 50;
	private Deck deck = new Deck();
	private DLList<Card> cardsToDisplay;
	private JButton playGameButton, drawButton, endButton;
	private Notification notification = new Notification("", 0);

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

				boolean shouldRepaint = false;

				for (int i = 0; i < 5; i++) {
					if (cardsToDisplay.get(i).isHovering()) {
						cardsToDisplay.get(i).setHovered(false);
						shouldRepaint = true;
					}
				}

				int i = getCardIndex(x, y);
				if (i > -1) {
					cardsToDisplay.get(i).setHovered(true);
					shouldRepaint = true;
				}

				if (shouldRepaint) {
					repaint();
				}
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
					repaint();
				}
			}
		});

		playGameButton = new JButton("Play!");
		playGameButton.setBounds(10, 350, 100, 50);
		playGameButton.addActionListener(e -> {
			score--;
			animateCardsOut();
			remove(playGameButton);
			add(drawButton);
			displayNotification("Select the cards you want to keep", 5000);
		});
		add(playGameButton);

		drawButton = new JButton("Draw");
		drawButton.setBounds(10, 350, 100, 50);
		drawButton.addActionListener(e -> {
			animateCardsInDraw();
			remove(drawButton);
			add(endButton);
			animateNotificationDown();
		});

		endButton = new JButton("Finish Game");
		endButton.setBounds(10, 350, 100, 50);
		endButton.addActionListener(e -> {
			animateCardsInDone();

			remove(endButton);
			add(playGameButton);
		});

		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();

	}

	public void draw(Graphics g) {

		for (int i = 0; i < cardsToDisplay.size(); i++) {
			cardsToDisplay.get(i).draw(g);
		}

		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.BOLD, 40));
		g.drawString("Your score: " + score, 10, 300);

		if (!notification.isDone())
			notification.draw(g);

		if (notification.isOld()) {
			notification.addASecond();
			animateNotificationDown();
		}

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

				final int increments = 35;

				cardsToDisplay.get(0).animateTo(100, 20, increments);
				incrementCard(cardsToDisplay.get(0), increments);

				cardsToDisplay.get(1).animateTo(310, 20, increments);
				incrementCard(cardsToDisplay.get(1), increments);

				cardsToDisplay.get(2).animateTo(520, 20, increments);
				incrementCard(cardsToDisplay.get(2), increments);

				cardsToDisplay.get(3).animateTo(730, 20, increments);
				incrementCard(cardsToDisplay.get(3), increments);

				cardsToDisplay.get(4).animateTo(940, 20, increments);
				incrementCard(cardsToDisplay.get(4), increments);
			}
		});

		thread.start();
	}

	public void animateCardsInDraw() {

		Thread thread = new Thread(new Runnable() {
			public void run() {

				final int increments = 40;
				int xinc = 0;
				int yinc = 0;

				for (int i = 0; i < 5; i++) {
					Card c = cardsToDisplay.get(i);

					if (c.isSelected()) {
						c.animateTo(1000 + xinc, 250 + yinc, increments);
						incrementCard(c, increments);
						xinc += 5;
						yinc += 5;
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

				final int increments = 15;

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

	public void displayNotification(String text, int time) {
		notification = new Notification(text, time);
		animateNotificationUp();
	}

	private void animateNotificationUp() {
		notification.setY(500);

		Thread animate = new Thread(new Runnable() {
			public void run() {

				while (notification.getY() > Notification.FINAL_Y) {
					try {
						Thread.sleep(Notification.ANIMATE_WAIT_TIME);
						notification.moveUp();
						repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		});

		animate.start();
	}

	private void animateNotificationDown() {

		Thread animate = new Thread(new Runnable() {
			public void run() {

				while (notification.getY() < 500) {
					try {
						Thread.sleep(Notification.ANIMATE_WAIT_TIME);
						notification.moveDown();
						repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				notification.done();

			}
		});

		animate.start();
	}

	private int getCardIndex(int x, int y) {
		if (y > 20 && y < 210) {
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