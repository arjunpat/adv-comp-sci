import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import articles.*;

public class Runner extends View {

	private HashTable<Article> hashTable = new HashTable<Article>();

	public Runner() {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				hashTable.add(new Grass(i * 40, j * 40));
			}
		}

		for (int i = 0; i < 20; i++) {
			for (int j = 10; j < 20; j++) {
				hashTable.add(new Dirt(i * 40, j * 40));
			}
		}

	}

	public void draw(Graphics g) {

		DLList<Article>[] table = hashTable.getTable();

		for (int i = 0; i < table.length; i++) {
			DLList<Article> each = table[i];
			for (int j = 0; j < each.size(); j++) {
				each.get(j).draw(g);
			}
		}

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