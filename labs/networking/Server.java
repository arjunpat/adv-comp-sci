import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;


public class Server extends View {

	Game game;

	public Server() {
		game = new Game();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				if (x > 20 && x < 620 && y > 20 && y < 620 && game.isMyTurn("server")) {
					int r = (y - 20) / 200;
					int c = (x - 20) / 200;
					game.makeTurn(r, c);
					repaint();
				}
			}
		});

	}

	public void draw(Graphics g) {


		drawGameBoard(g);
	}

	private void drawGameBoard(Graphics g) {
		int[][] board = game.getBoard();

		// width 600, height 600

		g.setColor(black);
		g.setFont(new Font("Tahoma", Font.PLAIN, 60));
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				g.drawRect((200 * c) + 20, (200 * r) + 20, 200, 200);

				if (board[r][c] == 1) {
					g.drawString("X", (200 * c) + 90, (200 * r) + 140);
				} else if (board[r][c] == -1) {
					g.drawString("O", (200 * c) + 90, (200 * r) + 140);
				}
			}
		}
	}

	public void poll() {

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Server");
		Server server = new Server();

		frame.add(server);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		server.poll();
	}

}