import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Number {
	private String text;
	private int x = 250;
	private int y = 400;
	private boolean show = true;

	public final static int FINAL_Y = 200;

	public final static int ANIMATE_WAIT_TIME = 10;


	public Number(String text) {
		this.text = text;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void increment() {
		y -= 2;
	}

	public void draw(Graphics g) {
		if (show) {
			double percentCompleted;

			if (y - FINAL_Y > 100) {
				percentCompleted = 1;
			} else {
				percentCompleted = (y - FINAL_Y) / 100.0;
			}

			g.setColor(new Color(255, 255, 255, (int)(255 * percentCompleted)));
			g.setFont(new Font("Tahoma", Font.PLAIN, (int)(75 * percentCompleted)));
			g.drawString(text, (int)(x + ((1 - percentCompleted) * 60)), y);
		}
	}

	public void setEnabled(boolean show) {
		this.show = show;
	}
}