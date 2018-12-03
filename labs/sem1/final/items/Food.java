import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Food {

	private Image picture = Toolkit.getDefaultToolkit().getImage("images/food.png");

	public Food(int x, int y) {
		super.x = x;
		super.y = y;
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(picture, x, y, s);
	}

}