import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Screen extends View {

	private final int SQUARE_SIZE = 15;
	private final int GRID_SIZE = 37;
	private Stack<Square[][]> history = new Stack<Square[][]>();
	private Square[][] current;
	private Color currentColor = new Color(0, 0, 0);

	public Screen() {
		super();

		this.current = new Square[GRID_SIZE][GRID_SIZE];
		for (int r = 0; r < this.current.length; r++) {
			for (int c = 0; c < this.current[0].length; c++) {
				this.current[r][c] = new Square(SQUARE_SIZE);
			}
		}
		history.push(this.current);
		this.current = cloneGrid(this.current);

		JButton undoButton = new JButton("Undo");
		undoButton.setBounds(600, 100, 175, 100);
		undoButton.addActionListener(e -> {
			undo();
			repaint();
		});
		this.add(undoButton);

		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				System.out.println("Moused released at (" + x + ", " + y + ")");

				// if they want to change color
				if (x > 20 && x < 20 + 255 && y > 650 && y < 650 + 128) {
					currentColor = new Color(255, x - 20, 2 * (y - 650));
				} else {

					int r = (int)((y - 20) / SQUARE_SIZE);
					int c = (int)((x - 20) / SQUARE_SIZE);

					addToHistory(r, c, currentColor);

				}

				repaint();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				System.out.println("Mouse dragged at (" + x + ", " + y + ")");

				int r = (int)((y - 20) / SQUARE_SIZE);
				int c = (int)((x - 20) / SQUARE_SIZE);

				if (r < GRID_SIZE && c < GRID_SIZE && r >= 0 && c >= 0)
					current[r][c].changeColor(currentColor);

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

	private void addToHistory(int r, int c, Color color) {
		if (r < GRID_SIZE && c < GRID_SIZE && r >= 0 && c >= 0) {
			this.current[r][c].changeColor(color);
			history.push(this.current);
			this.current = this.cloneGrid(this.current);
			System.out.println("Saved " + history.size());
		}
	}

	private void undo() {
		if (history.size() > 1) {
			history.pop();
			this.current = this.cloneGrid(history.peek());
		}
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
				toDraw[r][c].draw(g, 20 + (SQUARE_SIZE * c), 20 + (SQUARE_SIZE * r));
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
