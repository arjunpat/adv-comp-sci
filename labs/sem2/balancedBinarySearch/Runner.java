import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Runner extends View {
	private BinarySearchTree<Item> tree = new BinarySearchTree<Item>();

	public Runner() {
		tree.add(new Item("Bread", 40));
		tree.add(new Item("Milk", 40));
		tree.add(new Item("Carrot", 40));
		tree.add(new Item("Apple", 40));
		tree.add(new Item("Goods", 40));
		tree.add(new Item("Milkshake", 40));
		tree.add(new Item("Cream", 40));
		tree.add(new Item("Computer", 40));
		tree.add(new Item("Plug", 40));
		tree.add(new Item("Table", 40));
		tree.add(new Item("Floor", 40));
	}

	public void draw(Graphics g) {

		tree.draw(g, 800, 800);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Lab");
		frame.add(new Runner());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}