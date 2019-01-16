import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public abstract class View extends JPanel {

	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 800;
	
	public View() {
		this.setLayout(null);
		this.setFocusable(true);
	}

	public Dimension getPreferredSize() {
		return new Dimension(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
	}

	public final void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
		this.draw(g);
	}

	protected void drawTitle(Graphics g, Color c, String text, int x, int y) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 24));
		g.drawString(text, x, y);
		g.setColor(c);
		g.fillRect(x, y + 5, (int)(text.length() * 11.2), 3);
	}

	protected void drawBigTitle(Graphics g, Color c, String text, int x, int y) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 36));
		g.drawString(text, x, y);
		g.setColor(c);
		g.fillRect(x, y + 5, text.length() * 18, 4);
	}

	public abstract void draw(Graphics g);
}
