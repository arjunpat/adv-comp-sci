import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class Server extends View {

	private Game game;
	private ServerSocket app;
	private Socket client;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public Server() {
		game = new Game();

		JButton btn = new JButton("Reset game");
		btn.setBounds(630, 80, 150, 50);
		btn.addActionListener(e -> {
			game.resetBoard();
			sendGame();
			repaint();
		});
		this.add(btn);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				if (x > 20 && x < 620 && y > 20 && y < 620 && game.isMyTurn("server")) {
					int r = (y - 20) / 200;
					int c = (x - 20) / 200;
					if (game.makeTurn(r, c)) {
						repaint();
						sendGame();
					}
				}
			}
		});

	}

	public void draw(Graphics g) {

		if (!game.isPlayingAI()) {
			drawTitle(g, blue, "Player 1", 20, 680);

			drawGameBoard(g);

			String res = game.checkWin();

			if (!res.equals("none")) g.setFont(new Font("Tahoma", Font.PLAIN, 24));
			if (res.equals("server")) {
				g.drawString("You won!", 20, 730);
			} else if (res.equals("client")) {
				g.drawString("You lost!", 20, 730);
			} else if (res.equals("draw")) {
				g.drawString("It is a draw", 20, 730);
			}

			g.setFont(new Font("Tahoma", Font.PLAIN, 18));
			g.drawString("Your wins: " + game.getServerWins(), 400, 680);
			g.drawString("Their wins: " + game.getClientWins(), 400, 730);
		} else {
			drawTitle(g, blue, "Player 2 is playing AI right now", 20, 50);
		}
	}

	private void drawGameBoard(Graphics g) {
		// width 600, height 600

		g.setFont(new Font("Tahoma", Font.PLAIN, 60));
		g.setColor(black);
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				int val = game.getBoardAt(r, c);
				g.drawRect((200 * c) + 20, (200 * r) + 20, 200, 200);

				if (val == 1) {
					g.drawString("X", (200 * c) + 90, (200 * r) + 140);
				} else if (val == -1) {
					g.drawString("O", (200 * c) + 90, (200 * r) + 140);
				}
			}
		}
	}

	public void poll() throws Exception {

		app = new ServerSocket(8080);
		client = app.accept();

		out = new ObjectOutputStream(client.getOutputStream());
		in = new ObjectInputStream(client.getInputStream());

		while (true) {
			game = (Game) in.readObject();

			if (game.isPlayingAI()) {

				if (Math.random() > .5) {
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							if (game.isMyTurn("server")) {
								game.makeTurn(r, c);
							} else break;
						}
					}
				} else {
					for (int r = 2; r >= 0; r--) {
						for (int c = 2; c >= 0; c--) {
							if (game.isMyTurn("server")) {
								game.makeTurn(r, c);
							} else break;
						}
					}
				}

				sendGame();
			}

			repaint();
		}

	}

	private void sendGame() {
		try {
			out.reset();
			out.writeObject(game);
		} catch (Exception err) {
			System.out.println(err);
		}
	}

	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Server");
		Server server = new Server();

		frame.add(server);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		server.poll();
	}

}
