import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {

	private int squareSize = 7;
	private int gridSize = 80;
	private Stack<Square[][]> history = new Stack<Square[][]>();
	private Square[][] current;
	private Color currentColor = new Color(0, 0, 0);

	public Screen() {
		super();

		this.current = new Square[gridSize][gridSize];
		for (int r = 0; r < this.current.length; r++) {
			for (int c = 0; c < this.current[0].length; c++) {
				this.current[r][c] = new Square(squareSize);
			}
		}

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				System.out.println("Moused clicked at (" + x + ", " + y + ")");

				// if they want to change color
				if (x > 20 && x < 20 + 255 && y > 650 && y < 650 + 128) {
					currentColor = new Color(255, x - 20, 2 * (y - 650));
				} else if (x > 20 ) {

				}

				repaint();
			}
		});

	}

	public void draw(Graphics g) {

		this.drawGrid(g, this.current);
		this.drawColorChooser(g);

		this.drawCurrentColor(g, this.currentColor);
		drawTitle(g, red, "Color chooser", 20, 620);
		drawTitle(g, red, "Current color", 350, 620);


	}

	private Square[][] cloneGrid(Square[][] squareGrid) {

		Square[][] temp = new Square[squareGrid.length][squareGrid[0].length];

		for (int r = 0; r < squareGrid.length; r++) {
			for (int c = 0; c < squareGrid[0].length; c++) {
				temp[r][c] = squareGrid[r][c].clone();
			}
		}

		return temp;
	}

	private void drawGrid(Graphics g, Square[][] toDraw) {

		for (int r = 0; r < toDraw.length; r++) {
			for (int c = 0; c < toDraw[0].length; c++) {
				toDraw[r][c].draw(g, 20 + (squareSize * c), 20 + (squareSize * r));
			}
		}

	}

	private void drawColorChooser(Graphics g) {

		int startX = 20;
		int startY = 650;

		for (int blue = 0; blue <= 255; blue += 2) {
			for (int green = 0; green <= 255; green++) {
					g.setColor(new Color(255, green, blue));
					g.fillRect(startX + green, (int)(startY + (.5 * blue)), 1, 1);

			}
		}
	}

	private void drawCurrentColor(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect(350, 650, 80, 80);
	}
}
