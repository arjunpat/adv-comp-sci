import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Square {
	private int size;
	private Color color;

	public Square(int size) {
		this.size = size;
		this.color = Color.WHITE;
	}

	public void draw(Graphics g, int x, int y) {

		g.setColor(this.color);
		g.fillRect(x, y, size, size);

		g.setColor(Color.BLACK);
		g.drawRect(x, y, size, size);
	}

	public void changeColor(Color c) {
		this.color = c;
	}

	public Color getColor() {
		return this.color;
	}

	public Square clone() {
		Square temp = new Square(this.size);
		temp.changeColor(this.color);

		return temp;
	}
}
