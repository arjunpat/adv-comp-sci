import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class Client extends View {

	private Game game;
	private Socket conn;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public Client() {
		game = new Game();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				if (x > 20 && x < 620 && y > 20 && y < 620 && game.isMyTurn("client")) {
					int r = (y - 20) / 200;
					int c = (x - 20) / 200;
					if (game.makeTurn(r, c)) {
						repaint();
						try {
							out.writeObject(game);
						} catch (Exception err) {
							System.out.println(err);
						}
					}
				}
			}
		});

	}

	public void draw(Graphics g) {

		drawTitle(g, "Player 2", 20, 680);

		drawGameBoard(g);

		String res = game.checkWin();

		if (!res.equals("none")) g.setFont(new Font("Tahoma", Font.PLAIN, 24));
		if (res.equals("client")) {
			g.drawString("You won!", 20, 730);
		} else if (res.equals("server")) {
			g.drawString("You lost!", 20, 730);
		} else if (res.equals("draw")) {
			g.drawString("It is a draw", 20, 730);
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
		conn = new Socket("localhost", 8080);

		out = new ObjectOutputStream(conn.getOutputStream());
		in = new ObjectInputStream(conn.getInputStream());

		while (true) {
			game = (Game) in.readObject();
			repaint();
		}
	}

	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Client");
		Client client = new Client();

		frame.add(client);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		client.poll();
	}
}