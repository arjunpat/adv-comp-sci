package atoolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public abstract class View extends JPanel {

	public Color green = new Color(79, 255, 146);
	public Color white = new Color(255, 255, 255);
	public Color purple = new Color(192, 179, 224);
	public Color lblue = new Color(176, 224, 230);
	public Color blue = new Color(0, 0, 255);
	public Color red = new Color(255, 0, 0);
	public Color black = new Color(0, 0, 0);
	public Color yellow = new Color(244, 236, 8);
	public Color dblue = new Color(30, 144, 255);
	public Color red1 = new Color(242, 106, 117);
	public Color yellow1 = new Color(249, 228, 89);

	public final int WINDOW_WIDTH = 800;
	public final int WINDOW_HEIGHT = 800;

	public final int LEFT_BORDER_SPACING = 20;
	public final int RIGHT_BORDER_SPACING = 20;

	public int VERTICAL_COMP_SPACING = 20;

	private int fromTopLeft = 0;
	private int fromTopRight = 0;
	
	public View() {
		this.setLayout(null);
		this.setFocusable(true);
	}

	public Dimension getPreferredSize() {
		return new Dimension(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
	}

	public final void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(white);
		g.fillRect(0, 0, this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
		this.draw(g);
	}

	public void addToLeft(Component com) {
		Dimension d = com.getPreferredSize();
		this.addToLeft(com, (int)d.getWidth(), (int)d.getHeight());
	}

	public void addSpaceToLeft(int height) {
		fromTopLeft += height;
	}

	public void addToRight(Component com) {
		Dimension d = com.getPreferredSize();
		this.addToRight(com, (int)d.getWidth(), (int)d.getHeight());
	}

	public void addSpaceToRight(int height) {
		fromTopRight += height;
	}

	public void addToLeft(Component com, int width, int height) {
		fromTopLeft += VERTICAL_COMP_SPACING;

		int x = LEFT_BORDER_SPACING;
		int y = fromTopLeft;

		com.setBounds(x, y, width, height);
		fromTopLeft += com.getHeight();

		this.add(com);
	}

	public void addToRight(Component com, int width, int height) {
		fromTopRight += VERTICAL_COMP_SPACING;

		int x = WINDOW_WIDTH - (width + RIGHT_BORDER_SPACING);
		int y = fromTopRight;

		com.setBounds(x, y, width, height);
		fromTopRight += com.getHeight();

		this.add(com);
	}

	public void setVerticalComponentSpacing(int space) {
		VERTICAL_COMP_SPACING = space;
	}

	public void drawTitle(Graphics g, Color c, String text, int x, int y) {
		g.setColor(black);
		g.setFont(new Font("Tahoma", Font.PLAIN, 24));
		g.drawString(text, x, y);
		g.setColor(c);
		g.fillRect(x, y + 5, (int)(text.length() * 11.2), 3);
	}

	public void drawBigTitle(Graphics g, Color c, String text, int x, int y) {
		g.setColor(black);
		g.setFont(new Font("Tahoma", Font.PLAIN, 36));
		g.drawString(text, x, y);
		g.setColor(c);
		g.fillRect(x, y + 5, text.length() * 18, 4);
	}

	public abstract void draw(Graphics g);
}
