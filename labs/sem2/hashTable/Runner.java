import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Runner extends View {

	public Runner() {

	}

	public void draw(Graphics g) {

		drawGrid(g);

	}

	private void drawGrid(Graphics g) {

		g.setColor(Color.BLACK);

		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				g.drawRect(c * 40, r * 40, 40, 40);
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Scenery Grid");

		frame.add(new Runner());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}